package tournament.data;

public abstract class Tournament
{
    protected String name;
    protected String game;
    protected double price;

    public Tournament(String name, String game, double price)
    {
        this.name = name;
        this.game = game;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tournament " + name + " (" + game + ") , Price: " + price + "€";
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

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
