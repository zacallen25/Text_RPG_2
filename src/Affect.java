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

    public static void hitsAndHurts(Monster attacked, Monster attacker, int attackRoll) {
        int dmg = attacker.getWeaponInfo().getDamage();
        if (hits(attacked, attacker, attackRoll)) {
            attacked.removeHealth(dmg);
            System.out.println("Ow! I, " + attacked.getName() + ", was attacked for " + dmg + " damage!");
        }
    }

}
