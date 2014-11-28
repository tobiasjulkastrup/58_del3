package board;

public class FleetOwner {
	
	public String[] fleetOwner;

	public FleetOwner(int fleetsAmount){
		
		fleetOwner = new String[fleetsAmount];
		
	}
	
	public void setFleetOwner(int fleetNumb, String Owner){
		
		fleetOwner[fleetNumb-1] = Owner;
		
	}
	
	public String getFleetOwner(int fleetNumb){
		
		return fleetOwner[fleetNumb-1];
		
	}
	
}
