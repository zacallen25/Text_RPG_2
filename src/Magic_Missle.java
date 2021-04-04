public class Magic_Missle implements Spell{
    int uses = 3;
    public int rollHit() {
        if (uses <= 0) {
            return 0;
        }
        uses--;
        return DiceTray.d20();
    }
    public int rollDieDamage() {
        return DiceTray.d6() + DiceTray.d6() + DiceTray.d6();
    }

    public Effects effect() {
        return Effects.NONE;
    }

    @Override
    public int getTurnsEffect() {
        return 0;
    }

}
