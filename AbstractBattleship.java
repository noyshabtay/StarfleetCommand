package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractBattleship extends AbstractSpaceShip {
	
	protected List<Weapon> weapons;
	
	public AbstractBattleship(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.weapons = weapons;
	}
	
	public List<Weapon> getWeapon() {
		return weapons;
	}
	
	@Override
	public int getFirePower() {
		int ans = super.getFirePower(); //adding BASICFIRECONSTANT.
		ans += weapons.stream()
								.map(x->x.getFirePower())
								.collect(Collectors.summingInt(x->x));
		return ans;
	}
	
	public int getAnnualMaintenanceCost() {
		int ans = weapons.stream()
				.map(x->x.getAnnualMaintenanceCost())
				.collect(Collectors.summingInt(x->x));
		return ans;
	}
}
