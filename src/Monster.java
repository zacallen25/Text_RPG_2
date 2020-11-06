public interface Monster {
    public int getHealth();

    public Weapon getWeaponInfo();

    public int getArmorClass();

    public String dialogue();

    public void addHealth(int add);

    public void removeHealth(int subtract);

    public int getAttackBonus();

    public String getName();

    @Override
    public String toString();
}
