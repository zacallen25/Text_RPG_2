//This is still very much in progress. The idea is that it would be the goblin class of magic attacks. The basic class for magical attacks
public class Magic_Mikael extends Monster{

    public Magic_Mikael() {
        super();
        this.isMagic = true;
    }

    public Magic_Mikael(int health, int armorClass, int attackBonus, String name, int initAdd) {
        super(health, armorClass, true, attackBonus, name, initAdd);
    }

    @Override
    public String getAction(Monster attacked) {
        Spell spell = Affect.getRandomSpell();
        return Affect.hitsAndHurtsSpell(attacked, this, spell);
    }
}
