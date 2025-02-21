package tournament.data;

public class TeamTournament extends Tournament
{
    private int playersPerTeam;

    public TeamTournament(String name, String game, double price, int playersPerTeam)
    {
        super(name, game, price);
        this.playersPerTeam = playersPerTeam;
    }

    @Override
    public String toString() {
        return "TeamTournament " + name + " (" + game + ") - People: " + playersPerTeam + " - Price: " + price +"€";
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
