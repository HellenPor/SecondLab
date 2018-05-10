package barbosshouse;

public class TableOrder {
    private int size;
    private MenuItem[] items;
    private Customer customer;

    private static final int DEFAULT_COST = 16;

    public TableOrder() {
        this(DEFAULT_COST, Customer.MATURE_UNKNOWN_CUSTOMER);
    }

    public TableOrder(int size, Customer customer) {
        this(new MenuItem[size], customer);
    }

    public TableOrder(MenuItem[] items, Customer customer) {
        this.items = new MenuItem[items.length];
        size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                this.items[size] = items[i];
                size++;
            }
        }
        size++;
        this.customer = customer;

    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean add(MenuItem menuItem) {
        if (size >= items.length) {
            MenuItem[] newitems = new MenuItem[items.length * 2];
            System.arraycopy(items, 0, newitems, 0, size);
            items = newitems;
        }
        items[size] = menuItem;
        size++;
        return true;
    }

    public boolean remove(String MenuItemName) {
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (MenuItemName.equals(items[i].getName())) {
                    System.arraycopy(items, i + 1, items, i, items.length - i - 1);
                    items[items.length - 1] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public int removeAll(String MenuItemName) {
        int count = 0;
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (MenuItemName.equals(items[i].getName())) {
                    System.arraycopy(items, i + 1, items, i, items.length - i - 1);
                    count++;
                    items[items.length - 1] = null;
                }
            }
        }
        return count;
    }

    public int itemsQuantity() {
        return size;
    }

    public int itemsQuantity(String MenuItemName) {
        int number = 0;
        for (MenuItem menuItem : items) {
            if (MenuItemName.equals(menuItem.getName()))
                number++;
        }
        return number;
    }


    public MenuItem[] getitems() {
        MenuItem[] newitems = new MenuItem[size];
        System.arraycopy(items, 0, newitems, 0, size);
        return newitems;
    }

    public double costTotal() {
        double cost = 0;
        for (int i = 0; i < size; i++) {
            cost += items[i].getCost();
        }
        return cost;
    }


    public String[] itemsNames() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (items[i].getName().equals(items[j].getName()))
                    count++;
            }
        }

        boolean check = false;
        String[] itemsNamesArray = new String[size - count];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < itemsNamesArray.length; j++) {
                check = !items[i].getName().equals(itemsNamesArray[j]);
                if (check) {
                    for (j = 0; j < itemsNamesArray.length; j++)
                        if (itemsNamesArray[j] == null)
                            itemsNamesArray[j] = items[i].getName();
                }

            }
        }

        return itemsNamesArray;
    }


    public MenuItem[] sortedDishesByCostDesc() {

        MenuItem[] sorteditems = getitems();
        for (int i = sorteditems.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sorteditems[j].getCost() < sorteditems[j + 1].getCost()) {
                    MenuItem tmp = sorteditems[j];
                    sorteditems[j] = sorteditems[j + 1];
                    sorteditems[j + 1] = tmp;
                }
            }

        }
        return sorteditems;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TableOrder: ");
        if (size != 0) sb.append(size).append("\n ");
        for (int i = 0; i < items.length; i++) {
            sb.append(items[i].toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        TableOrder object = (TableOrder) obj;
        if (!customer.equals(object.customer)) return false;
        if (!(itemsQuantity() == object.itemsQuantity())) return false;
        String[] names = itemsNames();

        for (String s : names) {
            if (itemsQuantity(s) != object.itemsQuantity(s)) return false;
        }

        return true;
    }


    @Override
    public int hashCode() {
        int hash = 0;

        for (MenuItem i : items) {
            hash ^= i.hashCode();
        }

        return size ^ customer.hashCode() ^ hash;
    }
}





