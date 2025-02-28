/**
 * @author Carlos
 * This class contains the comparator for match class
 */

package tournament.comparator;

import tournament.data.Match;

import java.util.Comparator;

public class TournamentMatchesComparator implements Comparator<Match>
{
    /**
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return match ordered
     */
    @Override
    public int compare(Match o1, Match o2) {
        return o1.getTournament().getName().compareToIgnoreCase(o2.getTournament().getName());
    }
}
