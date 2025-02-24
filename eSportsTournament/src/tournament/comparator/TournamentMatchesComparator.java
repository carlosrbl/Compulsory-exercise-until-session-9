package tournament.comparator;

import tournament.data.Match;

import java.util.Comparator;

public class TournamentMatchesComparator implements Comparator<Match>
{
    @Override
    public int compare(Match o1, Match o2) {
        return o1.getTournament().getName().compareToIgnoreCase(o2.getTournament().getName());
    }
}
