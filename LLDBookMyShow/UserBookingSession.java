import java.util.ArrayList;
import java.util.List;

public class UserBookingSession {
    private List<Seat> selectedSeats;
    private final BookingManager bookingManager;

    public UserBookingSession(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
        this.selectedSeats = new ArrayList<>();
    }

    public List<Seat> getSelectedSeats() {
        return selectedSeats;
    }

    public void addSeat(int seatNo) {
        bookingManager.addSeatToSession(this, seatNo);
    }

    public void removeSeat(int seatNo) {
        bookingManager.removeSeatFromSession(this, seatNo);
    }

    public void processPayment(PaymentManager paymentManager) {
        bookingManager.processPayment(this, paymentManager);
    }
}
