import java.util.Random;
public class Card 
{
    private final int value;

    Card()
    {
        value = randomCard();
    }

    public int getValue()
    {
        return value;
    }

    private int randomCard()
    {
        int min = 2;
        int max = 11;
        int range = (max - min);

        int random = new Random().nextInt(range + 1) + min;

        return random;
    }
}