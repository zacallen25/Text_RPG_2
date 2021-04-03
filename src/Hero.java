import java.io.PrintStream;
import java.util.Scanner;

public class Hero extends Monster{

    int karma = 0;
    //Rather than using a constructor for this, I decided to instead use this makeHero function to make a new hero using the system inputs
    //isNoob determines whether or not the person is new to RPGs. If they are (isNoob == true), then it simplifies the character creation process
    //customWeapon determines whether or not they want to use a custom-made weapon, or one of my pre-made weapons (presently I have a sword and an axe, which you can find in Weapon.java
    public void makeHero(boolean isNoob, boolean customWeapon) {
        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;
        out.println("Hello there! You are a brand-new hero! Please, enter your name");
        this.name = in.next();
        out.println("Hello there, " + this.name);
        out.println("What is your health?");
        this.health = in.nextInt();
        out.println("So, are you magical, or not? (Input true or false)");
        this.isMagic = in.nextBoolean();
        if (customWeapon) {
            out.println("What is your weapon name?");
            String weaponName = in.next();
            out.println("What is your weapon damage?");
            int weaponDamage = in.nextInt();
            this.weapon = new Weapon(weaponName, weaponDamage);
            if (isMagic) {
                weaponDamage -= 3;
            }
        }
        else {
            out.println("Are you using a sword or an axe?");
            String weaponName = in.next();
            weapon = new Weapon(weaponName, isMagic);
        }
        if (!isNoob) {
            out.println("What is your armor class?");
            this.armorClass = in.nextInt();
            out.println("What is your attack bonus?");
            this.attackBonus = in.nextInt();
            out.println("What is the initiative bonus?");
            int initAdd = in.nextInt();
            initiative = initAdd + DiceTray.d20();
        }
        else {
            armorClass = 13;
            attackBonus = 2;
            initiative = 2 + DiceTray.d20();
        }
    }

    //Uses the Monster abstract class default constructor
    public Hero() {
        super();
    }

    //This is how you make a hero using what you hard code in, instead of system input
    public Hero(String name, int health, String weaponName, int damage, int armorClass, boolean isMagic, int attackBonus, int initAdd) {
        super(health, weaponName, damage, armorClass, isMagic, attackBonus, name, initAdd);
        if (isMagic) {
            weapon = new Weapon(name, damage - 3);
        }
    }

    public Hero(String name, int health, String weaponName, int armorClass, boolean isMagic, int attackBonus, int initAdd) {
        this.name = name;
        this.health = health;
        this.weapon = new Weapon(weaponName, isMagic);
        this.armorClass = armorClass;
        this.isMagic = isMagic;
        this.attackBonus = attackBonus;
        this.initiative = initAdd + DiceTray.d20();
    }



    //Determines if they are using a spell or not
    public int getChoice() {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to attack with your weapon(1) or with a spell(2)?");
        int choice = input.nextInt();
        return choice;
    }

    public int getKarma() {return karma;}

    public void changeKarma(int changeKarma) {karma += changeKarma;}
    //Determines the action
    @Override
    public String getAction(Monster attacked) {
        int choice = getChoice();
        if (choice == 1) {
            return Affect.hitsAndHurts(attacked, this);
        }
        else {
            return Affect.hitAndHurtsSpell(attacked, this);
        }
    }

    @Override
    public String dialogue() {
        return "Hero's name is: " + name + "\n" + "Hero health: " + health + "\n" + weapon.toString() + "\n" + "Armor class: " + armorClass + "\n" + "Magical? " + isMagic;
    }
}
