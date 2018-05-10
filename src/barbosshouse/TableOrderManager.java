package barbosshouse;
import java.util.Objects;
import java.util.function.Predicate;

public class TableOrderManager {
    private TableOrder[] tableOrders;


    public TableOrderManager(int tableCount) {
        tableOrders = new TableOrder[tableCount];
    }

    public void add(TableOrder tableOrder, int tableNumber) {
        tableOrders[tableNumber] = tableOrder;
    }

    public TableOrder getOrder(int tableNumber) {
        return tableOrders[tableNumber];
    }

    public void addItem(MenuItem menuItem, int tableNumber) {
        tableOrders[tableNumber].add(menuItem);
    }

    public void remove(int tableNumber) {
        tableOrders[tableNumber] = null;
    }

    public int freeTableNumber() {
        for (int i = 0; i < tableOrders.length; i++) {
            if (Objects.isNull(tableOrders[i])) return i;
        }
        return -1;
    }


    private int checkTable(Predicate<TableOrder> predicate) {
        int i, count = 0;
        for (i = 0; i < tableOrders.length; i++) {
            if (predicate.test(tableOrders[i])) count++;
        }
        return count;
    }

    private int[] getArrayTableNumbers(Predicate<TableOrder> predicate) {
        int[] tableNumbers = new int[checkTable(predicate)];
        int i = 0, j = 0;
        while (i < tableOrders.length) {
            if (predicate.test(tableOrders[i])) {
                tableNumbers[j] = i;
                j++;
            }
            i++;
        }

        return tableNumbers;
    }


    public int[] bookedTableNumbers() {
        return getArrayTableNumbers(s -> !Objects.isNull(s));
    }

    public int[] freeTableNumbers() {
        return getArrayTableNumbers(Objects::isNull);
    }

    public TableOrder[] getTableOrders() {
        int i = 0, j = 0;
        int count = 0;
        for (TableOrder o : tableOrders) {
            if (o != null)
                count++;
        }
        TableOrder[] newTableOrders = new TableOrder[count];

        for (TableOrder o : tableOrders) {
            if (o != null){
                newTableOrders[j] = o;
                j++;
            }
        }

        return newTableOrders;
    }

    public double orderCostSummary() {
        double cost = 0;
        for (TableOrder o : tableOrders)
            if (o != null)
                cost += o.costTotal();
        return cost;
    }

    public int itemsQuantity(String itemName) {
        int count = 0;
        for (TableOrder x : tableOrders) {
            if (x != null) {
                count += x.itemsQuantity(itemName);
            }
        }
        return count;
    }

}
