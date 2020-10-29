public interface Spell {
    public DiceTray rand = new DiceTray();
    public int rollHit();
    public int rollDieDamage();
    public Effects effect();

    class Fire_Blast implements Spell {
        //Unlimited uses
        public int rollHit() {
            return rand.d20();
        }

        public int rollDieDamage() {
            return rand.d6();
        }

        public Effects effect() {
            return Effects.FIRE;
        }
    }

    class Ice_Blast implements Spell {
        //Unlimited uses
        public int rollHit() {
            return rand.d20();
        }
        public int rollDieDamage() {
            return rand.d6();
        }
        public Effects effect() {
            return Effects.FROZEN;
        }
    }

    class Fire_Stream implements Spell {
        int uses = 2;
        public int rollHit() {
            if (uses <= 0) {
                return 0;
            }
            uses--;
            return rand.d20();
        }
        public int rollDieDamage() {
            return rand.d12();
        }
        public Effects effect() {
            return Effects.FIRE;
        }
    }




}
