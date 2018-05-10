package barbosshouse;

public interface Order {

    public void setCustomer(Customer customer);

    public Customer getCustomer();

    public boolean add(MenuItem MenuItem);

    public boolean remove(MenuItem menuItem);

    public int removeAll(MenuItem menuItem);

    public int itemsQuantity();

    public int itemsQuantity(MenuItem menuItem);

    public int itemsQuantity(String menuItemName);

    public MenuItem[] getMenuItems();

    public double costTotal();

    public String[] itemsNames();

    public MenuItem[] sortedItemsByCostDesc();

    public String toString();

    public boolean equals(Object obj);

    public int hashCode();
}
