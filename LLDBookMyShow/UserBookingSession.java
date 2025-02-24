import java.util.ArrayList;
import java.util.List;

public class UserBookingSession {
    //seatManager
    //Booking Manager
    //Payment Manager
    private BookingManager bookingManager;
    //show to select hogya
    private Show show
    List<Seat> selectedSeats;
    //dependency inversion has to be followed, not optional

    public UserBookingSession(Show show,BookingManager bookingManager){
        this.show = show;
        this.bookingManager = bookingManager;
        List<Seat> selectedSeats = new ArrayList<>();
        Start();
    }

    public void Start(){
        //INTERFACE


    }

    //add seat
    //remove Seat
    //do i need a explicit Cart ?
//better readability

    public void addSeat(int seatNo){
        selectedSeats.add(show.getSeat(seatNo));
    }

    public void removeSeat(int seatNo){
       selectedSeats.remove(show.getSeat(seatNo));
    }

    //payment karwao using booking manager


    //seatUpadtes karwao using booking manager





    //jaise hi ye start hoga ek objecgt banega aur end hoga


}
