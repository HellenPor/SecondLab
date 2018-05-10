package barbosshouse;

public class InternetOrder implements Order {
    private int size;
    private ListNode head;
    private ListNode tail;
    private Customer customer;

    public InternetOrder() {
        size = 0;
    }

    public InternetOrder(MenuItem[] items, Customer customer) {
        for (MenuItem s : items) this.add(s);
        this.customer = customer;
    }

    public boolean add(MenuItem item) {
        ListNode node = new ListNode(item);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }

        size++;
        return true;
    }

    private void remove(ListNode node, ListNode prev) {
        if (prev != null) {
            prev.setNext(node.getNext());

            if (node.getNext() == null) {
                tail = prev;
            }
        } else {
            head = head.getNext();

            if (head == null) {
                tail = null;
            }
        }
    }

    public boolean remove(String itemName) {
        ListNode node = head;
        ListNode prev = null;

        while (node != null) {
            if (itemName.equals(node.value.getName())) {
                remove(node, prev);

                size--;

                return true;
            }

            prev = node;
            node = node.getNext();
        }


        return false;
    }


    public boolean remove(MenuItem item) {
        ListNode node = head;
        ListNode prev = null;

        while (node != null) {
            if (item.equals(node.value)) {
                remove(node, prev);

                size--;

                return true;
            }

            prev = node;
            node = node.getNext();
        }

        return false;
    }


    public int removeAll(String itemName) {
        ListNode node = head, prev = null;
        int count = 0;
        while (node != null) {
            if (itemName.equals(node.value.getName())) {
                remove(node, prev);
                size--;
                count++;
            }
            prev = node;
            node = node.getNext();
        }

        return count;
    }

    public int removeAll(MenuItem item) {
        ListNode node = head, prev = null;
        int count = 0;
        while (node != null) {
            if (item.equals(node.value)) {
                remove(node, prev);
                size--;
                count++;
            }
            prev = node;
            node = node.getNext();
        }

        return count;
    }

    public int itemsQuantity() {
        return size;
    }

    public int itemsQuantity(String dishName) {
        int i, count = 0;
        ListNode order = head;

        for (i = 0; i < size; i++) {
            if (dishName.equals(order.value.getName())) count++;
            order = order.getNext();
        }

        return count;
    }

    public int itemsQuantity(MenuItem item) {
        int i, count = 0;
        ListNode order = head;

        for (i = 0; i < size; i++) {
            if (item.equals(order.value)) count++;
            order = order.getNext();
        }

        return count;
    }

    public MenuItem[] getMenuItems() {
        int i;
        MenuItem[] items = new MenuItem[size];
        ListNode node = head;

        for (i = 0; i < size; i++) {
            if (node != null)
                items[i] = node.value;
            node = node.getNext();
        }

        return items;
    }

    public double costTotal() {
        double cost = 0;
        int i;
        ListNode node = head;

        for (i = 0; i < size; i++) {
            cost += node.value.getCost();
            node = node.getNext();
        }

        return cost;
    }

    private boolean addInArr(String[] arr, String str, int pos) {
        for (String x : arr) {
            if (str.equals(x)) return false;
        }

        arr[pos] = str;
        return true;

    }

    public String[] itemsNames() {
        int count = 0;
        MenuItem[] arr = getMenuItems();

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                if (arr[i].getName().equals(arr[j].getName())) count++;
            }
        }

        String[] names = new String[size - count];

        label:
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[j] != null & addInArr(names, arr[j].getName(), i)) continue label;
            }
        }

        return names;
    }

    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] sortedItems = getMenuItems();
        for (int i = sortedItems.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sortedItems[j].getCost() < sortedItems[j + 1].getCost()) {
                    MenuItem tmp = sortedItems[j];
                    sortedItems[j] = sortedItems[j + 1];
                    sortedItems[j + 1] = tmp;
                }
            }

        }
        return sortedItems;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        MenuItem[] items = getMenuItems();
        StringBuilder sb = new StringBuilder("InternetOrder:\n");
        if (customer != null) {
            sb.append(getCustomer().toString()).append("\n").append(items.length).append("\n");
        } else {
            sb.append("Unknown customer!").append("\n").append(items.length).append("\n");
        }

        for (MenuItem item : items) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || this.getClass() == obj.getClass()) return false;

        InternetOrder o = (InternetOrder) obj;

        if (!o.customer.equals(customer)) return false;

        if (size != o.size) return false;

        String[] names = itemsNames();

        for (String s : names) {
            if (itemsQuantity(s) != o.itemsQuantity(s)) return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        MenuItem[] items = getMenuItems();
        int hash = 0;

        for (MenuItem x : items) {
            hash ^= x.hashCode();
        }


        return Integer.hashCode(size) ^ customer.hashCode() ^ head.hashCode() ^ tail.hashCode() ^ hash;
    }

    private class ListNode {
        private ListNode next;
        private MenuItem value;

        ListNode(MenuItem menuItem) {
            this.value = menuItem;
        }

        ListNode getNext() {
            return next;
        }

        void setNext(ListNode next) {
            this.next = next;
        }
    }
}