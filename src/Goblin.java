public class Goblin extends Monster{

    public Goblin(String n, int health, String wName, int wDmg, int AC, int attackBonus) {
        super(health, wName, wDmg, AC, false, attackBonus, n);
        boolean checker = n.charAt(n.length() - 1) != 'n' || n.charAt(n.length() - 2) != 'i' || n.charAt(n.length() -3) != 'l';
        if (checker) {
            this.name = n + "-lin";
        }
        else {
            this.name = n;
        }
    }

    public Goblin() {
        super();
        this.name = "Bob-lin";
    }

    public String dialogue() {
        return "I am " + name + " the goblin!";
    }

    public String toString() {
        return super.toString() + " the goblin!\n" + "Health: " + health + "\n" + weapon.toString() + "\n" + "Armor class: " + armorClass + "\n";
    }


}
