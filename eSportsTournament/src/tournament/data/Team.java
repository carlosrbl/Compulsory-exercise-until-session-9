package tournament.data;
import tournament.exceptions.*;
public class Team extends Participant{
    Player[] players;
    float averageTeamRanking;
    public Team(String name, Player[] players) {
        super(name);
        comprovePlayers(players);
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public void comprovePlayers (Player[] players)
    {
        try {
            ExceptionTeamPlayer.quantityOfPlayers(players);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.err.println(e.getMessage());
        }
        this.players = players;
    }

    public int numberOfMembers()
    {
        int count = 0;
        for (int i=0;i< players.length;i++)
        {
            if (players[i] != null)
            {
                count++;
            }
        }
        return count;
    }

    public String showPlayers()
    {
        String allPlayers="";
        for (int i=0;i<players.length;i++)
        {
            if (i== players.length-1)
            {
                allPlayers+= players[i];
            }
            else
            {
                allPlayers += players[i]+"-";
            }
        }
        return allPlayers;
    }
    public float getAverageTeamRanking()
    {
        float average=0;
        for(int i=0;i< numberOfMembers();i++)
        {
            average+=players[i].getRanking();
        }

        averageTeamRanking = average/numberOfMembers();
        return averageTeamRanking;
    }
    @Override
    public String toString()
    {
        return super.toString()+" - "+"Members: "+numberOfMembers()+"/"
                +players.length+":"+showPlayers();
    }
}
