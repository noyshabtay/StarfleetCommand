package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		return fleet.stream()
							.sorted((x,y)->x.compareTo(y))
							.map(x->x.toString())
							.collect(Collectors.toList());
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String,Integer> ans = new HashMap<>();
		for (Spaceship s : fleet) {
			String name = s.getClass().getSimpleName();
			if (ans.containsKey(name))
				ans.put(name, ans.get(name) + 1);
			else
				ans.put(name, 1);
		}
		return ans;
	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		return fleet.stream().collect(Collectors.summingInt(x->x.getAnnualMaintenanceCost()));
	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> ans = new HashSet<>(); //Set removes duplicates automatically.
		//all classes inherit the same AbstractBattleship.getWeapon() function.
		for (Spaceship s : fleet) {
			if (s instanceof AbstractBattleship) {
				for (Weapon w : ((AbstractBattleship) s).getWeapon()) {
					ans.add(w.getName());
				}
			}
		}
		return ans;
	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		return fleet.stream()
							.map(x->x.getCrewMembers())
							.map(x->x.size())
							.collect(Collectors.summingInt(x->x));
	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		int nominator = 0;
		int denominator = 0;
		for(Spaceship s : fleet) {
			for(CrewMember p : s.getCrewMembers()) {
				if(p.getClass().equals(Officer.class)) {
					nominator += p.getAge();
					denominator++;
				}
			}
		}
		return ((float)nominator)/((float)denominator);
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer, Spaceship> ans = new HashMap<>();
		Map<OfficerRank, Officer> tmp = new HashMap<>();
		OfficerRank max = null;
		for (Spaceship s : fleet) {
			for (CrewMember p : s.getCrewMembers()) {
				if (p.getClass().equals(Officer.class)) {
					if (max == null || max.compareTo(((Officer)p).getRank()) < 0) {
						max = ((Officer)p).getRank();
						tmp.clear();
						tmp.put(((Officer)p).getRank(), (Officer)p);
					}
				}
			}	
			if (max != null)
				ans.put(tmp.get(max), s);
			max = null;	
		}
		return ans;
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank,Integer> historam = new HashMap<>();
		OfficerRank rank;
		for (Spaceship s : fleet) {
			for (CrewMember p : s.getCrewMembers()) {
				if (p.getClass().equals(Officer.class)) {
					rank = ((Officer)p).getRank();
					if (historam.containsKey(rank))
						historam.put(rank, historam.get(rank) + 1);
					else
						historam.put(rank, 1);
				}
			}
		}
		List<Map.Entry<OfficerRank, Integer>> ans = new ArrayList<>(historam.entrySet());
		ans.sort(new Comparator<Map.Entry<OfficerRank, Integer>>() {
			@Override
			public int compare(Entry<OfficerRank, Integer> o1, Entry<OfficerRank, Integer> o2) {
				if (o1.getValue().equals(o2.getValue()))
					return o1.getKey().compareTo(o2.getKey());
				else
					return o1.getValue().compareTo(o2.getValue());
			}
		});
		return ans;
	}

}
