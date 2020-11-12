import java.util.ArrayList;
import java.util.Scanner;
//


public class Main {
public static int turns = 0;

    public static void main(String[] args) {
////        Scanner console = new Scanner(System.in);
////        Hero firstHero = new Hero();
////        firstHero.makeHero(console);
////
////        System.out.println(firstHero);
//        Scanner inp = new Scanner(System.in);
//        Hero hero1 = new Hero();
//        hero1.makeHero(inp);
//        //System.out.println(hero1);
//
////        Goblin gob1 = new Goblin();
////        System.out.println(gob1);
////
////        Goblin gob2 = new Goblin("Moblin", 20, "Axe", 5, 10);
////        System.out.println(gob2);
//
//        Goblin gob1 = new Goblin("Moblin", 20, "Axe", 5, 10, 2);
////        Affect.doDamage(gob3, 5);
////        System.out.println(gob3);
//
//        //String msg = Affect.hitsAndHurts(gob3, hero1, DiceTray.d20());
//
//        Goblin gob2 = new Goblin("Boblin", 20, "Sword", 8, 8, 3);
//
//
//        while (hero1.getHealth() > 0 && gob1.getHealth() > 0 || gob2.getHealth() > 0) {
//            System.out.println("Who do you want to attack? " + gob1.getName() + " (enter 1) or " + gob2.getName() + "(enter 2)");
//            Scanner input = new Scanner(System.in);
//            int in = input.nextInt();
//            if (in == 1) {
//                System.out.println(Affect.hitsAndHurts(gob1, hero1));
//
//            }
//            else if (in == 2){
//                System.out.println(Affect.hitsAndHurts(gob2, hero1));
//
//            }
//            else {
//                continue;
//            }
//            if (gob1.getHealth() > 0) {
//                System.out.println(Affect.hitsAndHurts(hero1, gob1));
//            }
//            if (gob2.getHealth() > 0) {
//                System.out.println(Affect.hitsAndHurts(hero1, gob2));
//            }
//            System.out.println();
//        }
//
//        if (hero1.getHealth() > 0) {
//            System.out.println("You won!");
//        }
//        else {
//            System.out.println("You lost! I'm sorry. You suck");
//        }

//        Scanner console = new Scanner(System.in);
//        Hero hero1 = new Hero();
//        hero1.makeHero(console);
        Goblin gob1 = new Goblin("Moblin", 20, "Axe", 5, 10, 2, 0);
//
//        hero1.attack(hero1.getChoice(), gob1, hero1);

        Hero hero = new Hero("Zac", 50, "Sword", 10, 15, true, 2, 3);
        //hero.makeHero();

        Goblin gob2 = new Goblin("Boblin", 20, "Axe", 5, 10, 2, 0);
//
        ArrayList<Monster> arr = new ArrayList<>();

        arr.add(hero);
        arr.add(gob1);
        arr.add(gob2);
        System.out.println(hero.getName() + " " + hero.returnInitiative());
        System.out.println(gob1.getName() +  " " + gob1.returnInitiative());
        System.out.println(gob2.getName() + " " + gob2.returnInitiative());

//        ArrayList<Monster> newArr = Affect.determineInitiativeOrder(arr);
//
//        Scanner in = new Scanner(System.in);
//        while(hero.getHealth() > 0 && gob1.getHealth() > 0 || gob2.getHealth() > 0) {
//            for (int i = 0; i < newArr.size(); i++) {
//
//                if (newArr.get(i) != hero) {
//                    if (newArr.get(i).getHealth() <= 0) {
//                        continue;
//                    }
//                    System.out.println(newArr.get(i).getAction(hero, newArr.get(i)));
//                }
//                else {
//
//                    System.out.println("Do you want to attack goblin 1(1) or goblin 2(2)?");
//                    int choice = in.nextInt();
//                    if (choice == 1) {
//                        System.out.println(newArr.get(i).getAction(gob1, hero));
//                    }
//                    else {
//                        System.out.println(newArr.get(i).getAction(gob2, hero));
//                    }
//                }
//            }
//        }

        Affect.fighting(arr);

    }
}
