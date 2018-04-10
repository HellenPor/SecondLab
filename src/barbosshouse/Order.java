package barbosshouse;

import java.lang.reflect.Array;

public class Order {
    private int size;
    private Dish[] dishes;
    private static final int DEFAULT_COST = 16;
    public Order() {
        this(DEFAULT_COST);
    }

    public Order(int size) {
        dishes = new Dish[size];
    }

    public Order(Dish[] dishes) {
        this.dishes=new Dish[dishes.length];
        size = 0;
        for(int i = 0; i < dishes.length; i++){
            if (dishes[i] != null) {
                this.dishes[size] = dishes[i];
                size++;
            }
        }
        size++;
        //todo для циклов с индексами логичнее использовать for не?
    }

    public boolean add(Dish dish) {
        if (size >= dishes.length) {
            Dish[] newDishes = new Dish[dishes.length * 2];
            System.arraycopy(dishes, 0, newDishes, 0, size);
            dishes = newDishes;
        }
        dishes[size] = dish;
        size++;
        return true;
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
        }
        return false;
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
        //todo обычный for до size, а не до dishes.length
        double cost = 0;
        for (Dish dish : dishes) {
            cost += dish.getCost();
        }
        return cost;
    }


    public String[] dishesNames() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (dishes[i].getName().equals(dishes[j].getName()))
                    count++;
            }
        }

        boolean check = false;
        String[] dishesNamesArray = new String[size - count];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < dishesNamesArray.length; j++) {
                check = !dishes[i].getName().equals(dishesNamesArray[j]);
                if (check) {
                    for (j = 0; j < dishesNamesArray.length; j++)
                        if (dishesNamesArray[j] == null)
                            dishesNamesArray[j] = dishes[i].getName();
                }

            }
        }
        //todo добавить счетчк уникальных имен.возвращать  массив размера. как показывает счетчик

        return dishesNamesArray;
    }


    public Dish[] sortedDishesByCostDesc() {

        Dish[] sortedDishes = getDishes();
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





