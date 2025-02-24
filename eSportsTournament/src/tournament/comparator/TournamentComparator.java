package tournament.comparator;

import tournament.data.Tournament;

import java.util.Comparator;

public class TournamentComparator implements Comparator<Tournament>
{
    @Override
    public int compare(Tournament o1, Tournament o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
