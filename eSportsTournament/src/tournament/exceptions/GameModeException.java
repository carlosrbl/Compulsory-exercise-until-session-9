/**
 * @author Adrian
 * This exception checks if the game mode is the correct one (1v1 or 5v5).
 */

package tournament.exceptions;

public class GameModeException extends Exception {
    public GameModeException(String message) {
        super(message);
    }
}

