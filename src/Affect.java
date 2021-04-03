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
        System.out.println("What magic attack do you want to do? Fire blast(1), Ice blast(2), Fire stream(3), or Ice Stream(4)?");
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
        else {
            spell = new Ice_Stream();
        }
        return spell;
    }

    public static String hitAndHurtsSpell(Monster attacked, Monster attacker) {
        int attackRoll = DiceTray.d20();
        Spell spell = type();

        if (hitsSpell(attacked, attacker, spell.rollHit())) {
            int dmg = spell.rollDieDamage();;
            attacked.removeHealth(dmg);
            attacked.changeEffect(spell.effect());
            attacked.setTurnsLeftStatus(2);
            return "Spell " + "hits " + attacked.getName() + " for " + dmg + "\n" + attacked.getName() + " now has " + attacked.getHealth() + " health left";
        }
        else {
            return "Spell failed to hit.";
        }
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


    //Needs to be worked on
    public static void addEffect(Monster m) {
        if (m.getEffect() == Effects.FIRE && m.hasTurnsStatusleft()) {
            m.removeHealth(DiceTray.d4());
            m.decreaseTurnsLeftStatus();
        }
        else if (m.getEffect() == Effects.FROZEN && m.hasTurnsStatusleft()) {
            m.changeAttackBonus(-2);
            m.decreaseTurnsLeftStatus();
        }
        else {
            m.changeEffect(Effects.NONE);
        }
    }


    public static String fighting(ArrayList<Monster> fighters) {
        ArrayList<Monster> newArr = determineInitiativeOrder(fighters);
        ArrayList<Monster> listHeroes = new ArrayList<>();
        boolean isTrue = true;
        Random rand = new Random();
        for (int i = 0; i < newArr.size(); i++) {
            if (newArr.get(i).getClass() == Hero.class) {
                listHeroes.add(newArr.get(i));
            }
        }
        do {

            for (int i = 0; i < newArr.size(); i++) {
                if (newArr.size() == 1) {
                    break;
                }
                if (newArr.get(i).getClass() != Hero.class) {
                    if (newArr.get(i).getStatus() == State.DEAD) {
                        //newArr.remove(i);
                        continue;
                    }
                    if (listHeroes.size() == 0) {
                        continue;
                    }
                    int attackNum = rand.nextInt(listHeroes.size());
                    System.out.println(newArr.get(i).getAction(listHeroes.get(attackNum)));
                    if (listHeroes.get(attackNum).getHealth() <= 0) {
                        listHeroes.get(attackNum).changeStatus(State.DEAD);
                        newArr.remove(newArr.indexOf(listHeroes.get(attackNum)));
                        listHeroes.remove(attackNum);
                    }
                }
                else {
                    System.out.print("Do you (" + newArr.get(i).getName() + ") want to attack ");
                    for (int j = 0; j < newArr.size() - 1; j++) {
                        if (newArr.get(j).getClass() == Hero.class) {
                            continue;
                        }
                        System.out.print(newArr.get(j) + " " + j + " or ");
                    }
                    if (newArr.get(newArr.size() - 1).getClass() != Hero.class) {
                        System.out.println(newArr.get(newArr.size() - 1) + " " + (newArr.size() - 1));
                    }
                    System.out.println("Enter the one that you want to attack as a number, or enter " + newArr.size() + " to view stats for everyone");
                    Scanner in = new Scanner(System.in);
                    int choice = in.nextInt();
                    /*
                    while(choice == newArr.size()) {

                    }
                     */
                    while(newArr.get(choice).getClass() == Hero.class) {
                        System.out.println("Don't attack a hero! Try again: ");
                        choice = in.nextInt();
                    }
                    if (choice == newArr.size()) {
                        for (int k = 0; k < newArr.size(); k++) {
                            System.out.println("Name: " + newArr.get(k).getName() + "\tHealth: " + newArr.get(k).getHealth() + "\tEffects: " + newArr.get(k).getEffect());
                        }
                        System.out.println("Enter the one that you want to attack as a number");
                        choice = in.nextInt();
                    }

                    System.out.println(newArr.get(i).getAction(newArr.get(choice)));
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
            isTrue = false;
            for (int i = 0; i < newArr.size(); i++) {
                if (newArr.get(i).getClass() != Hero.class) {
                    if (newArr.get(i).getStatus() == State.ALIVE) {
                        isTrue = true;
                    }
                }
                if (listHeroes.size() == 0) {
                    isTrue = false;
                }
            }

        }while(isTrue);

        if (listHeroes.size() != 0) {
            return ("Good victory!");
        }
        else {
            return ("Bad defeat!");
        }

    }

}
