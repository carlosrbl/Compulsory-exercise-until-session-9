package tournament.exceptions;

public class BadPlayerInput extends Exception
{
    public BadPlayerInput (String message)
    {
        super(message);
    }


    public static String comproveName(String name) throws BadPlayerInput
    {
        String[] numbers = {"1","2","3","4","5","6","7","8","9","0"};
        for (int i=0;i<numbers.length;i++)
        {
            if (name.contains(numbers[i]))
            {
                throw new BadPlayerInput("The player name doesn't have to have numbers");
            }
        }
        return name;
    }

    public static int comprovePlayerLevel(int level) throws BadPlayerInput
    {
        if (level < 0 || level > 100)
        {
            throw new BadPlayerInput("The level of the player has to be between 1 and 100");
        }
        return level;
    }
}
