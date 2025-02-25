package tournament.data;

public class IndividualTournament extends Tournament
{
    public IndividualTournament(String name, String game, double prize)
    {
        super(name, game, prize);
    }

    @Override
    public String toString() {
        return "IndividualTournament - " + name + " (" + game + ") - Prize: " + prize + "€";
    }
}
