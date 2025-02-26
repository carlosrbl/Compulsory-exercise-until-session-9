package tournament.data;

public abstract class Tournament
{
    protected String name;
    protected String game;
    protected double prize;

    public Tournament(String name, String game, double prize)
    {
        this.name = name;
        this.game = game;
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "Tournament - " + name + " - (" + game + ") - Prize: " + prize + "€";
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getGame()
    {
        return game;
    }

    public void setGame(String game)
    {
        this.game = game;
    }

    public double getPrize()
    {
        return prize;
    }

    public void setPrize(double prize)
    {
        this.prize = prize;
    }
}
