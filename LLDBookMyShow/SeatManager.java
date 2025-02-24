
public class SeatManager {
    private Show show;

    public SeatManager(Show show){this.show = show;};

    public synchronized void  updateSeatStatus(Seat seat,seatStatus newStatus){
            seat.setStatus(newStatus);
    }

    public boolean verifySeat(Seat seat){
         if(seat.getStatus() != seatStatus.BUSY)return false;
         return true;
    }

    public boolean SeatCheck(Seat seat){
        if(seat.getStatus() != seatStatus.EMPTY)return false;
        return true;
    }

    public Seat getSeat(int seatNo){
        return show.getSeat(seatNo);
    }
    //seat manager should have access to show

}
