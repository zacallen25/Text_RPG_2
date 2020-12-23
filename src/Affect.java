import java.util.ArrayList;
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
        System.out.println("What magic attack do you want to do? Fire blast(1), Ice blast(2), or Fire stream(3)?");
        int input = in.nextInt();
        Spell spell;
        if (input == 1) {
            spell = new Fire_Blast();
        }
        else if (input == 2) {
            spell = new Ice_Blast();
        }
        else {
            spell = new Fire_Stream();
        }
        return spell;
    }

    public static String hitAndHurtsSpell(Monster attacked, Monster attacker) {
        int attackRoll = DiceTray.d20();
        Spell spell = type();

        if (hitsSpell(attacked, attacker, spell.rollHit())) {
            int dmg = spell.rollDieDamage();;
            attacked.removeHealth(dmg);
            return "Spell " + "hits " + attacked.getName() + " for " + dmg + "\n " + attacked.getName() + " now has " + attacked.getHealth() + " health left";
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
        if (m.getEffect() == Effects.FIRE) {
            m.removeHealth(DiceTray.d4());
        }
        if (m.getEffect() == Effects.FROZEN) {
            m.changeAttackBonus(-2);
        }
    }


    public static String fighting(ArrayList<Monster> fighters) {
        ArrayList<Monster> newArr = determineInitiativeOrder(fighters);
        ArrayList<Monster> listHeroes = new ArrayList<>();
        boolean isTrue = true;
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
                        continue;
                    }
                    if (listHeroes.size() == 0) {
                        continue;
                    }
                    System.out.println(newArr.get(i).getAction(listHeroes.get(0)));
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
                    System.out.println("Enter the one that you want to attack as a number");
                    Scanner in = new Scanner(System.in);
                    int choice = in.nextInt();
                    System.out.println(newArr.get(i).getAction(newArr.get(choice)));

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
            for (int i = 0; i < newArr.size(); i++) {
                isTrue = false;
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
