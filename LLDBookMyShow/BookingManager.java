import java.util.List;

public class BookingManager {
    private SeatManager seatManager;

    public BookingManager(SeatManager seatManager) {
        this.seatManager = seatManager;
    }

    public void addSeatToSession(UserBookingSession session, int seatNo) {
        Seat seat = seatManager.getSeat(seatNo);
        if (!seatManager.SeatCheck(seat)) {
            System.out.println("❌ Seat unavailable.");
            return;
        }
        seatManager.updateSeatStatus(seat, seatStatus.BUSY);
        session.getSelectedSeats().add(seat);
        System.out.println("✅ Seat added.");
    }

    public void removeSeatFromSession(UserBookingSession session, int seatNo) {
        List<Seat> selectedSeats = session.getSelectedSeats();
        Seat seat = seatManager.getSeat(seatNo);
        if (!selectedSeats.contains(seat)) {
            System.out.println("⚠️ Seat not in selection.");
            return;
        }
        selectedSeats.remove(seat);
        seatManager.updateSeatStatus(seat, seatStatus.EMPTY);
        System.out.println("✅ Seat removed.");
    }

    public void processPayment(UserBookingSession session, PaymentManager paymentManager) {
        System.out.println("💳 Proceeding to payment...");

        boolean hasUnavailableSeats = false;
        for (Seat seat : session.getSelectedSeats()) {
            if (!seatManager.verifySeat(seat)) {
                if (!hasUnavailableSeats) {
                    System.out.println("⚠️ The following seats are unavailable:");
                }
                System.out.print(seat.getSeatNumber() + " ");
                hasUnavailableSeats = true;
            }
        }

        if (hasUnavailableSeats) {
            System.out.println("\n⚠️ Please remove unavailable seats before proceeding.");
            return;
        }

        if (paymentManager.pay(session.getSelectedSeats()) == paymentStatus.SUCCESS) {
            for (Seat seat : session.getSelectedSeats()) {
                seatManager.updateSeatStatus(seat, seatStatus.BOOKED);
            }
            System.out.println("🎉 Payment successful! Seats are now booked.");
            session.getSelectedSeats().clear();
        } else {
            System.out.println("❌ Payment failed.");
        }
    }
}
