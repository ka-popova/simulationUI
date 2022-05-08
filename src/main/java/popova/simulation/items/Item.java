package popova.simulation.items;

public abstract class Item {
//    private Coordinates coordinates;
//
//    public Coordinates getCoordinates() { return coordinates;}
//    public void setCoordinates(int x, int y) {
//
//    }


    private int healthLevel;

    public Item(int healthLevel) {
        this.healthLevel = healthLevel;
    }



    public int getHealthLevel() {
        return healthLevel;
    }



    public void setHealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
    }

    public boolean isKilled (){
        return healthLevel <= 0;
    }

    public void setHealthToZero() {
        healthLevel = 0;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName().substring(0,3);
    }
}
