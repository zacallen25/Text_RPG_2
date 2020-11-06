import java.io.PrintStream;
import java.util.Scanner;

public class Hero implements Monster{
    private int health;
    private Weapon weapon;
    private int armorClass;
    private String personName;
    boolean isMagic;
    int attackBonus;

    public void makeHero(Scanner in) {
        PrintStream out = System.out;
        out.println("Hello there! You are a brand-new hero! Please, enter your name");
        this.personName = in.next();
        out.println("Hello there, " + personName);
        out.println("What is your health?");
        this.health = in.nextInt();
        out.println("So, are you magical, or not? (Input true or false)");
        this.isMagic = in.nextBoolean();
        out.println("What is your weapon name?");
        String weaponName = in.next();
        out.println("What is your weapon damage?");
        int weaponDamage = in.nextInt();
        out.println("What is your armor class?");
        this.armorClass = in.nextInt();
        out.println("What is your attack bonus?");
        this.attackBonus = in.nextInt();
        this.weapon = new Weapon(weaponName, weaponDamage);
    }


    public Hero() {
        this.personName = "N/A";
        this.health = 0;
        weapon = new Weapon();
        this.armorClass = 1;
        this.attackBonus = 0;
    }

    public Hero(String personName, int health, String name, int damage, int armorClass, boolean isMagic, int attackBonus) {
        this.health = health;
        weapon = new Weapon(name, damage);
        this.armorClass = armorClass;
        this.isMagic = isMagic;
        this.personName = personName;
        this.attackBonus = attackBonus;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeaponInfo() {
        return weapon;
    }

    public String dialogue() {
        return "Nothing (for now)";
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public String getName() {
        return personName;
    }

    public void addHealth(int add) {
        health += add;
    }

    public void removeHealth(int subtract) {
        health -= subtract;
    }

    public int getArmorClass() {
        return armorClass;
    }


    @Override
    public String toString() {
        return "Hero's name is: " + personName + "\n" + "Hero health: " + health + "\n" + weapon.toString() + "\n" + "Armor class: " + armorClass + "\n" + "Magical? " + isMagic;
    }

}
