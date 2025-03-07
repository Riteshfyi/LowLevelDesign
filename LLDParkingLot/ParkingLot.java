public class ParkingLot {
    private EntryManager entryManager;
    private ExitManager exitManager;
    private ParkingArea parkingArea;

    public ParkingLot(EntryManager entryManager,ExitManager exitManager,ParkingArea parkingArea){
        this.entryManager = entryManager;
        this.exitManager = exitManager;
        this.parkingArea = parkingArea;
    }

    public Ticket putVehicle(Vehicle vehicle){
        entryManager.park(vehicle);
    };

    public void getVehicle(Ticket ticket){
        exitManager.unpark(ticket);
    }

}
