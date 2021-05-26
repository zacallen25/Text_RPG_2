import java.util.ArrayList;
import java.util.Scanner;

/*
Made by Zachary Allen
Assistance given by: Christopher Shilling

I took  the basics of my RPG from something like Dungeons and Dragons
The basics of combat is that each person attacking (in this case, each instance of a child of the Monster class) has what is known as an armor class (also called an AC)
When one person wants to attack another, they roll a 20-sided dice, and add their own attack bonus to that roll
If that number is higher than the armor class of the attacked person, than the attack hits
Rinse, dry, repeat, until either all bad guys or all good guys are dead

 */


public class MyRPG {
public static int turns = 0; //I'm working on implementing turns, largely for the use of adding and removing effects

    public static void main(String[] args) {

//        Hero hero = new Hero();
//        hero.makeHero(false, false);
        Hero hero1 = new Hero("Zac", 50, "Sword",  15, true, 5, 5);
        Hero hero2 = new Hero();
        hero2.makeHero(false, false);
        //Hero hero3 = new Hero("Alyssa", 50, "Sword", 15, true, 5, 5);

        Goblin gob1 = new Goblin("Moblin", 20,  10, 2, 0);
        Goblin gob2 = new Goblin("Boblin", 20,  10, 2, 0);
        Goblin gob3 =new Goblin("Coblin", 20, 10, 2, 0);

        //I want an array for everyone fighting so we can use initiative
//        ArrayList<Monster> arr = new ArrayList<>();
//
//        arr.add(hero);
//        arr.add(gob1);
//        arr.add(gob2);
//        arr.add(gob3);
//
//        //Below is simply a way to print the initiative for each person
//        for (int i = 0; i < arr.size(); i++) {
//            System.out.println(arr.get(i).getName() + " initiative: " + arr.get(i).returnInitiative());
//        }
//
//        Affect.fighting(arr);

        ArrayList<Hero> heroList = new ArrayList<>();
        heroList.add(hero1);
        //heroList.add(hero3);
        heroList.add(hero2);

        System.out.println(Campaign.campaign(heroList));

    }
}
