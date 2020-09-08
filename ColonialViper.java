package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ColonialViper extends Fighter {
	
	private static final int BASICMAINTENCECOST = 4000;

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		//casting must be made to determine that Crew members are human.
		super(name, commissionYear, maximalSpeed, crewMembers.stream().map(x->(CrewMember)x).collect(Collectors.toSet()), weapons);
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		int ans = super.getWeaponsAnnualMaintenanceCost(); //weapons cost
		ans += ColonialViper.BASICMAINTENCECOST; //basic cost
		ans += 500*crewMembers.size(); //crew cost
		ans += 500*maximalSpeed; //engines cost
		return ans;
	}
	
	@Override
	public String toString() {
		return "ColonialViper" + System.lineSeparator() + super.toString().substring(9);
	}
}
