package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends AbstractSpaceShip {
	private int cargoCapacity;
	private int passengerCapacity;
	private static final int BASICMAINTENCECOST = 3000;

	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
	}
	
	public int getCargoCapacity() {
		return cargoCapacity;
	}
	
	public int getPassengerCapacity() {
		return passengerCapacity;
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		return TransportShip.BASICMAINTENCECOST + 5*cargoCapacity + 3*passengerCapacity;
	}
	
	@Override
	public String toString() {
		return "TransportShip" + System.lineSeparator() + super.toString() + System.lineSeparator() 
				+ "\tAnnualMaintenanceCost=" + getAnnualMaintenanceCost() + System.lineSeparator() + "\tCargoCapacity=" 
				+ getCargoCapacity() + System.lineSeparator() + "\tPassengerCapacity=" + getPassengerCapacity();
	}
	
}
