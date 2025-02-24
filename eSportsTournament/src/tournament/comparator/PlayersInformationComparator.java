package tournament.comparator;

import tournament.data.Player;

import java.util.Comparator;

public class PlayersInformationComparator implements Comparator<Player>
{
    @Override
    public int compare(Player o1, Player o2) {
        return Float.compare(o1.getRanking(), o2.getRanking()) == 0
                ? o1.getName().compareToIgnoreCase(o2.getName()) :
                Float.compare(o1.getRanking(), o2.getRanking());
    }
}