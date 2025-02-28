/**
 * @author Carlos
 * This class contains the comparator for player class
 */

package tournament.comparator;

import tournament.data.Player;

import java.util.Comparator;

public class PlayersInformationComparator implements Comparator<Player>
{
    /**
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a player ordered
     */
    @Override
    public int compare(Player o1, Player o2) {
        return Float.compare(o1.getRanking(), o2.getRanking()) == 0
                ? o1.getName().compareToIgnoreCase(o2.getName()) :
                Float.compare(o1.getRanking(), o2.getRanking());
    }
}