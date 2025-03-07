import java.util.PriorityQueue;
import java.util.ArrayList;

public class ParkingArea {
    private int capacity;
    private ArrayList<ParkingSpot> parkingSpots;
    private PriorityQueue<Integer> freeSlots;
    public ParkingArea(int capacity){
        this.capacity = capacity;
        parkingSpots=  new ArrayList<>();
        freeSlots = new PriorityQueue<>();
        for(int i  = 1;i<=capacity;i++){
            parkingSpots.add(new ParkingSpot(i));
            freeSlots.add(i);
        }
    }
    public int getNearestSlot(){
        if(freeSlots.isEmpty())return -1;
        return freeSlots.poll();
    }

    public Boolean isSlotFull(){
        return freeSlots.isEmpty();
    }

    public int ParkVehicle(Vehicle vehicle){
        if(isSlotFull() == true)return -1;
        int spotNo = getNearestSlot();
        ParkingSpot parkingSpot = parkingSpots.get(spotNo - 1);
        parkingSpot.parkVehicle(vehicle);
        freeSlots.remove(spotNo);
        return spotNo;
    }
    public void UnparkVehicle(int slotNo){
        //slotNo is 1 - based indexed
        if(slotNo < 0 || slotNo > capacity)return;
        ParkingSpot parkingSpot = parkingSpots.get(slotNo - 1);
        parkingSpot.Unpark();
        return;
    }


}
