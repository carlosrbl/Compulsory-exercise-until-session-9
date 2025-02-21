package tournament.main;

import tournament.data.*;

import java.util.Arrays;

public class TournamentManager
{
    Player[] registeredPlayer = new Player[20];
    Team [] registeredTeam = new Team[10];
    Tournament [] registeredTournament = new Tournament[6];
    Match [] registeredMatch = new Match[4];

    int registeredPlayerIndex = 9;
    int registeredTeamIndex = 2;
    int registeredTournamentIndex = 2;
    int registeredMatchIndex = 2;

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
        registeredPlayer[3] = new Player("Isabella",91,91.45f);
        registeredPlayer[4] = new Player("Santiago",23,532.2f);
        registeredPlayer[5] = new Player("Camila",99,222.2f);
        registeredPlayer[6] = new Player("Leonardo",38,753.3f);
        registeredPlayer[7] = new Player("Sofía",71,463.99f);
        registeredPlayer[8] = new Player("Andrés",88,441.1f);
        registeredPlayer[9] = new Player("Elena",4,82701.54f);
    }
    public void initializeTeam()
    {
        registeredTeam[0] = new Team("Eucaliptos",new Player []{registeredPlayer[0],registeredPlayer[1],registeredPlayer[2],registeredPlayer[3]});
        registeredTeam[1] = new Team("Aristogatos",new Player []{registeredPlayer[4],registeredPlayer[5],registeredPlayer[6],registeredPlayer[7]});
        registeredTeam[2] = new Team("Los Thunderman", new Player []{registeredPlayer[8],registeredPlayer[9]});


    }
    public void initializeTournament()
    {
        registeredTournament[0] = new TeamTournament("Team Tournament","League Of Legends",1000000,4);
        registeredTournament[1] = new IndividualTournament("Individual Tournament","Splatoon",200000);
        registeredTournament[2] = new MixedTournament("Mixed Tournament","StarCraft2",500000,"1v1");

    }
    public void initializeMatch()
    {
        registeredMatch[0] = new Match(registeredTournament[0],registeredPlayer[0],registeredPlayer[1]);
        registeredMatch[1] = new Match(registeredTournament[1],registeredPlayer[3],registeredPlayer[4]);
        registeredMatch[2] =  new Match(registeredTournament[2],registeredPlayer[5],registeredPlayer[6]);
    }

    public Player findPlayer(String username) //DUDAS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    {

        for(int i=0;i<registeredPlayer.length;i++)
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
    public void showPlayerRanking() {
        Arrays.sort(registeredPlayer, (a, b) -> Float.compare(a.getRanking(), b.getRanking()));
        for (int i = 0; i < registeredTournament.length; i++)
        {
            System.out.println(registeredTournament[i].toString());
        }
    }
    public void showTeamRanking()
    {
        Arrays.sort(registeredTeam,(a,b)->Float.compare(a.getAverageTeamRanking(),b.getAverageTeamRanking()));
    }

    public Player[] getRegisteredPlayer() {
        return registeredPlayer;
    }

    public void addPlayer(Player player) {

        registeredPlayerIndex++;
        if(registeredPlayerIndex < registeredPlayer.length)
        {
            registeredPlayer[registeredPlayerIndex] = player;
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
        registeredTeamIndex++;
        if(registeredTeamIndex < registeredTeam.length)
        {
            registeredTeam[registeredTeamIndex] = team;
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
        registeredTournamentIndex++;
        if(registeredTournamentIndex < registeredTournament.length)
        {
            registeredTournament[registeredTournamentIndex] = tournament;
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
        registeredMatchIndex++;
        if(registeredMatchIndex < registeredMatch.length)
        {
            registeredMatch[registeredMatchIndex] = match;
        }
        else
        {
            System.out.println("There is no more space");
        }
    }
}
