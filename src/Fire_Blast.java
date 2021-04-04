public class Fire_Blast implements Spell{
    int turnsEffect = 2;
    public int rollHit() {
        return DiceTray.d20();
    }

    public int rollDieDamage() {
        return DiceTray.d6();
    }

    public Effects effect() {
        return Effects.FIRE;
    }

    @Override
    public int getTurnsEffect() {
        return turnsEffect;
    }
}
