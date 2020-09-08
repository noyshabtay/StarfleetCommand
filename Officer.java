package il.ac.tau.cs.sw1.ex9.starfleet;

/**
 * @author noy_s
 * Although it was more comfortable to set Officer Class extends AbstractCrewMember Class,
 * I chose it to extend CrewWoman Class for making an "is-a" relationship between all human crew. 
 */
public class Officer extends CrewWoman{
	
	private OfficerRank rank;
	
	public Officer(String name, int age, int yearsInService, OfficerRank rank) {
		super(age, yearsInService, name);
		this.rank = rank;
		
	}
	
	public OfficerRank getRank() {
		return this.rank;
	}
	
	@Override
	public String toString() {
		return "Officer" + super.toString().substring(9) 
				+ System.lineSeparator() + "\tRank=" + this.getRank();
	}
	
}
