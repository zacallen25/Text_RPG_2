public interface Spell {
    //Each spell does certain amounts of damage, has a certain modifier, and does a certain effect
    public int rollHit();
    public int rollDieDamage();
    public Effects effect();
}
