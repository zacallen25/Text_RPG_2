import java.util.*;

//Simply put, this class simulates rolling a dice for different purposes
//These are all the normally-used dice in most roll playing games such as Dungeons and Dragons
public class DiceTray {
    //4-sided dice
    public static int d4() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(4) + 1;
        return randomNumber;
    }

    //6-sided dice
    public static int d6() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(6) + 1;
        return randomNumber;
    }

    //8-sided dice
    public static int d8() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(8) + 1;
        return randomNumber;
    }

    //10-sided dice
    public static int d10() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(10) + 1;
        return randomNumber;
    }

    //12-sided dice
    public static int d12() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(12) + 1;
        return randomNumber;
    }

    //20-sided dice
    public static int d20() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(20) + 1;
        return randomNumber;
    }

    //100-sided dice
    public static int d100() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(100) + 1;
        return randomNumber;
    }

}
