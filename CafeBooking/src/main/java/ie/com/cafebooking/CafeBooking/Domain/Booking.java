package ie.com.cafebooking.CafeBooking.Domain;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cafeName;
    private String quantity;
    private String date;
    private String timeSlot;

    public Booking(BookingInfo info) {
        this.cafeName = info.cafeName();
        this.quantity = info.quantity();
        this.date = info.date();
        this.timeSlot = info.timeSlot();
    }

    public Booking(){}
    public String getCafeName() {
        return cafeName;
    }

    public void setCafeName(String cafeName) {
        this.cafeName = cafeName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Booking {" +
                ", cafeName='" + cafeName + '\'' +
                ", quantity='" + quantity + '\'' +
                ", date='" + date + '\'' +
                ", timeSlot='" + timeSlot + '\'' +
                '}';
    }

    public void updateInfo(EditBookingInfo info) {
        this.cafeName = info.cafeName();
        this.quantity = info.quantity();
        this.date = info.date();
        this.timeSlot = info.timeSlot();
    }
}



