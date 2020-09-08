package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter {
	
	private static final List<Weapon> basicWeapon = new ArrayList<Weapon>(Arrays.asList(new Weapon("Laser Cannons", 10, 100)));
	private static int NUMOFENGINES = 0;

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		StealthCruiser.NUMOFENGINES++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		this(name, commissionYear, maximalSpeed, crewMembers, StealthCruiser.basicWeapon);
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		int ans = super.getAnnualMaintenanceCost();
		ans += 50*StealthCruiser.NUMOFENGINES;
		return ans;
	}
	
	@Override
	public String toString() {
		return "StealthCruiser" + System.lineSeparator() + super.toString().substring(9);
	}

	
}
