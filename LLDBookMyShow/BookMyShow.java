import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BookMyShow implements Runnable {
    public BookMyShow(){

    }

    @Override
    public void run(){
        List<Screen> screens = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        screens.add(new Screen("Action", Arrays.asList(
                new Show(5, 5, new Movie("Mad Max Fury Road", "2h10m"), "10:00 AM"),
                new Show(5, 5, new Movie("John Wick 4", "2h30m"), "01:00 PM"),
                new Show(5, 5, new Movie("Gladiator", "2h35m"), "04:30 PM"),
                new Show(5, 5, new Movie("The Dark Knight", "2h45m"), "07:15 PM"),
                new Show(5, 5, new Movie("Inception", "2h28m"), "10:00 PM"),
                new Show(5, 5, new Movie("Mission Impossible 7", "2h20m"), "12:00 AM"),
                new Show(5, 5, new Movie("Fast & Furious 9", "2h10m"), "03:00 PM"),
                new Show(5, 5, new Movie("The Equalizer 3", "2h05m"), "06:45 PM"),
                new Show(5, 5, new Movie("Die Hard", "2h12m"), "09:30 PM"),
                new Show(5, 5, new Movie("The Batman", "2h55m"), "11:30 PM")
        )));

        screens.add(new Screen("Comedy", Arrays.asList(
                new Show(5, 5, new Movie("The Hangover", "1h50m"), "09:30 AM"),
                new Show(5, 5, new Movie("Step Brothers", "1h45m"), "11:45 AM"),
                new Show(5, 5, new Movie("Superbad", "1h53m"), "02:00 PM"),
                new Show(5, 5, new Movie("Dumb and Dumber", "1h47m"), "04:15 PM"),
                new Show(5, 5, new Movie("Anchorman", "1h58m"), "06:30 PM"),
                new Show(5, 5, new Movie("21 Jump Street", "1h49m"), "08:45 PM"),
                new Show(5, 5, new Movie("The Big Lebowski", "2h00m"), "10:50 PM"),
                new Show(5, 5, new Movie("Zombieland", "1h55m"), "12:15 AM"),
                new Show(5, 5, new Movie("Napoleon Dynamite", "1h36m"), "02:40 PM"),
                new Show(5, 5, new Movie("Ted", "1h46m"), "05:00 PM")
        )));

        screens.add(new Screen("Horror", Arrays.asList(
                new Show(30, 60, new Movie("The Conjuring", "2h05m"), "08:00 AM"),
                new Show(28, 60, new Movie("Insidious", "1h45m"), "10:30 AM"),
                new Show(32, 60, new Movie("Hereditary", "2h07m"), "01:00 PM"),
                new Show(29, 60, new Movie("It", "2h15m"), "03:30 PM"),
                new Show(34, 60, new Movie("The Exorcist", "2h00m"), "06:00 PM"),
                new Show(31, 60, new Movie("A Quiet Place", "1h40m"), "08:30 PM"),
                new Show(27, 60, new Movie("Halloween", "1h50m"), "10:45 PM"),
                new Show(33, 60, new Movie("The Nun", "1h56m"), "12:00 AM"),
                new Show(35, 60, new Movie("Paranormal Activity", "1h40m"), "02:15 AM"),
                new Show(30, 60, new Movie("The Ring", "1h55m"), "04:30 AM")
        )));

        screens.add(new Screen("Sci-Fi", Arrays.asList(
                new Show(60, 120, new Movie("Interstellar", "2h49m"), "09:00 AM"),
                new Show(55, 120, new Movie("The Matrix", "2h16m"), "12:30 PM"),
                new Show(50, 120, new Movie("Blade Runner 2049", "2h44m"), "04:00 PM"),
                new Show(53, 120, new Movie("Dune", "2h35m"), "07:30 PM"),
                new Show(5, 5, new Movie("Avatar", "2h42m"), "10:45 PM"),
                new Show(5, 5, new Movie("Inception", "2h28m"), "01:30 AM"),
                new Show(5, 5, new Movie("Star Wars: A New Hope", "2h01m"), "03:50 AM"),
                new Show(5, 5, new Movie("Guardians of the Galaxy", "2h06m"), "06:10 AM"),
                new Show(5, 5, new Movie("E.T. the Extra-Terrestrial", "1h55m"), "08:30 AM"),
                new Show(5, 5, new Movie("The Martian", "2h24m"), "10:45 AM")
        )));

        Theatre theatre = new Theatre(screens);

        System.out.println("Welcome to BookMyShow");
        System.out.println("Select Your Screen");
        for(int i = 0; i < 4 ; i++){
            System.out.println("Screen" + (i+1) + " :" + screens.get(i).genre);
        }

        int choice = scanner.nextInt();
        choice--;
        Screen selectedScreen = screens.get(choice);
        List<Show> shows = selectedScreen.getShows();

        System.out.println("Select Your Show");
        for(int i = 0; i < 10 ; i++){
            System.out.println((i+1) + "." + shows.get(i).getdetails());
        }
        choice = scanner.nextInt();

        Show show = shows.get(choice - 1);

        BookingUI bookingUI = new BookingUI(new BookingManager(new SeatManager(show)),new PaymentManager(new PaymentStrategy()),show);
        bookingUI.startSession();


    }
}

