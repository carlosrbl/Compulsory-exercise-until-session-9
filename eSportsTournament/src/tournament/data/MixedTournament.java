package tournament.data;

public class MixedTournament extends Tournament
{
    private String gameMode;

    public MixedTournament(String name, String game, double price, String gameMode)
    {
        super(name, game, price);
        this.gameMode = gameMode;
    }

    @Override
    public String toString() {
        return "TeamTournament " + name + " (" + game + ") - GameMode: " + gameMode + " - Price: " + price +"€";
    }

    public String getGameMode()
    {
        return gameMode;
    }

    public void setGameMode(String gameMode)
    {
        this.gameMode = gameMode;
    }
}
