import java.util.Hashtable;

public class Checkout {
    private Hashtable<String, Double> cartItems;

    Checkout(Hashtable<String, Double> userCartItems){
        cartItems = userCartItems;
    }

    public float calcTotal(){
        float total =0;
        /*needs a way to access item prices
         */
        for(String key: cartItems.keySet()){
            //total += cartItems.get(key).getPrice();
            System.out.println("Key:" + key);
            System.out.println("Item: " + cartItems.get(key));
        }
        return total;
    }
    
    public float taxCalc(Float userSalesTax){
        float taxTotal = 0;
        
        for(String key: cartItems.keySet()){
            //taxTotal += (cartItems.get(key).getPrice())/userSalesTax;
        }
        return taxTotal;
    }
    
    public String orderConfirmation(User user, int userID){
        return  ("Hello, " + user.getName() + ",\n\t Thank you for shopping with us! Your order " +
                "for $" + user.getCart().getFinalPrice(userID) + "has gone through. Your purchases are on their way to " +
                user.getAddress() + ".");

    }
    
    public String toString(){
        return "Congrats on your purchase";
    }
}

