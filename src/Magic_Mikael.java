public class Magic_Mikael extends Monster{

    public Magic_Mikael() {
        this.isMagic = true;
    }
    public Magic_Mikael(int health, int armorClass, int attackBonus, String name) {
        super(health, armorClass, true, attackBonus, name);
    }



}
