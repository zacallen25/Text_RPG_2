import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//This class is where different objects can affect each other. Therefore, almost every function is public and static, so there is no need for a specific class instance
public class Affect {

    public static void doDamage(Monster m, int dmg) {
        m.removeHealth(dmg);
    }

    public static void heal(Monster m, int health) {
        m.addHealth(health);
    }

    public static boolean hits(Monster attacked, Monster attacker, int attack) {
        if (attacked.getArmorClass() < attack + attacker.getAttackBonus()) {
            return true;
        }
        else {
            return false;
        }
    }

    public static String hitsAndHurts(Monster attacked, Monster attacker) {
        int attackRoll = DiceTray.d20();
        int dmg = attacker.getWeaponInfo().getDamage();
        if (hits(attacked, attacker, attackRoll)) {
            attacked.removeHealth(dmg);
            return attacker.getName() + " attacked " + attacked.getName() + " for " + dmg + " damage. \n" + attacked.getName() + " now has " + attacked.getHealth() + " health left";
        }
        else {
            return attacker.getName() + " failed to hit " + attacked.getName();
        }
    }

    public static boolean hitsSpell(Monster attacked, Monster attacker, int attackRoll) {
        int bonus = 0;
        if (attacker.isMagical()) {
            bonus = 4;
        }

        if (attackRoll + bonus > attacked.getArmorClass()) {
            return true;
        }
        else {
            return false;
        }
    }

    public static Spell type() {
        Scanner in = new Scanner(System.in);
        System.out.println("What magic attack do you want to do? Fire blast(1), Ice blast(2), Fire stream(3), Ice Stream(4), or Magic Missle(5)?");
        int input = in.nextInt();
        Spell spell;
        if (input == 1) {
            spell = new Fire_Blast();
        }
        else if (input == 2) {
            spell = new Ice_Blast();
        }
        else if (input == 3){
            spell = new Fire_Stream();
        }
        else if (input == 4){
            spell = new Ice_Stream();
        }
        else {
            spell = new Magic_Missle();
        }
        return spell;
    }

    public static String hitAndHurtsSpell(Monster attacked, Monster attacker) {
        int attackRoll = DiceTray.d20();
        Spell spell = type();

        if (hitsSpell(attacked, attacker, spell.rollHit())) {
            int dmg = spell.rollDieDamage();
            attacked.removeHealth(dmg);
            attacked.changeEffect(spell.effect());
            attacked.setTurnsLeftStatus(spell.getTurnsEffect());
            return "Spell " + "hits " + attacked.getName() + " for " + dmg + "\n" + attacked.getName() + " now has " + attacked.getHealth() + " health left";
        }
        else {
            return "Spell failed to hit.";
        }
    }

    public static String hitsAndHurtsSpell(Monster attacked, Monster attacker, Spell spell) {
        int attackRoll = DiceTray.d20();

        if(hitsSpell(attacked, attacker, spell.rollHit())) {
            int dmg = spell.rollDieDamage();
            attacked.removeHealth(dmg);
            attacked.changeEffect(spell.effect());
            attacked.setTurnsLeftStatus(spell.getTurnsEffect());
            return "Spell " + "hits " + attacked.getName() + " for " + dmg + "\n" + attacked.getName() + " now has " + attacked.getHealth() + " health left";
        }
        else {
            return "Spell failed to hit.";
        }
    }

    public static Spell getRandomSpell() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(5);
        if (randomNumber == 0) {return new Fire_Blast();}
        else if (randomNumber == 1) {return new Fire_Stream();}
        else if (randomNumber == 2) {return new Ice_Stream();}
        else if (randomNumber == 3) {return new Ice_Blast();}
        else {return new Magic_Missle();}
    }

    public static ArrayList<Monster> determineInitiativeOrder(ArrayList<Monster> fighters) {
        ArrayList<Monster> newArr = new ArrayList<>();
        while (!fighters.isEmpty()) {
            Monster mon = fighters.get(0);
            for (int j = 0; j < fighters.size(); j++) {
                if (mon.returnInitiative() < fighters.get(j).returnInitiative()) {
                    mon = fighters.get(j);
                }

            }
            fighters.remove(mon);
            newArr.add(mon);
        }

        return newArr;
    }



    public static void addEffect(Monster m) {
        //If the person is on fire and they have turns left on their fire effect, they take a d4 of damage
        if (m.getEffect() == Effects.FIRE && m.hasTurnsStatusleft()) {
            m.removeHealth(DiceTray.d4());
            m.decreaseTurnsLeftStatus();
        }
        //If the person is frozen and they have turns left on their frozen effect, their attack bonus is temporarily decreased, thus making it harder for them to attack
        else if (m.getEffect() == Effects.FROZEN && m.getTurnsLeftStatus() == 2) {
            m.changeAttackBonus(-2);
            m.decreaseTurnsLeftStatus();
        }
        else if (m.getEffect() == Effects.FROZEN && m.getTurnsLeftStatus() > 0 && m.getTurnsLeftStatus() < 2) {
            //This just skips this scenario
        }

        else {
            if (m.getEffect() == Effects.FROZEN && m.getTurnsLeftStatus() <= 0) {
                m.changeAttackBonus(+2);//This restores their temporary debuff
            }
            m.changeEffect(Effects.NONE);
        }
    }

    //I know that this looks like a huge cluster. Let me explain
    public static String fighting(ArrayList<Monster> fighters) {
        //Here, I simply determine the initiative order of the fighters
        ArrayList<Monster> newArr = determineInitiativeOrder(fighters);
        //I define here a list of the heroes. This is important so the monsters know who to fight, and so it is easier to tell if all the heroes are dead
        ArrayList<Monster> listHeroes = new ArrayList<>();
        //isTrue and rand will come into play later
        boolean isTrue = true;
        Random rand = new Random();
        for (int i = 0; i < newArr.size(); i++) {
            if (newArr.get(i).getClass() == Hero.class) {
                listHeroes.add(newArr.get(i));
                //Putting all the heroes also into the listHeroes list
            }
        }
        //This do while loop represents one full round of combat
        do {
            //Each iteration of the for loop is one round of combat for one specific fighter
            for (int i = 0; i < newArr.size(); i++) {
                if (newArr.size() == 1) {
                    break;
                }
                //This is if the combatant is not a hero (therefore, it does not require user input)
                if (newArr.get(i).getClass() != Hero.class) {
                    if (newArr.get(i).getStatus() == State.DEAD) {
                        //This way, in case there is some glitch, you cannot start a round with someone dead
                        continue;
                    }
                    if (listHeroes.size() == 0) {
                        continue;
                    }
                    //This will choose which hero the attacker will attack
                    int attackNum = rand.nextInt(listHeroes.size());
                    System.out.println(newArr.get(i).getAction(listHeroes.get(attackNum)));
                    //This way, if they kill a hero, that hero is removed
                    if (listHeroes.get(attackNum).getHealth() <= 0) {
                        listHeroes.get(attackNum).changeStatus(State.DEAD);
                        newArr.remove(newArr.indexOf(listHeroes.get(attackNum)));
                        listHeroes.remove(attackNum);
                    }
                }
                else {
                    //This is with a hero
                    System.out.print("Do you (" + newArr.get(i).getName() + ") want to attack "); //This asks who you want to attack
                    for (int j = 0; j < newArr.size() - 1; j++) {
                        if (newArr.get(j).getClass() == Hero.class) {
                            continue;
                        }
                        System.out.print(newArr.get(j) + " " + j + " or ");
                    }
                    if (newArr.get(newArr.size() - 1).getClass() != Hero.class) {
                        System.out.println(newArr.get(newArr.size() - 1) + " " + (newArr.size() - 1));
                    }
                    System.out.println("Enter the one that you want to attack as a number, or enter " + newArr.size() + " to view stats for everyone"); //I also have an option to view everyone's stats (health, effects on them, etc)
                    Scanner in = new Scanner(System.in);
                    int choice = in.nextInt();
                    //This way, you cannot attack a fellow hero
                    while(newArr.get(choice).getClass() == Hero.class) {
                        System.out.println("Don't attack a hero! Try again: ");
                        choice = in.nextInt();
                    }
                    //This actually prints out the stats that I mentioned earlier
                    if (choice == newArr.size()) {
                        for (int k = 0; k < newArr.size(); k++) {
                            System.out.println("Name: " + newArr.get(k).getName() + "\tHealth: " + newArr.get(k).getHealth() + "\tEffects: " + newArr.get(k).getEffect());
                        }
                        System.out.println("Enter the one that you want to attack as a number");
                        choice = in.nextInt();
                    }
                    //Attacks, using the getAction method in Hero
                    System.out.println(newArr.get(i).getAction(newArr.get(choice)));
                    //The following if statements take care of if the hero kills the person they're attacking
                    if (newArr.get(choice).getHealth() <= 0) {
                        newArr.get(choice).changeStatus(State.DEAD);
                    }
                    if (newArr.get(choice).getStatus() == State.DEAD) {
                        if (newArr.get(choice).getClass() == Hero.class) {
                            listHeroes.remove(newArr.get(choice));
                        }
                        newArr.remove(choice);
                    }
                }
                if(listHeroes.size() == 0) {
                    break;
                }
                //This method adds the effect (on fire, frozen, etc)
                Affect.addEffect(newArr.get(i));
                if (newArr.get(i).getHealth() <= 0) {
                    newArr.get(i).changeStatus(State.DEAD);
                }
                if (newArr.get(i).getStatus() == State.DEAD) {
                    if (newArr.get(i).getClass() == Hero.class) {
                        listHeroes.remove(newArr.get(i));
                    }
                    newArr.remove(i);
                }
                if (listHeroes.size() == 0) {
                    break;
                }
            }
            //This then determines if the combat should be over or not
            isTrue = false;
            for (int i = 0; i < newArr.size(); i++) {
                if (newArr.get(i).getClass() != Hero.class) {
                    if (newArr.get(i).getStatus() == State.ALIVE) { //If at least one non-hero is alive, isTrue is true
                        isTrue = true;
                    }
                }
            }
            if (listHeroes.size() == 0) { //However, if all the heroes are dead, than isTrue becomes false
                isTrue = false;
            }

        }while(isTrue);

        //Then, because the do while loop can only end if all the heroes are dead or all the bad guys are dead, I can then easily determine if the heroes won or lost
        if (listHeroes.size() != 0) {
            return ("Good victory!");
        }
        else {
            return ("Bad defeat!");
        }

    }

}
