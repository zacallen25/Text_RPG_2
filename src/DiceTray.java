import java.util.*;

public class DiceTray {
    Random rand = new Random();

    public int d4() {
        int randomNumber = rand.nextInt(4) + 1;
        return randomNumber;
    }

    public int d6() {
        int randomNumber = rand.nextInt(6) + 1;
        return randomNumber;
    }

    public int d8() {
        int randomNumber = rand.nextInt(8) + 1;
        return randomNumber;
    }

    public int d10() {
        int randomNumber = rand.nextInt(10) + 1;
        return randomNumber;
    }

    public int d12() {
        int randomNumber = rand.nextInt(12) + 1;
        return randomNumber;
    }

    public int d20() {
        int randomNumber = rand.nextInt(20) + 1;
        return randomNumber;
    }

    public int d100() {
        int randomNumber = rand.nextInt(100) + 1;
        return randomNumber;
    }

}
