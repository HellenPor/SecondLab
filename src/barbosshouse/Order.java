package barbosshouse;

import java.lang.reflect.Array;

public class Order {
    private int size;
    private Dish[] dishes;
    private static final int DEFAULT_COST=16;
    public Order() {
        //todo конастанты класса,вызвать конструктор с order size
        this(new Dish[DEFAULT_COST]);



    }

    public Order(int size) {
        //todo передать из другого
         this(new Dish[size]);
    }

    public Order(Dish[] dishes) {
        // todo новый массив и копировать элементы dishes
        this.dishes=new Dish[dishes.length];
        int i = 0, j = 0;
        while (i < dishes.length) {
            if (dishes[i] != null) {
                this.dishes[j] = dishes[i];
                j++;
            }
            i++;
        }
        size = j++;

    }

    public boolean add(Dish dish) {
        //todo условие при значеннии равном 0

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
        //todo обычный for
        double cost = 0;
        for (int i=0; i<dishes.length; i++) {
            cost += dishes[i].getCost();
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
            //todo добавить счетчк уникальных имен.возвращать  массив размера. как показывает счетчик
       int count=0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                check = !dishes[i].getName().equals(dishesNamesArray[j]);


                if (check) {
                    for ( j = 0; j < size; j++)
                        if (dishesNamesArray[j] == null)
                            count++;
                }

            }
        }
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





