public abstract class Monster {
    int health;
    Weapon weapon;
    int armorClass;
    boolean isMagic;
    int attackBonus;
    String name;
    int initiative;

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
        this.weapon = null;
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

    public String getAction(Monster attacked, Monster attacker) {
        return Affect.hitsAndHurts(attacked, attacker);
    }

    public boolean isMagical() {
        return isMagic;
    }

    public void addHealth(int add) {
        health += add;
    }

    public void removeHealth(int subtract) {
        health -= subtract;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "My name is " + name;
    }
}
