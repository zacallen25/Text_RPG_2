public class Weapon {
    private String name;
    private int damage;

    public Weapon() {
        String name;
        int damage;
        DiceTray rand = new DiceTray();
        int nam = rand.d4();
        int dam = rand.d10();
        if (nam == 1) {
            name = "Axe";
        }
        else if (nam == 2) {
            name = "Sword";
        }
        else if (nam == 3) {
            name = "Staff";
        }
        else {
            name = "Mace";
        }
        this.name = name;
        this.damage = dam;
    }


    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }


    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Name of weapon? " + name + "\n" + "Damage? " + damage;
    }
}
