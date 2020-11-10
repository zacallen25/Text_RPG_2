public class Fire_Blast implements Spell{

    public int rollHit() {
        return DiceTray.d20();
    }

    public int rollDieDamage() {
        return DiceTray.d6();
    }

    public Effects effect() {
        return Effects.FIRE;
    }
}
