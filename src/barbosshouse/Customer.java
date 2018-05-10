package barbosshouse;

public class Customer {
    private String firstName;
    private String secondName;
    private int age;
    private Address address;

    public static final int DEFAULT_MATURE = 21;
    public static final int DEFAULT_NOT_MATURE = 14;

    public static final Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer(DEFAULT_NOT_MATURE);
    public static final Customer MATURE_UNKNOWN_CUSTOMER = new Customer(DEFAULT_MATURE);

    private static final String DEFAULT_STRING = "";
    private static final int DEFAULT_NUMBER = -1;


    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    public Customer(int age) {
        this(DEFAULT_STRING, DEFAULT_STRING, age, Address.DEFAULT_ADDRESS);
    }

    public Customer() {
        this(DEFAULT_STRING, DEFAULT_STRING, DEFAULT_NUMBER, Address.DEFAULT_ADDRESS);
    }


    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address address() {
        return address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Customer: ");
        if (!secondName.equals(DEFAULT_STRING)) sb.append(secondName).append(" ");
        if (!firstName.equals(DEFAULT_STRING)) sb.append(firstName).append(",");
        if (age != DEFAULT_NUMBER) sb.append(age).append(",");
        if (!address.equals(Address.DEFAULT_ADDRESS)) sb.append(address).append("");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Customer) {
            return ((Customer) obj).secondName.equals(secondName) && ((Customer) obj).firstName.equals(firstName) && ((Customer) obj).age == age
                    && ((Customer) obj).address.equals(address);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return firstName.hashCode() ^ secondName.hashCode() ^ age ^ address.hashCode();
    }
}
