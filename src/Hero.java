public class Hero implements Monster{
    private int health;
    private Weapon weapon;
    //private Elements elementPersonal;

    public Hero() {
        health = 0;
        weapon = new Weapon();
    }

    public Hero(int health, String name, int damage) {
        this.health = health;
        weapon = new Weapon(name, damage);
        //this.elementPersonal = elementPersonal;

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

    public void addHealth(int add) {
        health += add;
    }

    public void removeHealth(int subtract) {
        health -= subtract;
    }

    @Override
    public String toString() {
        return "Hero health: " + health + "\n" + weapon.toString();
    }

}
