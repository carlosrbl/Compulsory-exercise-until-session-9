/**
 * @author Miguel,Adrian,Carlos
 *
 * This is the class that that initializes all the clases to control them,it has his own constructor and getters and setters for all his atributes
 * and also contains his own method toString() to show all his characteristics.
 */
package tournament.main;

import tournament.comparator.PlayersInformationComparator;
import tournament.comparator.TeamsInformationComparator;
import tournament.comparator.TournamentComparator;
import tournament.comparator.TournamentMatchesComparator;
import tournament.data.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class TournamentManager
{
    Player[]  registeredPlayer;
    Team[] registeredTeam;
    Tournament[] registeredTournament;
    Match[] registeredMatch;

    int registeredPlayerIndex;
    int registeredTeamIndex;
    int registeredTournamentIndex;
    int registeredMatchIndex;

    /**
     * @return This is the constructor of the class
     */

    public TournamentManager()
    {
        registeredPlayer = new Player[20];
        registeredTeam = new Team[10];
        registeredTournament = new Tournament[6];
        registeredMatch = new Match[5];

        registeredPlayerIndex = 10;
        registeredTeamIndex = 5;
        registeredTournamentIndex = 3;
        registeredMatchIndex = 3;
    }

    /**
     * @return This method sets all the players ,teams, tournamets and matches to start to show all the request of the menu
     */

    public void initialize()
    {
        initializePlayers();
        initializeTeam();
        initializeTournament();
        initializeMatch();
    }

    /**
     * @return This method creates new players
     */

    public void initializePlayers()
    {
        registeredPlayer[0] = new Player("Alejandro",12,453.1f);
        registeredPlayer[1] = new Player("Valeria",19,483.1f);
        registeredPlayer[2] = new Player("Mateo",52,899.0f);
        registeredPlayer[3] = new Player("Isabella",91,222.2f);
        registeredPlayer[4] = new Player("Santiago",23,532.2f);
        registeredPlayer[5] = new Player("Camila",99,222.2f);
        registeredPlayer[6] = new Player("Leonardo",38,753.3f);
        registeredPlayer[7] = new Player("Sofía",71,463.99f);
        registeredPlayer[8] = new Player("Andrés",88,441.1f);
        registeredPlayer[9] = new Player("Elena",4,82701.54f);
    }

    /**
     * @return This method creates new Teams
     */

    public void initializeTeam()
    {
        registeredTeam[0] = new Team("Eucaliptos",new Player []{registeredPlayer[0],registeredPlayer[1]});
        registeredTeam[1] = new Team("Aristogatos",new Player []{registeredPlayer[2],registeredPlayer[3]});
        registeredTeam[2] = new Team("Los Thunderman", new Player []{registeredPlayer[4],registeredPlayer[5]});
        registeredTeam[3] = new Team("Los Tragaperras",new Player []{registeredPlayer[6],registeredPlayer[7]});
        registeredTeam[4] = new Team("Los Amateurs",new Player []{registeredPlayer[8],registeredPlayer[9]});
    }

    /**
     * @return This method creates new Tournaments
     */

    public void initializeTournament()
    {
        registeredTournament[0] = new TeamTournament("LOL tournament","League Of Legends",1000,4);
        registeredTournament[1] = new IndividualTournament("Splatton vs Inklings","Splatoon",2000);
        registeredTournament[2] = new MixedTournament("War of craft","StarCraft2",5000,"1v1");

    }

    /**
     * @return This method creates new matches,but it secures that in a match you cant play with another person of the same team
     */

    public void initializeMatch()
    {
        Random rand = new Random();
        Team t1;
        Team t2;

        for (int i=0;i<registeredMatchIndex;i++)
        {
            do
            {
                t1 = registeredTeam[rand.nextInt(0, registeredTeamIndex)];
                t2 = registeredTeam[rand.nextInt(0, registeredTeamIndex)];
            }
            while(t1.getName().equals(t2.getName()));
            registeredMatch[i] = new Match(registeredTournament[rand.nextInt(0, registeredTournamentIndex)],
                    t1.getPlayer(rand.nextInt(0,t1.numberOfMembers())), t2.getPlayer(rand.nextInt(0,t2.numberOfMembers())));
        }
    }

    /**
     * @return This method find a player
     */

    public Player findPlayer(String username)
    {

        for(int i=0;i<registeredPlayerIndex;i++)
        {
            if(registeredPlayer[i].getName().equals(username))
            {
                return registeredPlayer[i];
            }
        }
        return null;
    }

    /**
     * @return This method find a team
     */

    public Team findTeam(String teamName)
    {
        for(int i=0;i<registeredTeam.length;i++)
        {
            if(registeredTeam[i].getName().equals(teamName))
            {
                return registeredTeam[i];
            }
        }
        return null;
    }

    /**
     * @return This method show all the tournaments
     */

    public void showTournaments()
    {
        for(int i=0;i<registeredTournament.length;i++)
        {
            System.out.println(registeredTournament[i].toString());
        }
    }

    /**
     * @return This function returns the players array
     */

    public Player[] getRegisteredPlayer() {
        return registeredPlayer;
    }

    /**
     * @return This method add a new Player to registeredPlayer
     */

    public void addPlayer(Player player) {


        if(registeredPlayerIndex < registeredPlayer.length)
        {
            registeredPlayer[registeredPlayerIndex] = player;
            registeredPlayerIndex++;
        }
        else
        {
            System.out.println("There is no more space");
        }

    }

    /**
     * @return This method returns the players array
     */

    public Team[] getRegisteredTeam() {
        return registeredTeam;
    }

    /**
     * @return This method add a new Team to registeredTeam
     */

    public void addTeam(Team team) {

        if(registeredTeamIndex < registeredTeam.length)
        {
            registeredTeam[registeredTeamIndex] = team;
            registeredTeamIndex++;
        }
        else
        {
            System.out.println("There is no more space");
        }
    }

    /**
     * @return This method returns the tournaments array
     */

    public Tournament[] getRegisteredTournament() {
        return registeredTournament;
    }

    /**
     * @return This method add a new tournament to registeredTournament
     */

    public void addTournament(Tournament tournament) {

        if(registeredTournamentIndex < registeredTournament.length)
        {
            registeredTournament[registeredTournamentIndex] = tournament;
            registeredTournamentIndex++;
        }
        else
        {
            System.out.println("There is no more space");
        }
    }

    /**
     * @return This method returns the matchs array
     */

    public Match[] getRegisteredMatch() {
        return registeredMatch;
    }

    /**
     * @return This method add a new match to registeredMatch
     */


    public void addMatch(Match match) {

        if(registeredMatchIndex < registeredMatch.length)
        {
            registeredMatch[registeredMatchIndex] = match;
            registeredMatchIndex++;
        }
        else
        {
            System.out.println("There is no more space");
        }
    }

    /**
     * @return This method order the tournaments by its names in three different ways
     */

    public void tournamentsOrdered()
    {
        //Use a class that implements Comparator
        Arrays.sort(registeredTournament,0,registeredTournamentIndex,new TournamentComparator());
        for (int i=0;i<registeredTournamentIndex;i++)
        {
            System.out.println(registeredTournament[i]);
        }
        System.out.println();
        //Use an anonymous class
        Arrays.sort(registeredTournament, 0, registeredTournamentIndex, new Comparator<Tournament>() {
            @Override
            public int compare(Tournament o1, Tournament o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (int i=0;i<registeredTournamentIndex;i++)
        {
            System.out.println(registeredTournament[i]);
        }
        System.out.println();
        //Use a lambda expression (only Mari Chelo's group)
        Arrays.sort(registeredTournament, 0, registeredTournamentIndex,((o1, o2) ->  o1.getName().compareToIgnoreCase(o2.getName())));
        for (int i=0;i<registeredTournamentIndex;i++)
        {
            System.out.println(registeredTournament[i]);
        }

        /**
         * @return This method order the player firstly by its ranking and secondly by its names in three different ways
         */

    }
    public void playersOrdered()
    {
        //Use a class that implements Comparator
        Arrays.sort(registeredPlayer,0,registeredPlayerIndex,new PlayersInformationComparator());
        for (int i=0;i<registeredPlayerIndex;i++)
        {
            System.out.println(registeredPlayer[i]);
        }
        System.out.println();
        //Use an anonymous class
        Arrays.sort(registeredPlayer, 0, registeredPlayerIndex, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return Float.compare(o1.getRanking(), o2.getRanking()) == 0
                        ? o1.getName().compareToIgnoreCase(o2.getName()) :
                        Float.compare(o1.getRanking(), o2.getRanking());
            }
        });
        for (int i=0;i<registeredPlayerIndex;i++)
        {
            System.out.println(registeredPlayer[i]);
        }
        System.out.println();
        //Use a lambda expression (only Mari Chelo's group)
        Arrays.sort(registeredPlayer, 0, registeredPlayerIndex,
                ((o1, o2) ->
                        Float.compare(o1.getRanking(), o2.getRanking()) == 0
                                ? o1.getName().compareToIgnoreCase(o2.getName()) :
                                Float.compare(o1.getRanking(), o2.getRanking())));
        for (int i=0;i<registeredPlayerIndex;i++)
        {
            System.out.println(registeredPlayer[i]);
        }
    }

    /**
     * @return This method order the teams by the average ranking of the team in 3 different ways
     */

    public void teamsOrdered()
    {
        //Use a class that implements Comparator
        Arrays.sort(registeredTeam,0,registeredTeamIndex,new TeamsInformationComparator());
        for (int i=0;i<registeredTeamIndex;i++)
        {
            System.out.println(registeredTeam[i]);
        }
        System.out.println();
        //Use an anonymous class
        Arrays.sort(registeredTeam, 0, registeredTeamIndex, new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                return Float.compare(o1.getAverageTeamRanking(), o2.getAverageTeamRanking());
            }
        });
        for (int i=0;i<registeredTeamIndex;i++)
        {
            System.out.println(registeredTeam[i]);
        }
        System.out.println();
        //Use a lambda expression (only Mari Chelo's group)
        Arrays.sort(registeredTeam, 0, registeredTeamIndex,((o1, o2) ->
                Float.compare(o1.getAverageTeamRanking(), o2.getAverageTeamRanking())));
        for (int i=0;i<registeredTeamIndex;i++)
        {
            System.out.println(registeredTeam[i]);
        }
    }

    /**
     * @return This method order the matches by their name in 3 different ways
     */

    public void matchesOrdered()
    {
        //Use a class that implements Comparator
        Arrays.sort(registeredMatch,0,registeredMatchIndex,new TournamentMatchesComparator());
        for (int i=0;i<registeredMatchIndex;i++)
        {
            System.out.println(registeredMatch[i]);
        }
        System.out.println();
        //Use an anonymous class
        Arrays.sort(registeredMatch, 0, registeredMatchIndex, new Comparator<Match>() {
            @Override
            public int compare(Match o1, Match o2) {
                return o1.getTournament().getName().compareToIgnoreCase(o2.getTournament().getName());
            }
        });
        for (int i=0;i<registeredMatchIndex;i++)
        {
            System.out.println(registeredMatch[i]);
        }
        System.out.println();
        //Use a lambda expression (only Mari Chelo's group)
        Arrays.sort(registeredMatch, 0, registeredMatchIndex,((o1, o2) ->
                o1.getTournament().getName().compareToIgnoreCase(o2.getTournament().getName())));
        for (int i=0;i<registeredMatchIndex;i++)
        {
            System.out.println(registeredMatch[i]);
        }
    }
}
