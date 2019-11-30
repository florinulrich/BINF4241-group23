import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

class Dice {

    static int roll(){

        //returns a value between 0 and 5
        Random random = new Random();
        int number = random.nextInt(6);

        //add one to get number from 1 to 6
        return (number+1);


    }
}