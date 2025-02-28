/**
 * @author Carlos
 * This abstract class contains tournaments
 */

package tournament.data;

public class TeamTournament extends Tournament
{
    private int playersPerTeam;

    public TeamTournament(String name, String game, double prize, int playersPerTeam)
    {
        super(name, game, prize);
        this.playersPerTeam = playersPerTeam;
    }
    /**
     * @return tournament parameters
     */
    @Override
    public String toString() {
        return "Team" + super.toString() + " - People: " + playersPerTeam;
    }
    /**
     * @return parameter
     */
    public int getPlayersPerTeam()
    {
        return playersPerTeam;
    }

    /**
     * @param playersPerTeam
     */
    public void setPlayersPerTeam(int playersPerTeam)
    {
        this.playersPerTeam = playersPerTeam;
    }
}
