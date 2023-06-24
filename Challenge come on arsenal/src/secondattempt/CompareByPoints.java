package secondattempt;

import java.util.Comparator;

public class CompareByPoints implements Comparator<Team> {

	@Override
	public int compare(Team o1, Team o2) {
		// TODO Auto-generated method stub
		return o2.getPoints()-o1.getPoints();
	}

}
