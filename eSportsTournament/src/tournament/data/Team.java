package tournament.data;
import tournament.exceptions.*;
public class Team extends Participant{
    Player[] players;

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
        catch (InterruptedException e)
        {
            System.err.println(e);
        }
        this.players = players;
    }
}
