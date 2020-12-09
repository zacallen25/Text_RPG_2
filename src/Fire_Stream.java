public class Fire_Stream implements Spell{
    int uses = 2;
    public int rollHit() {
        if (uses <= 0) {
            return 0;
        }
        uses--;
        return DiceTray.d20();
    }
    public int rollDieDamage() {
        return 10;
    }
    public Effects effect() {
        return Effects.FIRE;
    }
}

