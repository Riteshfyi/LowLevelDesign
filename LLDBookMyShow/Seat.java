public class Seat {
    private int seatNumber;
    private seatStatus status;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.status = seatStatus.EMPTY; // Default status
    }

    public seatStatus getStatus() {
        return status;
    }

    public void setStatus(seatStatus newStatus) {
        this.status = newStatus;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}
