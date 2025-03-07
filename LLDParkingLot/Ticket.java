import java.time.LocalDateTime;

public class Ticket {
    private LocalDateTime parkingDate;
    private String vehicleColor;
    private String registrationNo;
    private int spotNo;

    public Ticket(String vehicleColor, String registrationNo, int spotNo) {
        this.vehicleColor = vehicleColor;
        this.registrationNo = registrationNo;
        this.spotNo = spotNo;
        this.parkingDate = LocalDateTime.now();
    }

    public LocalDateTime getParkingDate() {
        return parkingDate;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public int getSpotNo() {
        return spotNo;
    }
}
