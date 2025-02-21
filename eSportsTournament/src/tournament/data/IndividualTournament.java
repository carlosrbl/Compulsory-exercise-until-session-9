package tournament.data;

public class IndividualTournament extends Tournament
{
    public IndividualTournament(String name, String game, double price)
    {
        super(name, game, price);
    }

    @Override
    public String toString()
    {
        return "IndividualTournament " + name + " (" + game + ") - Price: " + price +"€";
    }
}
