package pl.waw.sgh;

/**
 * Created by harib on 06.06.2016.
 */
public class Player {
    private String name;
    private boolean ai;
    private char counter;

    public Player(String name, boolean ai, char counter) {
        this.name = name;
        this.ai = ai;
        this.counter = counter;
    }

    public void artInt(int dx, int dy){

    }

    public String getName() {
        return name;
    }

    public boolean isAi() {
        return ai;
    }

    public char getCounter() {
        return counter;
    }
}
