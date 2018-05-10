package barbosshouse;

public class MenuItem {
    private double cost;
    private String name;
    private String description;
    private static final double DEFAULT_COST = 0;

    protected MenuItem(String name, String description) {
        this(name, description, DEFAULT_COST);
    }

    protected MenuItem(String name, String description, double cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {

        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + ", " + cost + "p";
    }


    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof MenuItem) {
            return ((MenuItem) obj).name.equals(name) && ((MenuItem) obj).cost == cost;
        }
        return false;
    }

    public int hashCode() {
       return name.hashCode() ^ Double.hashCode(cost);
    }
    }


