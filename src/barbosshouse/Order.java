package barbosshouse;

import java.lang.reflect.Array;

public class Order {
    private int size;
    private Dish[] dishes;


    public Order() {
        dishes = new Dish[16];
        size = 0;
    }

    public Order(int size) {
        dishes = new Dish[size];
        this.size = 0;
    }

    public Order(Dish[] dishes) {
        this.dishes = dishes;
    }

    public boolean add(Dish dish) {
        if (size != 0) {
            if (size == dishes.length) {
                Dish[] newDishes = new Dish[dishes.length * 2];
                System.arraycopy(dishes, 0, newDishes, 0, size);

                newDishes[size] = dish;
                dishes = newDishes;
                size++;
                return true;
            } else {
                for (int i = 0; i < dishes.length; i++) {
                    if (dishes[i] == null) {
                        dishes[i] = dish;
                        size++;
                        return true;
                    }
                }
                return false;
            }
        } else {
            dishes[0] = dish;
            size++;
            return true;
        }
    }

    public boolean remove(String dishName) {
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (dishName.equals(dishes[i].getName())) {
                    System.arraycopy(dishes, i + 1, dishes, i, dishes.length - i - 1);
                    dishes[dishes.length - 1] = null;
                    return true;
                }
            }
            return false;
        } else return false;
    }


    public int removeAll(String dishName) {
        int count = 0;
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (dishName.equals(dishes[i].getName())) {
                    System.arraycopy(dishes, i + 1, dishes, i, dishes.length - i - 1);
                    count++;
                    dishes[dishes.length - 1] = null;

                }

            }

        }
        return count;
    }

    public int dishQuantity() {
        return size;
    }

    public int dishQuantity(String dishName) {
        int number = 0;
        for (Dish dish : dishes) {
            if (dishName.equals(dish.getName()))
                number++;
        }
        return number;
    }


    public Dish[] getDishes() {
        Dish[] newDishes = new Dish[size];
        System.arraycopy(dishes, 0, newDishes, 0, size);
        return newDishes;
    }

    public double costTotal() {
        double cost = 0;
        for (Dish x : dishes) {
            cost += x.getCost();
        }
        return cost;
    }

    public String[] dishesNames() {

            boolean check = false;
            String[] dishesNamesArray = new String[size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    check = !dishes[i].getName().equals(dishesNamesArray[j]);


                    if (check) {
                        for ( j = 0; j < size; j++)
                            if (dishesNamesArray[j] == null)
                                dishesNamesArray[j] = dishes[i].getName();
                    }

                }
            }
            return dishesNamesArray;

    }



    public Dish[] sortedDishesByCostDesc() {
        Dish[] sortedDishes = new Dish[size];
        System.arraycopy(dishes, 0, sortedDishes, 0, size);
        for (int i = sortedDishes.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sortedDishes[j].getCost() < sortedDishes[j + 1].getCost()) {
                    Dish tmp = sortedDishes[j];
                    sortedDishes[j] = sortedDishes[j + 1];
                    sortedDishes[j + 1] = tmp;
                }
            }

        }
        return sortedDishes;
    }


}





