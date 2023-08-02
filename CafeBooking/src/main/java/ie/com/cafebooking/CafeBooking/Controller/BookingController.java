package ie.com.cafebooking.CafeBooking.Controller;

import ie.com.cafebooking.CafeBooking.Domain.Booking;
import ie.com.cafebooking.CafeBooking.Domain.BookingInfo;
import ie.com.cafebooking.CafeBooking.Domain.EditBookingInfo;
import ie.com.cafebooking.CafeBooking.Domain.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingRepository repository;

    // Show booking form page
    @GetMapping("/form")
    public String showFormPage(Long id, Model model){
        if (id != null){
            var booking = repository.getReferenceById(id);
            model.addAttribute("booking", booking);
        }
        return "bookings/form";
    }

    // Show list of bookings
    @GetMapping
    public String showListPage(Model model) {
        model.addAttribute("list", repository.findAll());
        return "bookings/list";
    }

    // Book a cafe
    @PostMapping
    public String bookCafe(BookingInfo info) {
        var booking = new Booking(info);
        repository.save(booking);
        return "redirect:/bookings";
    }

    // Edit a booking
    @PutMapping
    @Transactional
    public String editBooking(EditBookingInfo info) {
        var booking = repository.getReferenceById(info.id());
        booking.updateInfo(info);
        return "redirect:/bookings";
    }

    // Delete a booking
    @DeleteMapping
    @Transactional
    public String deleteBooking(Long id){
        repository.deleteById(id);
        return "redirect:/bookings";
    }
}


