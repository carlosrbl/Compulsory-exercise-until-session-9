package tournament.main;

import tournament.comparator.PlayersInformationComparator;
import tournament.comparator.TeamsInformationComparator;
import tournament.comparator.TournamentComparator;
import tournament.comparator.TournamentMatchesComparator;
import tournament.data.Match;
import tournament.data.Player;
import tournament.data.Team;
import tournament.data.Tournament;
import tournament.exceptions.FullTeamException;

import java.util.*;

public class Main
{
    public static boolean showMenu(TournamentManager tournamentManager)
    {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        boolean validInput = false;

        while(!validInput)
        {
            System.out.println("Tournament Menu\n--------------");
            System.out.println("1. View available tournaments ordered by name");
            System.out.println("2. View players information ordered by ranking and name");
            System.out.println("3. View teams information ordered by ranking");
            System.out.println("4. Add a new player to a team");
            System.out.println("5. Find an exact player by name");
            System.out.println("6. Find a player");
            System.out.println("7. Find a team");
            System.out.println("8. Show all the matches ordered by tournament name");
            System.out.println("9. Update the result of the matches pending");
            System.out.println("10. Exit\n");
            System.out.print("Enter your choice: ");
            try
            {
                int choice = sc.nextInt();
                validInput = true;
                exit = play(choice,tournamentManager);
            }
            catch (InputMismatchException e)
            {
                System.err.println("Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
            if (!validInput)
            {
                System.out.println();
                System.out.println();
            }
        }
        return exit;
    }
    public static void TournamentsOrdered(TournamentManager tournamentManager)
    {
        //Use a class that implements Comparator
        Arrays.sort(tournamentManager.getRegisteredTournament(),new TournamentComparator());
        for (Tournament tournament : tournamentManager.getRegisteredTournament())
        {
            System.out.println(tournament);
        }
        System.out.println();
        //Use an anonymous class
        Arrays.sort(tournamentManager.getRegisteredTournament(),new Comparator<Tournament>()
        {
            @Override
            public int compare(Tournament o1, Tournament o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Tournament tournament : tournamentManager.getRegisteredTournament())
        {
            System.out.println(tournament);
        }
        System.out.println();
        //Use a lambda expression (only Mari Chelo's group)
        Arrays.sort(tournamentManager.getRegisteredTournament(),((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())));
        for (Tournament tournament : tournamentManager.getRegisteredTournament())
        {
            System.out.println(tournament);
        }
    }
    public static void PlayersOrdered(TournamentManager tournamentManager)
    {
        //Use a class that implements Comparator
        Arrays.sort(tournamentManager.getRegisteredPlayer(),new PlayersInformationComparator());
        for (Player player : tournamentManager.getRegisteredPlayer())
        {
            System.out.println(player);
        }
        System.out.println();
        //Use an anonymous class
        Arrays.sort(tournamentManager.getRegisteredPlayer(), new Comparator<Player>()
        {
            @Override
            public int compare(Player o1, Player o2) {
                return Float.compare(o1.getRanking(), o2.getRanking()) == 0
                        ? o1.getName().compareToIgnoreCase(o2.getName()) :
                        Float.compare(o1.getRanking(), o2.getRanking());
            }
        });
        for (Player player : tournamentManager.getRegisteredPlayer())
        {
            System.out.println(player);
        }
        System.out.println();
        //Use a lambda expression (only Mari Chelo's group)
        Arrays.sort(tournamentManager.getRegisteredPlayer(),((o1, o2) ->
                Float.compare(o1.getRanking(), o2.getRanking()) == 0
                        ? o1.getName().compareToIgnoreCase(o2.getName()) :
                        Float.compare(o1.getRanking(), o2.getRanking())));
        for (Player player : tournamentManager.getRegisteredPlayer())
        {
            System.out.println(player);
        }
    }
    public static void TeamsOrdered(TournamentManager tournamentManager)
    {
        //Use a class that implements Comparator
        Arrays.sort(tournamentManager.getRegisteredTeam(),new TeamsInformationComparator());
        for (Team team : tournamentManager.getRegisteredTeam())
        {
            System.out.println(team);
        }
        System.out.println();
        //Use an anonymous class
        Arrays.sort(tournamentManager.getRegisteredTeam(), new Comparator<Team>()
        {
            @Override
            public int compare(Team o1, Team o2) {
                return Float.compare(o1.getAverageTeamRanking(), o2.getAverageTeamRanking());
            }
        });
        for (Team team : tournamentManager.getRegisteredTeam())
        {
            System.out.println(team);
        }
        System.out.println();
        //Use a lambda expression (only Mari Chelo's group)
        Arrays.sort(tournamentManager.getRegisteredTeam(),((o1, o2) ->  Float.compare(o1.getAverageTeamRanking(), o2.getAverageTeamRanking())));
        for (Team team : tournamentManager.getRegisteredTeam())
        {
            System.out.println(team);
        }
    }
    public static void MatchesOrdered(TournamentManager tournamentManager)
    {
        //Use a class that implements Comparator
        Arrays.sort(tournamentManager.getRegisteredMatch(),new TournamentMatchesComparator());
        for (Match match : tournamentManager.getRegisteredMatch())
        {
            System.out.println(match);
        }
        System.out.println();
        //Use an anonymous class
        Arrays.sort(tournamentManager.getRegisteredMatch(), new Comparator<Match>()
        {
            @Override
            public int compare(Match o1, Match o2) {
                return o1.getTournament().getName().compareToIgnoreCase(o2.getTournament().getName());
            }
        });
        for (Match match : tournamentManager.getRegisteredMatch())
        {
            System.out.println(match);
        }
        System.out.println();
        //Use a lambda expression (only Mari Chelo's group)
        Arrays.sort(tournamentManager.getRegisteredMatch(),((o1, o2) -> o1.getTournament().getName().compareToIgnoreCase(o2.getTournament().getName())));
        for (Match match : tournamentManager.getRegisteredMatch())
        {
            System.out.println(match);
        }
    }
    public static void CreatePlayer(TournamentManager tournamentManager)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter player name: ");
        String playerName = sc.nextLine();
        System.out.print("Enter level of the player: ");
        int playerLevel = sc.nextInt();
        System.out.print("Enter rank of the player: ");
        float playerRank = sc.nextFloat();

        Player player = new Player(playerName,playerLevel,playerRank);

        AddPlayerToTeam(tournamentManager,player);

    }

    public static void AddPlayerToTeam(TournamentManager tournamentManager, Player player)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter team name: ");
        String teamName = sc.nextLine();
        boolean encontrado = false;
        for(int i = 0;i< tournamentManager.registeredTeamIndex;i++)
        {
            if(tournamentManager.registeredTeam[i].getName().equalsIgnoreCase(teamName))
            {
                encontrado = true;
                tournamentManager.addPlayer(player);

                try
                {
                    tournamentManager.registeredTeam[i].addPlayer(player);
                }
                catch (FullTeamException e)
                {
                    System.err.println(e.getMessage());
                }
            }

        }
        if(!encontrado)
        {
            System.out.print("Team not found");
        }
    }
    public static void FindExactPlayer(TournamentManager tournamentManager)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter player name: ");
        String playerName = sc.nextLine();
        boolean encontrado = false;
        for(int i = 0;i< tournamentManager.registeredPlayerIndex;i++)
        {
            if(tournamentManager.registeredPlayer[i].getName().equalsIgnoreCase(playerName))
            {
                System.out.println(tournamentManager.registeredPlayer[i]);
                encontrado = true;
            }
        }
        if(!encontrado)
        {
            System.out.println("Player not found");
        }
    }
    public static void FindPlayer(TournamentManager tournamentManager)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter player name: ");
        String playerName = sc.nextLine();
        boolean encontrado = false;
        for(int i = 0;i< tournamentManager.registeredPlayerIndex;i++)
        {
            if(tournamentManager.registeredPlayer[i].getName().contains(playerName))
            {
                System.out.println(tournamentManager.registeredPlayer[i]);
                encontrado = true;
            }
        }
        if(!encontrado)
        {
            System.out.println("Player not found");
        }
    }
    public static void FindTeam(TournamentManager tournamentManager)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter team name: ");
        String teamName = sc.nextLine();
        boolean encontrado = false;
        for(int i = 0;i< tournamentManager.registeredTeamIndex;i++)
        {
            if(tournamentManager.registeredTeam[i].getName().equalsIgnoreCase(teamName))
            {
                System.out.println(tournamentManager.registeredTeam[i]);
                encontrado = true;
            }
        }
        if(!encontrado)
        {
            System.out.println("Team not found");
        }
    }

    public static boolean play(int choice, TournamentManager tournamentManager)
    {
        boolean exit = false;
        switch(choice)
        {
            case 1:
                TournamentsOrdered(tournamentManager);
                System.out.println();
                break;
            case 2:
                PlayersOrdered(tournamentManager);
                System.out.println();
                break;
            case 3:
                TeamsOrdered(tournamentManager);
                System.out.println();
                break;
            case 4:
                CreatePlayer(tournamentManager);
                System.out.println();
                break;
            case 5:
                FindExactPlayer(tournamentManager);
                break;
            case 6:
                FindPlayer(tournamentManager);
                break;
            case 7:
                FindTeam(tournamentManager);
                break;
            case 8:
                MatchesOrdered(tournamentManager);
                System.out.println();
                break;
            case 9:

                break;
            case 10:
                System.out.println("Finishing Program...");
                exit = true;
                break;
            default:
                System.out.println("Invalid choice");
                System.out.println();
                break;
        }
        return exit;
    }
    public static void main(String[] args)
    {
        boolean exit = false;
        TournamentManager tournamentManager = new TournamentManager();
        tournamentManager.initialize();
        while(!exit)
        {
            exit = showMenu(tournamentManager);
        }
    }
}