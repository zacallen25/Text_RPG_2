import java.util.Scanner;

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

    //Needs to be worked on
    public static void addEffect() {

    }
}
