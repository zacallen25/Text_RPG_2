import java.util.*;

public class DiceTray {


    public static int d4() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(4) + 1;
        return randomNumber;
    }

    public static int d6() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(6) + 1;
        return randomNumber;
    }

    public static int d8() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(8) + 1;
        return randomNumber;
    }

    public static int d10() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(10) + 1;
        return randomNumber;
    }

    public static int d12() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(12) + 1;
        return randomNumber;
    }

    public static int d20() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(20) + 1;
        return randomNumber;
    }

    public static int d100() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(100) + 1;
        return randomNumber;
    }

}
