public class EntryManager {
    private ParkingLot parkingLot;

    public EntryManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    // Handles the full parking process
    public Ticket park(Vehicle vehicle) {
        int spotNo = parkingLot.allotSpot(vehicle);
        if (spotNo == -1) return null; // No space available
        return generateTicket(vehicle, spotNo);
    }

    // Separates ticket creation logic
    private Ticket generateTicket(Vehicle vehicle, int spotNo) {
        return new Ticket(vehicle.getColor(), vehicle.getRegistrationNo(), spotNo);
    }
}
