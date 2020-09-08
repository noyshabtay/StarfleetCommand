package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends AbstractBattleship {
	
	private int numberOfTechnicians;
	private static final int BASICMAINTENCECOST = 5000;
	
	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
	}
	
	public int getNumberOfTechnicians() {
		return numberOfTechnicians;
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		int ans = super.getAnnualMaintenanceCost();
		ans = (int) Math.round(((double)ans)*(1-((double)numberOfTechnicians)/10));
		return ans + Bomber.BASICMAINTENCECOST;
	}
	
	@Override
	public String toString() {
		return "Bomber" + System.lineSeparator() + super.toString() + System.lineSeparator() + "\tAnnualMaintenanceCost=" 
				+ getAnnualMaintenanceCost() + System.lineSeparator() + "\tWeaponArray=" + getWeapon()
				+ System.lineSeparator() + "\tNumberOfTechnicians=" + getNumberOfTechnicians();
	}


}
