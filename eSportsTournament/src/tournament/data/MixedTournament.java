/**
 * @author Carlos
 * This abstract class contains tournaments
 */

package tournament.data;

import tournament.exceptions.GameModeException;

public class MixedTournament extends Tournament
{
    private String gameMode;

    public MixedTournament(String name, String game, double prize, String gameMode)
    {
        super(name, game, prize);
        this.gameMode = gameMode;
    }

    /**
     * Comprove if the gameMode is correct
     * @param gameMode
     * @throws GameModeException
     */
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
    /**
     * @return tournament parameters
     */
    @Override
    public String toString() {
        return "Mixed" + super.toString() + " - GameMode: " + gameMode;
    }

    /**
     * @return parameter
     */
    public String getGameMode()
    {
        return gameMode;
    }

    /**
     * @param gameMode
     */
    public void setGameMode(String gameMode)
    {
        this.gameMode = gameMode;
    }
}
