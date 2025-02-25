package tournament.data;

import tournament.exceptions.GameModeException;

public class MixedTournament extends Tournament
{
    private String gameMode;

    public MixedTournament(String name, String game, double price, String gameMode)
    {
        super(name, game, price);
        this.gameMode = gameMode;
    }

    public void comproveGameMode(String gameMode) throws GameModeException
    {
        if (!(gameMode.equalsIgnoreCase("1v1") || gameMode.equalsIgnoreCase("5v5")))
        {
            throw new GameModeException("The available game modes are 1v1 or 5v5.");
        }
        else
        {
            this.gameMode = gameMode;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "GameMode: " + gameMode;
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
