import java.util.List;

public class SeatManager {
    private List<Seat> selectedSeats;

    public SeatManager(List<Seat> selectedSeats){
        this.selectedSeats = selectedSeats;
    };

    public synchronized void  updateSeats(seatStatus newStatus){
        for(Seat seat : selectedSeats){
            seat.updateStatus(newStatus);
        }
    }

    public boolean verifySeats(){
       for(Seat seat : selectedSeats){
           if(seat.getStatus() != seatStatus.EMPTY)return false;
       }
       //throw custom error
       return true;
    };

    public void updateSelectedSeats(List<Seat> selectedSeats){
        this.selectedSeats = selectedSeats;
    };
}
