package tournament.data;

public class TeamTournament extends Tournament
{
    private int playersPerTeam;

    public TeamTournament(String name, String game, double prize, int playersPerTeam)
    {
        super(name, game, prize);
        this.playersPerTeam = playersPerTeam;
    }

    @Override
    public String toString() {
        return "Team" + super.toString() + " - People: " + playersPerTeam;
    }

    public int getPlayersPerTeam()
    {
        return playersPerTeam;
    }

    public void setPlayersPerTeam(int playersPerTeam)
    {
        this.playersPerTeam = playersPerTeam;
    }
}
