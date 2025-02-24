public class Show {
    private Seat[][] seats;
    private Movie movie;
    private Time startTime;
    //i can take time as a string or movie to a new Class
    public Show(int m, int n, Movie movie,Time startTime) {
        seats = new Seat[m][n];
        this.movie = movie;
        this.startTime = startTime;
        for(int i = 0; i < seats.length; i++){
            for(int j = 0; j < seats[0].length ; j++){
                seats[i][j].setSeatNumber(i+j+1);
            }
        }
    }

    public void printSeats(){
        for(int i = 0; i < seats.length; i++){
            for(int j = 0; j < seats[0].length ; j++){
                 System.out.print(seats[i][j].getSeatNumber() + "," + seats[i][j].getStatus().name() + " ");
            }
            System.out.println();
        }
    }

    public Seat getSeat(int seatId){
        //add paramet check
        return seats[seatId/seats.length][seatId%seats.length];
    }



}
