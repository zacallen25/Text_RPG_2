import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner console = new Scanner(System.in);
        Hero firstHero = new Hero();
        firstHero.makeHero(console);

        System.out.println(firstHero);
    }
}
