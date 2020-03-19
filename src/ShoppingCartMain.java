public class ShoppingCartMain {
    public static void main(String[] args) {
        int max = 4;
        int min = 1;
        int id = (int)(Math.random()*(max-min+1)+min);
        User user = new User(id);
        System.out.println(user.getName()); //Name of Client
        Cart cart = user.getCart();
        //System.out.println(cart.getItems(id)); //getItems is inside a HashMap but will not Print out all items on the list, since it can't handle duplicates
        cart.add(id,3);
        cart.list(id);
        cart.add(id, 3);
        cart.list(id);
        System.out.println(cart.getCartPrice(id)); //cartPrice without Sales Tax
        System.out.println(cart.getSalesTax(id));  //Sales Tax of person's state
        System.out.println(cart.getFinalPrice(id)); //Final Price at checkout

    }
    
}
