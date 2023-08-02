package ie.com.cafebooking.CafeBooking;

import ie.com.cafebooking.CafeBooking.Controller.BookingController;
import ie.com.cafebooking.CafeBooking.Domain.Booking;
import ie.com.cafebooking.CafeBooking.Domain.BookingInfo;
import ie.com.cafebooking.CafeBooking.Domain.BookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// Test Class Definition
class TestBookingController {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingController bookingController;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    // Test the showFormPage method when there is an existing booking
    @Test
    void testShowFormPageWithExistingBooking() {
        // Prepare the test data
        Long bookingId = 1L;
        BookingInfo bookingInfo = new BookingInfo("Starbucks - George Street", "2023-07-28", "2", "12:00");
        Booking booking = new Booking(bookingInfo);
        when(bookingRepository.getReferenceById(bookingId)).thenReturn(booking);

        // Execute the method being tested
        String result = bookingController.showFormPage(bookingId, model);

        // Verify the method's behavior and outcome
        assertEquals("bookings/form", result);
        verify(model).addAttribute(eq("booking"), eq(booking));
        verifyNoMoreInteractions(model);
    }

    // Test the showFormPage method when the booking ID is null
    @Test
    void testShowFormPageWithNullBookingId() {
        // Execute the method being tested
        String result = bookingController.showFormPage(null, model);

        // Verify the method's behavior and outcome
        assertEquals("bookings/form", result);
        verifyNoMoreInteractions(model);
        verifyNoMoreInteractions(bookingRepository);
    }

    // Test the bookCafe method
    @Test
    void testBookCafe() {
        // Prepare the test data
        BookingInfo bookingInfo = new BookingInfo("Starbucks - George Street", "2023-07-28", "2", "12:00");

        // Execute the method being tested
        String result = bookingController.bookCafe(bookingInfo);

        // Verify the method's behavior and outcome
        assertEquals("redirect:/bookings", result);
        verify(bookingRepository).save(any(Booking.class));
        verifyNoMoreInteractions(bookingRepository);
    }

    // Test the deleteBooking method
    @Test
    void testDeleteBooking() {
        // Prepare the test data
        Long bookingId = 1L;

        // Execute the method being tested
        String result = bookingController.deleteBooking(bookingId);

        // Verify the method's behaviour and outcome
        assertEquals("redirect:/bookings", result);
        verify(bookingRepository).deleteById(bookingId);
        verifyNoMoreInteractions(bookingRepository);
    }
}
