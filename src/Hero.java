import java.io.PrintStream;
import java.util.Scanner;

public class Hero extends Monster{

    public void makeHero() {
        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;
        out.println("Hello there! You are a brand-new hero! Please, enter your name");
        this.name = in.next();
        out.println("Hello there, " + name);
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
        out.println("What is the initiative bonus?");
        int initAdd = in.nextInt();
        initiative = initAdd + DiceTray.d20();
        if (isMagic) {
            weaponDamage -= 3;
        }
        this.weapon = new Weapon(weaponName, weaponDamage);
    }


    public Hero() {
        super();
    }

    public Hero(String name, int health, String weaponName, int damage, int armorClass, boolean isMagic, int attackBonus, int initAdd) {
        super(health, weaponName, damage, armorClass, isMagic, attackBonus, name, initAdd);
        if (isMagic) {
            weapon = new Weapon(name, damage - 3);
        }
    }

    public int getChoice() {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to attack with your weapon(1) or with a spell(2)?");
        int choice = input.nextInt();
        return choice;
    }

    @Override
    public String getAction(Monster attacked, Monster attacker) {
        int choice = getChoice();
        if (choice == 1) {
            return Affect.hitsAndHurts(attacked, attacker);
        }
        else {
            return Affect.hitAndHurtsSpell(attacked, attacker);
        }
    }

    @Override
    public String dialogue() {
        return "Hero's name is: " + name + "\n" + "Hero health: " + health + "\n" + weapon.toString() + "\n" + "Armor class: " + armorClass + "\n" + "Magical? " + isMagic;
    }



}
