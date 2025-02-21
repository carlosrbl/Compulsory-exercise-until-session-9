package tournament.data;

import tournament.data.Participant;

public class Player extends Participant {
    private int level;
    private float ranking;

    public Player(String name, int level, float ranking) {
        super(name);
        this.level = level;
        this.ranking = ranking;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
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

    public float getRanking() {
        return ranking;
    }

    public void setRanking(float ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "Player: "+super.toString()+" - "+
                "Level: "+level+" - "+"Ranking: "+ranking;
    }

}
