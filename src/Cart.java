import java.util.Hashtable;

public class Cart {

    private CartDao cartData = new CartDao("hassana", "1810531");
    private Hashtable<String, Double> items;
    private Double totalPrice;

    private StateSalesTaxDao taxData = new StateSalesTaxDao("hassana", "1810531");
    private Double taxRate;
    private Double finalPrice;

    Cart(int userId){}


    public void add(int userId, int prodId){
        cartData.addItem(userId, prodId);
    }

    public void remove(int userId, int prodId){cartData.deleteItem(userId, prodId); }

    public Hashtable<String, Double> getItems(int userId){
        items = cartData.items(userId);
        return items;
    }
    public void price(int userId) {cartData.itemPrice(userId);}

    public Double getCartPrice(int userId) {
        totalPrice = cartData.itemPrice(userId);
        return totalPrice;
    }

    public Double getSalesTax(int userId) {
        taxRate= taxData.salesTax(userId);
        return taxRate;
    }

    public Double getFinalPrice(int userId) {
        finalPrice = totalPrice + (taxRate*totalPrice);
        return finalPrice;
    }

    public void list(int userId) {cartData.list(userId);}
    public void checkout(){

    }
}
