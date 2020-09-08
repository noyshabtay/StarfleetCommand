package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends AbstractBattleship {
	
	private static final int BASICMAINTENCECOST = 2500;
	
	public Fighter(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		int ans = super.getAnnualMaintenanceCost();
		ans += Fighter.BASICMAINTENCECOST;
		ans += 1000*maximalSpeed;
		return ans;
	}
	
	public int getWeaponsAnnualMaintenanceCost() {
		return super.getAnnualMaintenanceCost();
	}
	
	@Override
	public String toString() {
		return "Fighter"+ System.lineSeparator() + super.toString() + System.lineSeparator() + "\tAnnualMaintenanceCost="
				+ getAnnualMaintenanceCost() + System.lineSeparator() + "\tWeaponArray=" + getWeapon();
	}

	
}
