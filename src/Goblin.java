public class Goblin implements Monster{
    String name;
    int health;
    Weapon w;
    int AC;
    int attackBonus;


    public boolean isMagical() {
        return false;
    }

    public Goblin(String n, int health, String wName, int wDmg, int AC, int attackBonus) {
        boolean checker = n.charAt(n.length() - 1) != 'n' || n.charAt(n.length() - 2) != 'i' || n.charAt(n.length() -3) != 'l';
        if (checker) {
            this.name = n + "-lin";
        }
        else {
            this.name = n;
        }
        this.health = health;
        w = new Weapon(wName, wDmg);
        this.AC = AC;
        this.attackBonus = attackBonus;
    }

    public Goblin() {
        this.name = "Bob-lin";
        this.health = 1;
        w = new Weapon();
        this.attackBonus = 0;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeaponInfo() {
        return w;
    }

    public int getArmorClass() {
        return AC;
    }

    public String dialogue() {
        return "I am " + name + " the goblin!";
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public String getName() {
        return name;
    }

    public void addHealth(int add) {
        this.health += add;
    }

    public void removeHealth(int subtract) {
        this.health -= subtract;
    }

    public String toString() {
        return "I am " + this.name + " the goblin!\n" + "Health: " + health + "\n" + w.toString() + "\n" + "Armor class: " + AC + "\n";
    }


}
