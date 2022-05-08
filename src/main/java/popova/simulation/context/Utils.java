package popova.simulation.context;

public class Utils {
    public static final int MAX_X = 20;
    public static final int MAX_Y = 20;


    public static int rand (int min, int max) {

        return (int)(Math.random()*((max-min)+1))+min;
    }
}
