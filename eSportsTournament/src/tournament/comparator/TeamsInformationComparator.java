package tournament.comparator;

import tournament.data.Team;

import java.util.Comparator;

public class TeamsInformationComparator implements Comparator<Team>
{
    @Override
    public int compare(Team o1, Team o2) {
        return Float.compare(o1.getAverageTeamRanking(), o2.getAverageTeamRanking());
    }
}
