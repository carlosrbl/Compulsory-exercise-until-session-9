/**
 * @author Adrian
 * This class inherits from Participant and has an association with the class player, by using an array from players.
 */

package tournament.data;
import tournament.exceptions.*;
public class Team extends Participant{
    private Player[] players = new Player[5];
    private float averageTeamRanking;
    public Team(String name, Player[] players) {
        super(name);
        comprovePlayers(players);
    }

    /**
     * @return This returns the players that compose the team.
     */

    public Player[] getPlayers() {
        return players;
    }

    /**
     *
     * @param index This is an integer to specify wich one of the players we want to return.
     * @return This returns one player by specificating it by the parameter index.
     */

    public Player getPlayer(int index) {
        return players[index];
    }

    /**
     * @param players This sets the players of the team.
     */

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    /**
     * @param players This checks if the introduced players are correct.
     */

    public void comprovePlayers(Player[] players)
    {
        for(int i = 0; i < players.length; i++)
        {
            this.players[i] = players[i];
        }
    }

    /**
     * @return This returns the amount of players of the team.
     */

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

    /**
     * This is used in the string.
     * @return It returns a string of all the players to use it in the toString method.
     */
    public String showPlayers()
    {
        String allPlayers="";
        for (int i=0;i<numberOfMembers();i++)
        {

            if (players[i] != null)
            {
                if (i== numberOfMembers()-1)
                {
                    allPlayers+= players[i];
                }
                else
                {
                    allPlayers += players[i]+" - ";
                }
            }
        }
        return allPlayers;
    }

    /**
     * @return This returns the average ranking of the team.
     */
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

    /**
     *
     * @param p
     * @throws FullTeamException
     */

    public void addPlayer(Player p) throws FullTeamException
    {
        if (numberOfMembers() >= 5)
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
