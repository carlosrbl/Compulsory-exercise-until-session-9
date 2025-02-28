/**
 * @author Adrian
 * This exception checks if the team has more than 5 players in it.
 */
package tournament.exceptions;


public class FullTeamException extends Exception {
    public FullTeamException(String message) {
        super(message);
    }
}
