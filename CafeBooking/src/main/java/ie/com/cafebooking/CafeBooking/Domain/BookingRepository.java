package ie.com.cafebooking.CafeBooking.Domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository <Booking, Long> {
    Booking getReferenceById(Long id);
}


