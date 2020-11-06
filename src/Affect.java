public class Affect {

    public static void doDamage(Monster m, int dmg) {
        m.removeHealth(dmg);
    }

    public static void heal(Monster m, int health) {
        m.addHealth(health);
    }

    public static boolean hits(Monster m, int attack) {
        if (m.getArmorClass() < attack) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void hitsAndHurts(Monster m, int attackRoll, int dmg) {
        if (hits(m, attackRoll)) {
            m.removeHealth(dmg);
        }
    }

}
