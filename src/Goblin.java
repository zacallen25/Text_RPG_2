public class Goblin extends Monster{

    public Goblin(String n, int health, int AC, int attackBonus, int initAdd) {
        super(health, "Axe", 5, AC, false, attackBonus, n, initAdd);
        boolean checker = n.charAt(n.length() - 1) != 'n' || n.charAt(n.length() - 2) != 'i' || n.charAt(n.length() -3) != 'l';
        if (checker) {
            this.name = n + "-lin";
        }
        else {
            this.name = n;
        }
        initiative = initAdd + DiceTray.d20();
    }

    public Goblin() {
        super();
        this.name = "Bob-lin";
    }

    public String dialogue() {
        return super.toString() + " the goblin!\n" + "Health: " + health + "\n" + weapon.toString() + "\n" + "Armor class: " + armorClass + "\n";
    }


}
