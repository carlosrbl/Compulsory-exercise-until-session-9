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
    Player[]  registeredPlayer = new Player[20];
    Team[] registeredTeam = new Team[10];
    Tournament[] registeredTournament = new Tournament[6];
    Match[] registeredMatch = new Match[4];

    int registeredPlayerIndex = 10;
    int registeredTeamIndex = 5;
    int registeredTournamentIndex = 3;
    int registeredMatchIndex = 3;

    public void initialize()
    {
        initializePlayers();
        initializeTeam();
        initializeTournament();
        initializeMatch();
    }
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
    public void initializeTeam()
    {
        registeredTeam[0] = new Team("Eucaliptos",new Player []{registeredPlayer[0],registeredPlayer[1]});
        registeredTeam[1] = new Team("Aristogatos",new Player []{registeredPlayer[2],registeredPlayer[3]});
        registeredTeam[2] = new Team("Los Thunderman", new Player []{registeredPlayer[4],registeredPlayer[5]});
        registeredTeam[3] = new Team("Los Tragaperras",new Player []{registeredPlayer[6],registeredPlayer[7]});
        registeredTeam[4] = new Team("Los Amateurs",new Player []{registeredPlayer[8],registeredPlayer[9]});
    }
    public void initializeTournament()
    {
        registeredTournament[0] = new TeamTournament("LOL tournament","League Of Legends",1000,4);
        registeredTournament[1] = new IndividualTournament("Splatton vs Inklings","Splatoon",2000);
        registeredTournament[2] = new MixedTournament("War of craft","StarCraft2",5000,"1v1");

    }
    public void initializeMatch()
    {
        Random rand = new Random();

        registeredMatch[0] = new Match(registeredTournament[0],registeredPlayer[0],registeredPlayer[1]);
        registeredMatch[1] = new Match(registeredTournament[1],registeredPlayer[3],registeredPlayer[4]);
        registeredMatch[2] =  new Match(registeredTournament[2],registeredPlayer[5],registeredPlayer[6]);
    }

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
    public void showTournaments()
    {
        for(int i=0;i<registeredTournament.length;i++)
        {
            System.out.println(registeredTournament[i].toString());
        }
    }

    public Player[] getRegisteredPlayer() {
        return registeredPlayer;
    }

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

    public Team[] getRegisteredTeam() {
        return registeredTeam;
    }

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

    public Tournament[] getRegisteredTournament() {
        return registeredTournament;
    }

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

    public Match[] getRegisteredMatch() {
        return registeredMatch;
    }

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
