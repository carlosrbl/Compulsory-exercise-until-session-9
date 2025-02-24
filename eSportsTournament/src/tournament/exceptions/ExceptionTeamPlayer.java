package tournament.exceptions;

import tournament.data.Player;

public class ExceptionTeamPlayer {
    public static void quantityOfPlayers(Player[] players) throws IndexOutOfBoundsException
    {
        if (!(players.length >= 2 && players.length <= 5))
        {
            throw new IndexOutOfBoundsException ("The team has to have minimum 2 players and maximum 5");
        }
    }
}
