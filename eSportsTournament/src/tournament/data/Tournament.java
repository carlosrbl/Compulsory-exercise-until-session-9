/**
 * @author Carlos
 * This abstract class contains tournaments
 */
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

    /**
     * @return tournament parameters
     */
    @Override
    public String toString() {
        return "Tournament - " + name + " - (" + game + ") - Prize: " + prize + "€";
    }
    /**
     * @return parameter
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * @return parameter
     */
    public String getGame()
    {
        return game;
    }

    /**
     * @param game
     */
    public void setGame(String game)
    {
        this.game = game;
    }
    /**
     * @return parameter
     */
    public double getPrize()
    {
        return prize;
    }

    /**
     * @param prize
     */
    public void setPrize(double prize)
    {
        this.prize = prize;
    }
}
