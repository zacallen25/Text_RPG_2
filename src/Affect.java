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

    public static String hitsAndHurts(Monster attacked, Monster attacker, int attackRoll) {
        int dmg = attacker.getWeaponInfo().getDamage();
        if (hits(attacked, attacker, attackRoll)) {
            attacked.removeHealth(dmg);
            return attacker.getName() + " attacked " + attacked.getName() + " for " + dmg + " damage. \n" + attacked.getName() + " now has " + attacked.getHealth() + " health left";
        }
        else {
            return attacker.getName() + " failed to hit " + attacked.getName();
        }
    }

    public static void addEffect() {

    }
}
