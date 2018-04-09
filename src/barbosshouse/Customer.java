package barbosshouse;

public class Customer {
   private String firstName;
   private String secondName;
   private int age;
   private Address address;

    public static final int DEFAULT_MATURE= 21;
    public static final int DEFAULT_NOT_MATURE= 14;

    public static final Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer(DEFAULT_NOT_MATURE);
    public static final Customer MATURE_UNKNOWN_CUSTOMER = new Customer(DEFAULT_MATURE);

    private static final String EMPTY_VALUE = "";
    private static final int EMPTY_NUMBER = -1;


    public Customer(String firstName, String secondName, int age, Address address){
        this.firstName=firstName;
        this.secondName=secondName;
        this.age=age;
        this.address=address;
    }

    public Customer(int age){
        this(EMPTY_VALUE,EMPTY_VALUE,age,address);
    }

    public Customer(){
        this(EMPTY_VALUE,EMPTY_VALUE,EMPTY_NUMBER,address);
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

    public Address address(){
        return address;
    }

}
