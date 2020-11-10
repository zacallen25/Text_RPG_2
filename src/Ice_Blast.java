public class Ice_Blast implements Spell{

    //Unlimited uses
    public int rollHit() {
        return DiceTray.d20();
    }
    public int rollDieDamage() {
        return DiceTray.d6();
    }
    public Effects effect() {
        return Effects.FROZEN;
    }
}
