import java.util.Random;

public class Dice {

    public Dice() {}

    static int roll(){
        Random random = new Random();
        int number = random.nextInt(7);
        return number;
    }
}
