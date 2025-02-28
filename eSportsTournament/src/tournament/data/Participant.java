/**
 * @author Adrian
 * This class it is the parent of the Player and the Team classes
 */

package tournament.data;

public abstract class Participant {
    protected String name;

    public Participant(String name) {
        this.name = name;
    }

    /**
     * @return This returns the name of the participant.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name This sets the name of the new team or player.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return This returns the name of the participant, which is used in the children classes.
     */
    @Override
    public String toString() {
        return name;
    }
}
