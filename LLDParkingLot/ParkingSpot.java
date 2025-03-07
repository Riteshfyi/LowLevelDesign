public class ParkingSpot {
    private int spotNo;
    private Vehicle parkedVehicle;
    public ParkingSpot(int spotNo){
        this.spotNo = spotNo;
        parkedVehicle = null;
    }

    public boolean isSpotEmpty(){
        return parkedVehicle == null;
    }
    public void parkVehicle(Vehicle toBeParked){
        this.parkedVehicle = toBeParked;
    }
    public void Unpark(){
        this.parkedVehicle = null;
    }
}
