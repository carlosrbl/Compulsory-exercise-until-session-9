package tournament.main;

import tournament.data.Player;
import tournament.data.Team;
import tournament.data.Tournament;

import java.util.InputMismatchException;
import java.util.Scanner;

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
    public static boolean play(int choice, TournamentManager tournamentManager)
    {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        switch(choice)
        {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

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
        while(!exit)
        {
            exit = showMenu(tournamentManager);
        }
    }
}