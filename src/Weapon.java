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

    //I want isMagic to yield an advantage to using magic, but a disadvantage to using normal weapons (-3 damage)
    public Weapon(String name, boolean isMagic) {
        this.name = name;
        if (name.equalsIgnoreCase("Sword")) {
            damage = DiceTray.d6() + DiceTray.d6();
        }
        else if (name.equalsIgnoreCase("Axe")) {
            damage = DiceTray.d10();
        }
        else if (name.equalsIgnoreCase("Good Axe")) {
            damage = DiceTray.d12();
        }
        else if (name.equalsIgnoreCase("Better Axe")) {
            damage = DiceTray.d20();
        }
        else if (name.equalsIgnoreCase("Good Sword")) {
            damage = DiceTray.d10() + DiceTray.d10();
        }
        else if (name.equalsIgnoreCase("Better Sword")) {
            damage = DiceTray.d12() + DiceTray.d12();
        }


        else {
            damage = 1;
        }

        if (isMagic) {
            damage -= 3;
            if (damage <= 0) {
                damage = 1;
            }
        }
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
