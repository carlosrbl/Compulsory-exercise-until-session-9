package tournament.data;
import tournament.exceptions.*;
public class Team extends Participant{
    private Player[] players;
    private float averageTeamRanking;
    public Team(String name, Player[] players) {
        super(name);
        this.players = players;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
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

    public void addPlayer(Player p) throws FullTeamException
    {
        if (players.length <= 5)
        {
            throw new FullTeamException("The number of players are minimum 2 and maximum 5");
        }
        else
        {
            players[numberOfMembers()] = p;
        }
    }

    @Override
    public String toString()
    {
        return "Team " + super.toString() + " - " + "Members: " + numberOfMembers()+"/"
                + players.length + ": " +showPlayers();
    }
}
