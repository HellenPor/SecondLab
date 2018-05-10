package barbosshouse;

public class Dish extends MenuItem {

    private static final double DEFAULT_COST = 0.0;

    public Dish(String name, String description) {
        super( name, description,DEFAULT_COST);
    }

    public Dish(double cost, String name, String description) {
        super(name,description,cost);
    }

    @Override
    public String toString() {
        return "Dish: " + super.toString() + " " + getDescription();
    }

    @Override
    public boolean equals(Object obj) {
        super.equals(obj);
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ getDescription().hashCode();
    }


}
