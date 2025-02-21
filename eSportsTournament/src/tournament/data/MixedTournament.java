public class MixedTournament extends Tournament
{
    String gameMode;

    public MixedTournament(String name, String game, double price, String gameMode)
    {
        super(name, game, price);
        this.gameMode = gameMode;
    }

    @Override
    public String toString() {
        return
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
