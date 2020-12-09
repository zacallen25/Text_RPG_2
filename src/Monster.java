//The abstract class that all characters, both heroes and bad guys, are children of
public abstract class Monster {
    int health;
    Weapon weapon;
    int armorClass;
    boolean isMagic;
    int attackBonus;
    String name;
    int initiative;
    State status = State.ALIVE;
    Effects effect = Effects.NONE;

    public Monster() {
        this.name = "None";
        this.health = 1;
        weapon = new Weapon();
        this.attackBonus = 0;
        this.isMagic = false;
        this.armorClass = 0;
        initiative = DiceTray.d20();
    }

    public Monster(int health, Weapon weapon, int armorClass, boolean isMagic, int attackBonus, String name, int initAdd) {
        this.health = health;
        this.weapon = weapon;
        this.armorClass = armorClass;
        this.isMagic = isMagic;
        this.attackBonus = attackBonus;
        this.name = name;
        this.initiative = initAdd + DiceTray.d20();
    }

    public Monster(int health, int armorClass, boolean isMagic, int attackBonus, String name, int initAdd) {
        this.health = health;
        this.weapon = null; //No weapon in this constructor
        this.armorClass = armorClass;
        this.isMagic = isMagic;
        this.attackBonus = attackBonus;
        this.name = name;
        this.initiative = initAdd + DiceTray.d20();
    }

    public Monster(int health, String weaponName, int weaponDamage, int armorClass, boolean isMagic, int attackBonus, String name, int initAdd) {
        this.health = health;
        weapon = new Weapon(weaponName, weaponDamage);
        this.armorClass = armorClass;
        this.isMagic = isMagic;
        this.attackBonus = attackBonus;
        this.name = name;
        this.initiative = initAdd + DiceTray.d20();
    }

    //Most of these simply return the associated member variable
    public int getHealth() {
        return health;
    }

    public Weapon getWeaponInfo() {
        return weapon;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public String dialogue() {
        return "No dialogue";
    }

    public int returnInitiative() {
        return initiative;
    }

    //This monster attacks the attacked monster
    public String getAction(Monster attacked) {
        return Affect.hitsAndHurts(attacked, this);
    }

    public boolean isMagical() {
        return isMagic;
    }

    public State getStatus() {return status;}

    //Changes the status
    public void changeStatus(State newState) { status = newState;}

    public Effects getEffect() {return effect;}

    //Changes the effect
    public void changeEffect(Effects newEffect) { effect = newEffect;}

    //These two change the health
    public void addHealth(int add) {
        health += add;
    }

    public void removeHealth(int subtract) {
        health -= subtract;
    }

    //Changes the attack bonus
    public void changeAttackBonus(int change) {attackBonus += change; }

    public int getAttackBonus() {
        return attackBonus;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
