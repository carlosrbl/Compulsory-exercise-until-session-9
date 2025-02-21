package tournament.exceptions;

import tournament.data.Player;

public class ExceptionTeamPlayer {
    public static void quantityOfPlayers(Player[] players) throws InterruptedException
    {
        if (!(players.length >= 2 && players.length <= 5))
        {
            throw new InterruptedException ("The team has to have minimum 2 players and maximum 5");
        }
    }
}
