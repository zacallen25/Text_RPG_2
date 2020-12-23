import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Campaign {

    //I've started on making the campaign
    public static String campaign(ArrayList<Hero> Heroes) {
        PrintStream o = new PrintStream(System.out);
        Scanner console = new Scanner(System.in);

        if (Heroes.size() <= 0) {
            return "Error";
        }
        System.out.println("Your list of heroes is: ");
        for (int i = 0; i < Heroes.size(); i++) {
            o.println(Heroes.get(i));
        }

        o.println("You are on your way to a town in a cart.");
        if (Heroes.size() == 1) {
            o.println("You look around and you see that there are 2 civilians, as well as a guard.");
        }
        else {
            o.println("You look around and there are 2 civilians, a guard, and everyone else in your party.");
        }

        o.println("Suddenly, a group of three goblins attack!");
        o.println("The guard jumps out to meet them, but is immediately stabbed in the chest by the first goblin");
        o.println("The other goblins shout \"Give us your money, now!\"");
        o.println("All your other passengers cower in fear. Do you (everyone) choose to attack them (1) or give up (2)?");
        int choiceFight1 = console.nextInt();
        if (choiceFight1 != 1 && choiceFight1 != 2) {
            return ("Invalid");
        }
        else if (choiceFight1 == 2) {
            return "You cowards!!!! You lose automatically";
        }


        Goblin gob1 = new Goblin("Moblin", 20,  10, 2, 0);
        Goblin gob2 = new Goblin("Boblin", 20,  10, 2, 0);
        Goblin gob3 =new Goblin("Coblin", 20, 10, 2, 0);

        ArrayList<Monster> fight = new ArrayList<>();
        ArrayList<Monster> orderedFight = new ArrayList<>();

        for (int i = 0; i < Heroes.size(); i++) {
            fight.add(Heroes.get(i));
        }

        fight.add(gob1);
        fight.add(gob2);
        fight.add(gob3);

        orderedFight = Affect.determineInitiativeOrder(fight);

        for (int i = 0; i < orderedFight.size(); i++) {
            o.println(orderedFight.get(i).getName() + " goes " + (i + 1));

        }
        o.println();

        String outcome = Affect.fighting(orderedFight);

        if (outcome == "Bad defeat!") {
            return "You have all died";
        }
        o.println("As you prepare to strike down the last one, he falls to the ground. He cries out, \"Pleasssssse don't kill me, I can give you information! I'll give you anything! Just don't kill me!");
        int choice1 = 2;
        while (choice1 != 3 && choice1 != 1) {
            o.println("Do all of you want to kill him (1), interrogate him (2), or let him go (3)?");
            choice1 = console.nextInt();
            if (choice1 != 1 && choice1 != 2 && choice1 != 3) {
                return "Invalid";
            }
            if (choice1 == 2) {
                o.println("He says, \"I'll give you anything you want to know!\"");
                o.println("Do you want to ask him who sent him (1), or what him and his group was doing (2)?");
                int choice2 = console.nextInt();
                if (choice2 != 1 && choice2 != 2) {
                    return "Invalid";
                }
                if (choice2 == 1) {
                    o.println("Our leader, Gan-lin, has been sending all the goblins he has at his disposal to shake people down. Apparently, he needs a lot of money for something. I don't know. I don't question it.");
                }
                if (choice2 == 2) {
                    o.println("Me and my group were sent by our boss to take money from anyone traveling down this road. Other goblins were sent to other roads to shake down people there. Lucky bastiches. I bet they don't have to deal with this.");
                    o.println("Oh God! Sorry I meant no offense. I just wasn't expecting all of my friends, and potentially myself, to all die today. Can you let me go now?!");
                }
            }
        }
        if (choice1 == 1) {
            o.println("You prepare your weapon, then cleave his head clean off. The driver looks at you, and says that \"Well that was a bit extreme. Oh well though.\"");
        }
        else {
            o.println("You tell him that he may go. He says \"Thank you, thank you so so so so so much!!! I will never forget this!\" Then he scampers away into the woods.");
        }

     return "You win";
    }

}
