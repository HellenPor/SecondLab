package barbosshouse;

import javax.xml.bind.annotation.XmlType;

public class Address {
    private String cityName;
    private int zipCode;
    private int buildingNumber;
    private char buildingLetter;
    private int apartmentNumber;
    private String streetName;

    private static final String DEFAULT_CITY = "Samara";
    private static final int DEFAULT_NUMBER = -1;
    private static final String DEFAULT_STRING = "";
    private static final char DEFAULT_LETTER = 'r';
    public static final Address DEFAULT_ADDRESS= new Address();

    public Address(String cityName, int zipCode, String streetName, int buildingNumber, char buildingLetter, int apartmentNumber) {
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.buildingLetter = buildingLetter;
        this.apartmentNumber = apartmentNumber;

    }

    public Address(String streetName,int buildingNumber, char buildingLetter, int apartmentNumber) {
        this(DEFAULT_CITY, DEFAULT_NUMBER, streetName, buildingNumber, buildingLetter, apartmentNumber);
    }

    public Address() {
        this(DEFAULT_CITY, DEFAULT_NUMBER, DEFAULT_STRING, DEFAULT_NUMBER, DEFAULT_LETTER, DEFAULT_NUMBER);

    }


    public String getCityName() {
        return cityName;
    }

    public int getZipCode() {

        return zipCode;
    }



    public int getBuildingNumber() {

        return buildingNumber;
    }


    public char getBuildingLetter() {
        return buildingLetter;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Address: ");
        if (!cityName.equals(DEFAULT_STRING)) sb.append(cityName).append(" ");
        if(zipCode!=-1) sb.append(zipCode) .append(",");
        if(streetName != DEFAULT_STRING) sb.append(streetName).append(" ");
        if (buildingNumber != DEFAULT_NUMBER)sb.append(buildingNumber);
        if (buildingLetter !=DEFAULT_LETTER) sb.append(buildingLetter).append("-");
        if(apartmentNumber!= DEFAULT_NUMBER) sb.append(apartmentNumber);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj){
     if(this == obj){
         return true;
     }
     if (obj instanceof Address){
         return ((Address) obj).cityName.equals(cityName)&& ((Address) obj).zipCode == zipCode && ((Address)obj).streetName.equals(streetName)
                 && ((Address)obj).buildingNumber == buildingNumber
                 && ((Address)obj).buildingLetter ==buildingLetter &&
                 ((Address)obj).apartmentNumber == apartmentNumber;
     }
     return false;
     }

     @Override
     public int hashCode(){
         return cityName.hashCode()^zipCode^streetName.hashCode()^buildingNumber^buildingLetter^apartmentNumber;
}



}

