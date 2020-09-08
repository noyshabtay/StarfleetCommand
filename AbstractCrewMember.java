package il.ac.tau.cs.sw1.ex9.starfleet;

public class AbstractCrewMember implements CrewMember {
	protected String name;
	protected int age;
	protected int yearsInService;
	
	public AbstractCrewMember (int age, int yearsInService, String name) {
		this.age = age;
		this.yearsInService = yearsInService;
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getAge() {
		return age;
	}
	
	@Override
	public int getYearsInService() {
		return yearsInService;
	}
	
	@Override
	public String toString() {
		return System.lineSeparator() + "\tName=" + this.getName() + System.lineSeparator() 
				+ "\tAge="+this.getAge() + System.lineSeparator() + "\tYearsInService=" 
				+ this.getYearsInService();
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
		AbstractCrewMember other = (AbstractCrewMember) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
