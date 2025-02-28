/**
 * @author Miguel
 *
 * This is the class that initializes the objects Match,it has his own constructor and getters and setters for all his atributes
 * and also contains his own method toString() to show all his characteristics
 */

package tournament.data;

public class Match
{
    private Tournament tournament;
    private Player participant1;
    private Player participant2;
    private String result;

    /**
     * @return This function create the match with the parameters that gets
     */

    public Match(Tournament tournament,Player participant1,Player participant2)
    {
        this.tournament = tournament;
        this.participant1 = participant1;
        this.participant2 = participant2;
        result = "Pending";
    }

    /**
     * @return This function returns the tournament
     */

    public Tournament getTournament()
    {
        return tournament;
    }

    /**
     * @return This function returns the first participant
     */

    public Player getParticipant1()
    {
        return participant1;
    }

    /**
     * @return This function returns the second participant
     */

    public Player getParticipant2()
    {
        return participant2;
    }

    /**
     * @return This function returns the result
     */

    public String getResult()
    {
        return result;
    }

    /**
     * @return This function sets the result for the Match that calls the method
     */

    public void setTournament(Tournament tournament)
    {
        this.tournament = tournament;
    }

    /**
     * @return This function sets the first participant for the Match that calls the method
     */

    public void setParticipant1(Player participant1)
    {
        this.participant1 = participant1;
    }

    /**
     * @return This function sets the second participant for the Match that calls the method
     */

    public void setParticipant2(Player participant2)
    {
        this.participant2 = participant2;
    }

    /**
     * @return This function sets the result for the Match that calls the method
     */

    public void setResult(String result)
    {
        this.result = result;
    }

    /**
     * @return This method makes it possible for the entire object to be displayed in different ways.
     */

    @Override
    public String toString() {
        return tournament.getName() + " - " + participant1.getName() + " vs. "+ participant2.getName() + " - " + "Result: " + result;
    }


}
