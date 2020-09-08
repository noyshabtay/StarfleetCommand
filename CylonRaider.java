package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CylonRaider extends Fighter {
	
	private static final int BASICMAINTENCECOST = 3500;

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers.stream().map(x->(CrewMember)x).collect(Collectors.toSet()), weapons);
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		int ans = super.getWeaponsAnnualMaintenanceCost(); //weapons cost
		ans += CylonRaider.BASICMAINTENCECOST; //basic cost
		ans += 500*crewMembers.size(); //crew cost
		ans += 1200*maximalSpeed; //engines cost
		return ans;
	}
	
	@Override
	public String toString() {
		return "CylonRaider" + System.lineSeparator() + super.toString().substring(9);
	}

}
