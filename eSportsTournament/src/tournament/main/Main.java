package tournament.main;

import tournament.comparator.PlayersInformationComparator;
import tournament.comparator.TeamsInformationComparator;
import tournament.comparator.TournamentComparator;
import tournament.comparator.TournamentMatchesComparator;
import tournament.data.Match;
import tournament.data.Player;
import tournament.data.Team;
import tournament.data.Tournament;
import tournament.exceptions.BadPlayerInput;
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
    public static void createPlayer(TournamentManager tournamentManager)
    {
        Scanner sc = new Scanner(System.in);
        String playerName = "";
        int playerLevel = 0;
        float playerRank = 0;
        try
        {
            System.out.print("Enter player name: ");
            playerName = sc.nextLine();

            BadPlayerInput.comproveName(playerName);
        }
        catch (BadPlayerInput e)
        {
            System.err.println(e.getMessage());
            createPlayer(tournamentManager);
        }

        try
        {
            System.out.print("Enter level of the player: ");
            playerLevel = sc.nextInt();
            BadPlayerInput.comprovePlayerLevel(playerLevel);
        }
        catch (BadPlayerInput e)
        {
            System.err.println(e.getMessage());
            createPlayer(tournamentManager);
        }

        try
        {
            System.out.print("Enter rank of the player: ");
            String rank = sc.next();
            playerRank = Float.parseFloat(rank);
        }
        catch (NumberFormatException e)
        {
            System.err.println(e.getMessage());
            createPlayer(tournamentManager);
        }

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
            if(tournamentManager.registeredTeam[i].getName().contains(teamName))
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
    public static void inputResult(TournamentManager tournamentManager)
    {
        Scanner sc = new Scanner(System.in);
        boolean found = false;
        for(int i = 0;i< tournamentManager.registeredMatchIndex;i++)
        {
            System.out.println(tournamentManager.registeredMatch[i]);
        }
        System.out.print("Tell me the name of the match that you want to update the result: ");
        String findMatch = sc.nextLine();
        for(int i = 0;i< tournamentManager.registeredMatchIndex && !found;i++)
        {
            if(tournamentManager.registeredMatch[i].getTournament().getName().equalsIgnoreCase(findMatch))
            {
                System.out.print("Tell me how you want to update the result: ");
                String changeResult = sc.nextLine();
                tournamentManager.registeredMatch[i].setResult(changeResult);
                System.out.println(tournamentManager.registeredMatch[i]);
                found = true;
            }

        }
        if(!found)
        {
            System.out.println("No match found");
        }
    }

    public static boolean play(int choice, TournamentManager tournamentManager)
    {
        boolean exit = false;
        switch(choice)
        {
            case 1:
                tournamentManager.tournamentsOrdered();
                System.out.println();
                break;
            case 2:
                tournamentManager.playersOrdered();
                System.out.println();
                break;
            case 3:
                tournamentManager.teamsOrdered();
                System.out.println();
                break;
            case 4:
                createPlayer(tournamentManager);
                System.out.println();
                break;
            case 5:
                FindExactPlayer(tournamentManager);
                System.out.println();
                break;
            case 6:
                FindPlayer(tournamentManager);
                System.out.println();
                break;
            case 7:
                FindTeam(tournamentManager);
                System.out.println();
                break;
            case 8:
                tournamentManager.matchesOrdered();
                System.out.println();
                break;
            case 9:
                inputResult(tournamentManager);
                System.out.println();
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