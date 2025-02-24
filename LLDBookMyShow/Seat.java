public class Seat {
    private int seatNumber;
    private seatStatus status;
    public Seat(){};
    //setter
    public void updateStatus(seatStatus newStatus){
        this.status = newStatus;
    }
    //getter
    public seatStatus getStatus(){
        return this.status;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber){
        this.seatNumber = seatNumber;
    }
}
