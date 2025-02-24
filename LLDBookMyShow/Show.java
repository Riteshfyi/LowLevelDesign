public class Show {
    private Seat[][] seats;
    private Movie movie;
    private String startTime;
    //i can take time as a string or movie to a new Class
    public Show(int m, int n, Movie movie,String startTime) {
        seats = new Seat[m][n];
        this.movie = movie;
        this.startTime = startTime;
        for(int i = 0; i < seats.length; i++){
            for(int j = 0; j < seats[0].length ; j++){
                seats[i][j] = new Seat(i * seats[0].length + j + 1); 
                // seats[i][j].setSeatNumber();
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
        return seats[seatId/seats.length][seatId%seats.length];
    }

    public String getdetails(){String details = movie.name + ", " + movie.duration +", " + startTime;
    return details;}

}
