public class BookingManager {
    private SeatManager seatManager;
    private PaymentManager paymentManager;

    public BookingManager(SeatManager seatManager,PaymentManager paymentManager){
        this.seatManager = seatManager;
        this.paymentManager = paymentManager;
    }

}
