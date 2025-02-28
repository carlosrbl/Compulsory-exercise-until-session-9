package tournament.data;

public class IndividualTournament extends Tournament
{
    public IndividualTournament(String name, String game, double prize)
    {
        super(name, game, prize);
    }
    /**
     * @return tournament parameters
     */
    @Override
    public String toString() {
        return "Individual" + super.toString();
    }
}
