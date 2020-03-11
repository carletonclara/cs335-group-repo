/**
 * @ author Clara Carleton
 */

public class Address {
    private AddressDao addressData = new AddressDao("carletoc", "1683864");
    private Address address;
    private String street;
    private String city;
    private String state;
    private CharSequence zipcode;

    Address(){

    }

    Address(String st, String c, String s, CharSequence zc){
        street = s;
        city = c;
        state = s;
        zipcode = zc;
    }

    Address(int user_id){
        street = addressData.getAddress(user_id).get(0);
        city = addressData.getAddress(user_id).get(1);
        state = addressData.getAddress(user_id).get(2);
        zipcode = addressData.getAddress(user_id).get(3);
    }

    public String getStreet(){ return street; }

    public String getCity() { return city; }

    public String getState() { return state; }

    public CharSequence getZipcode() { return zipcode; }
}