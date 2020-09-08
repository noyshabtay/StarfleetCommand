package il.ac.tau.cs.sw1.ex9.starfleet;

public class CrewWoman extends AbstractCrewMember{
	
	public CrewWoman(int age, int yearsInService, String name){
		super(age, yearsInService, name);
	}
	
	@Override
	public String toString() {
		return "CrewWoman" + super.toString();
	}

}
