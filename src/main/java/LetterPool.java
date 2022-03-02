import java.util.Random;

public class LetterPool
{

    private Random random = new Random();

    public char getRandomLetter()
    {
        return (char) ('A' + random.nextInt(26));
    }
}
