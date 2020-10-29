public interface Monster {
    public int getHealth();

    public Weapon getWeaponInfo();

    public int getArmorClass();

    public String dialogue();

    public void addHealth(int add);

    public void removeHealth(int subtract);

    @Override
    public String toString();
}
