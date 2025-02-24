import java.util.Scanner;

public class BookingUI {
    private Scanner scanner;
    private BookingManager bookingManager;
    private PaymentManager paymentManager;
    private Show show;

    public BookingUI(BookingManager bookingManager, PaymentManager paymentManager, Show show) {
        this.scanner = new Scanner(System.in);
        this.bookingManager = bookingManager;
        this.paymentManager = paymentManager;
        this.show = show;
    }

    public void startSession() {
        UserBookingSession session = new UserBookingSession(bookingManager);

        while (true) {
            System.out.println("\n--- Booking Menu ---");
            System.out.println("1. Add a seat");
            System.out.println("2. Remove a seat");
            System.out.println("3. Proceed to Payment");
            System.out.println("4. Show Selected Seats");
            System.out.println("5. Show All Seats");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter seat number to add: ");
                    int addSeatNo = scanner.nextInt();
                    session.addSeat(addSeatNo);
                    break;

                case 2:
                    System.out.print("Enter seat number to remove: ");
                    int removeSeatNo = scanner.nextInt();
                    session.removeSeat(removeSeatNo);
                    break;

                case 3:
                    session.processPayment(paymentManager);
                    break;

                case 4:
                    showSelectedSeats(session);
                    break;

                case 5:
                    show.printSeats();
                    break;

                case 6:
                    System.out.println("Exiting booking session...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showSelectedSeats(UserBookingSession session) {
        if (session.getSelectedSeats().isEmpty()) {
            System.out.println("No seats selected yet.");
            return;
        }
        System.out.print("🪑 Selected seats: ");
        for (Seat seat : session.getSelectedSeats()) {
            System.out.print(seat.getSeatNumber() + " ");
        }
        System.out.println();
    }
}
