package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public abstract class AbstractSpaceShip implements Spaceship, Comparable<Spaceship> {
	protected String name;
	protected int commissionYear;
	protected float maximalSpeed;
	protected Set<CrewMember> crewMembers;
	protected static final int BASICFIRECONSTANT = 10;
	
	public AbstractSpaceShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers) {
		this.name = name;
		this.commissionYear = commissionYear;
		this.maximalSpeed = maximalSpeed;
		this.crewMembers = crewMembers;
	}

	@Override
	public int compareTo(Spaceship o) {
		if(this.getFirePower() == o.getFirePower()) {
			if(this.getCommissionYear() == o.getCommissionYear())
				return this.getName().compareTo(o.getName());
			return ((Integer)o.getCommissionYear()).compareTo((Integer)this.getCommissionYear());
		}
		return ((Integer)o.getFirePower()).compareTo((Integer)this.getFirePower());
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getCommissionYear() {
		return commissionYear;
	}

	@Override
	public float getMaximalSpeed() {
		return maximalSpeed;
	}

	@Override
	public int getFirePower() {
		return AbstractSpaceShip.BASICFIRECONSTANT; //BASICFIRECONSTANT is static.
	}

	@Override
	public Set<? extends CrewMember> getCrewMembers() {
		return crewMembers;
	}

	@Override //eclipse auto-made.
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override //eclipse auto-made.
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractSpaceShip other = (AbstractSpaceShip) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "\tName=" + getName() + System.lineSeparator() + "\tCommissionYear=" + getCommissionYear()
		+ System.lineSeparator() + "\tMaximalSpeed=" + getMaximalSpeed() + System.lineSeparator()
		+ "\tFirePower=" + getFirePower() + System.lineSeparator() 
		+ "\tCrewMembers=" + getCrewMembers().size();
	}
	
}
