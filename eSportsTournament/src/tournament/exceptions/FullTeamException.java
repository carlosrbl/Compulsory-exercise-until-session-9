package tournament.exceptions;

import tournament.data.Player;

public class FullTeamException extends Exception {
    public FullTeamException(String message) {
        super(message);
    }

    public static void quantityOfPlayers(Player[] players) {
    }
}
