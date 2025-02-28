/**
 * @author Carlos
 * This class contains the comparator for tournament class
 */

package tournament.comparator;

import tournament.data.Tournament;

import java.util.Comparator;

public class TournamentComparator implements Comparator<Tournament>
{
    /**
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return tournament ordered
     */
    @Override
    public int compare(Tournament o1, Tournament o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
