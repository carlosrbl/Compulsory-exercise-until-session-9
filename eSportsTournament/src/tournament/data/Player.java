/**
 * @author Adrian
 * This class inherits from participant, and has the level and the ranking of the player.
 */

package tournament.data;

import tournament.data.*;

public class Player extends Participant
{
    private int level;
    private float ranking;

    public Player(String name, int level, float ranking)
    {
        super(name);
        comproveLevel(level);
        this.ranking = ranking;
    }

    /**
     * @return This returns the level of the player.
     */

    public int getLevel()
    {
        return level;
    }

    /**
     * @param level It sets the level of the player.
     */

    public void setLevel(int level)
    {
        comproveLevel(level);
    }

    /**
     * @return This returns the ranking of the player.
     */

    public float getRanking()
    {
        return ranking;
    }

    /**
     * @param ranking This sets the ranking of the player
     */

    public void setRanking(float ranking)
    {
        this.ranking = ranking;
    }

    /**
     * @param level It takes the level and checks if the level is above 100 or below 0.
     */

    public void comproveLevel(int level)
    {
        if (level >= 100)
        {
            this.level = 100;
        }
        else
        {
            if (level <= 0)
            {
                this.level = 0;
            }
            else {
                this.level = level;
            }
        }
    }

    /**
     * @return This returns the name, the level, and the rank of the player.
     */

    @Override
    public String toString()
    {
        return "Player: " + super.toString() + " - " +
                "Level: " + level + " - " + "Ranking: "+ranking;
    }

}
