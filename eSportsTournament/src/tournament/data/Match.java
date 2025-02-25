package tournament.data;

public class Match
{
    private Tournament tournament;
    private Player participant1;
    private Player participant2;
    private String result;

    public Match(Tournament tournament,Player participant1,Player participant2)
    {
        this.tournament = tournament;
        this.participant1 = participant1;
        this.participant2 = participant2;
        result = "Pending";
    }

    public Tournament getTournament()
    {
        return tournament;
    }

    public Player getParticipant1()
    {
        return participant1;
    }

    public Player getParticipant2()
    {
        return participant2;
    }

    public String getResult()
    {
        return result;
    }

    public void setTournament(Tournament tournament)
    {
        this.tournament = tournament;
    }

    public void setParticipant1(Player participant1)
    {
        this.participant1 = participant1;
    }

    public void setParticipant2(Player participant2)
    {
        this.participant2 = participant2;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    @Override
    public String toString() {
        return tournament.getName() + " - " + participant1.getName() + " vs. "+ participant2.getName() + " - " + "Result: " + result;
    }


}
