package barbosshouse;

public class Drink extends MenuItem implements Alcoholable {
    private double alcoholVol;
    private DrinkTypeEnum type;

    public final static double DEFAULT_NUMBER = 0;
    public final static String DEFAULT_STRING= "";

    public Drink(double cost, String name, DrinkTypeEnum type, String description, double alcoholVol) {
        super(name, description, cost);
        this.alcoholVol = alcoholVol;
        this.type = type;
    }

    public Drink(double cost, String name, DrinkTypeEnum type, String description) {
        this(cost, name, type, description, DEFAULT_NUMBER);
    }

    public Drink(String name, DrinkTypeEnum type){
        this(DEFAULT_NUMBER, name,type, DEFAULT_STRING,DEFAULT_NUMBER);

    }

    @Override
    public boolean isAlcoholicDrink() {
        return false;
    }

    @Override
    public double getAlcoholVol() {
        return alcoholVol;
    }

    public DrinkTypeEnum getType() {
        return type;
    }

    @Override
    public String toString() {
        return isAlcoholicDrink() ?
                "Drink: " + type + super.toString() :
                "Drink: " + type + super.toString() + " Alcohol: " + getAlcoholVol() + "%. " + super.getDescription();
    }

      @Override
      public boolean equals(Object obj) {
          boolean eq = super.equals(obj);
          Drink o = (Drink) obj;

          return eq & alcoholVol == o.alcoholVol & type == o.type;
      }

    @Override
    public int hashCode() {
        return super.hashCode() ^ Double.hashCode(alcoholVol) ^ type.hashCode();
    }
      }

