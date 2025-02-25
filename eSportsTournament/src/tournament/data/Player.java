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

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        comproveLevel(level);
    }

    public float getRanking()
    {
        return ranking;
    }

    public void setRanking(float ranking)
    {
        this.ranking = ranking;
    }

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

    @Override
    public String toString()
    {
        return "Player: " + super.toString() + " - " +
                "Level: " + level + " - " + "Ranking: "+ranking;
    }

}
