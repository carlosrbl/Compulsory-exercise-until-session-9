/**
 * @author Adrian
 * This exception is made to check the input of the user
 * in the 4th option in the main class.
 */


package tournament.exceptions;

public class BadPlayerInput extends Exception
{
    public BadPlayerInput (String message)
    {
        super(message);
    }

    /**
     * @param name Takes the name of the player that we want to create.
     * @return If all is correct it returns the name back.
     * @throws BadPlayerInput If the name of the player has in their name any other character that is not a letter it will throw the exception.
     *
     */

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

    /**
     *
     * @param level Takes the level of the player that we want to create.
     * @return If all is correct it returns the level of the player.
     * @throws BadPlayerInput It is the same as the other but this checks if the level is between 1 and 100.
     */
    public static int comprovePlayerLevel(int level) throws BadPlayerInput
    {
        if (level < 0 || level > 100)
        {
            throw new BadPlayerInput("The level of the player has to be between 1 and 100");
        }
        return level;
    }
}
