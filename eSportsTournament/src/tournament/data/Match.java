package tournament.data;

public class Match
{
    Tournament tournament;
    Player participant1;
    Player participant2;
    String result = "Pending";

    public Match(Tournament tournament,Player parcipant1,Player participant2,String result)
    {
        this.tournament = tournament;
        this.participant1 = participant1;
        this.participant2 = participant2;
        this.result = result;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public Player getParticipant1() {
        return participant1;
    }

    public Player getParticipant2() {
        return participant2;
    }

    public String getResult() {
        return result;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public void setParticipant1(Player participant1) {
        this.participant1 = participant1;
    }

    public void setParticipant2(Player participant2) {
        this.participant2 = participant2;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return tournament.toString() + " -" + participant1.getName() + participant2.getName() + "-" + "Result:" + result;
    }


}
