import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Scanner console = new Scanner(System.in);
//        Hero firstHero = new Hero();
//        firstHero.makeHero(console);
//
//        System.out.println(firstHero);

        Hero hero1 = new Hero("Zac", 50, "Axe", 5, 10, true);
        //System.out.println(hero1);

//        Goblin gob1 = new Goblin();
//        System.out.println(gob1);
//
//        Goblin gob2 = new Goblin("Moblin", 20, "Axe", 5, 10);
//        System.out.println(gob2);

        Goblin gob3 = new Goblin("Zac", 20, "Axe", 5, 5);
//        Affect.doDamage(gob3, 5);
//        System.out.println(gob3);

        Affect.hitsAndHurts(gob3, DiceTray.d20(), hero1.getWeaponInfo().getDamage());

        System.out.println(gob3);



    }
}
