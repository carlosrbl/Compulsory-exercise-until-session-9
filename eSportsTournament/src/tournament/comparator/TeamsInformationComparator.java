/**
 * @author Carlos
 * This class contains the comparator for team class
 */

package tournament.comparator;

import tournament.data.Team;

import java.util.Comparator;

public class TeamsInformationComparator implements Comparator<Team>
{
    /**
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a team ordered
     */
    @Override
    public int compare(Team o1, Team o2) {
        return Float.compare(o1.getAverageTeamRanking(), o2.getAverageTeamRanking());
    }
}
