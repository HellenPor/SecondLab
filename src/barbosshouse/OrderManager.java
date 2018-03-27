package barbosshouse;

import java.util.Objects;

public class OrderManager {
    private Order[] orders;

    public OrderManager(int tableNumber) {
        orders = new Order[tableNumber];
    }

    public void add(Order order, int tableNumber) {
        orders[tableNumber] = order;

    }

    public Order getOrder(int tableNumber) {
        if (orders[tableNumber] != null)
            return orders[tableNumber];
        else return null;
    }

    public void addDish(Dish dish, int tableNumber) {

        orders[tableNumber].add(dish);
    }

    public void removeOrder(int tableNumber) {
        orders[tableNumber] = null;
    }

    public int freeTableNumber() {
        for (int i = 0; i < orders.length; i++) {
            for (i = 0; i < orders.length; i++) {
                if (Objects.isNull(orders[i])) return i;
            }

        }
        return -1;
    }

    public int[] freeTableNumbers() {
        int count = 0;
        int i = 0, j = 0;

        while (i < orders.length) {
            if (orders[i] == null) {
                count++;
            }
            i++;
        }
        int[] tableNumbers = new int[count];

        while (i < orders.length) {
            if (orders[i] == null) {
                tableNumbers[j] = i;
                j++;
            }
            i++;
        }
        return tableNumbers;
    }

    public Order[] getOrders() {
        int i = 0, j = 0;
        int count = 0;

        while (i < orders.length) {
            if (orders[i] != null) {
                count++;
            }
            i++;
        }

        Order[] newOrders = new Order[count];
        while (i < orders.length) {
            if (orders[i] == null) {
                newOrders[j] = orders[i];
                j++;
            }
            i++;
        }
        return newOrders;
    }

    public double orderCostSummary() {
        double cost = 0;
        for (Order o : orders)
            if (o != null)
                cost += o.costTotal();
        return cost;
    }

    public int dishQuantity(String dishName) {
        int count = 0;
        for (Order x : orders) {
            if (x != null) {
                count += x.dishQuantity(dishName);
            }
        }

        return count;
    }
}