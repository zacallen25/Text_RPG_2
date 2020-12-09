import java.util.ArrayList;
//I've been working on this as a possible side project. Essentially, each element is weak to and strong against another element. I am not sure if I'll end up implementing this however
public enum Elements {
    FIRE, ICE, AIR, WATER, ELECTRIC, GRASS, GROUND, GHOSTLY, NONE;


    public boolean determineWeakness(Elements e, Elements other) {
        ArrayList<Elements> weak = new ArrayList<Elements>();
        if (e.equals(FIRE)) {
            weak.add(GROUND);
            weak.add(WATER);
        }
        else if (e.equals(ICE)){
            weak.add(FIRE);
            weak.add(WATER);
        }
        else if (e.equals(AIR)) {
            weak.add(GROUND);
            weak.add(GRASS);
        }
        else if (e.equals(WATER)) {
            weak.add(GROUND);
            weak.add(ELECTRIC);
        }
        else if (e.equals(ELECTRIC)) {
            weak.add(GROUND);
            weak.add(GRASS);
        }
        else if (e.equals(GRASS)) {
            weak.add(FIRE);
            weak.add(WATER);
        }
        else if (e.equals(GROUND)) {
            weak.add(GHOSTLY);
            weak.add(ICE);
        }
        else if (e.equals(GHOSTLY)){
            weak.add(FIRE);
            weak.add(AIR);
        }
        else {
            weak.add(NONE);
        }

        if (weak.contains(other)) {
            return true;
        }
        else {
            return false;
        }

    }

}
