import java.util.ArrayList;

/**
 * @ author Amran Hassan
 */

public class MultithreadingProducer extends Thread {
    private int prod_id;

    public MultithreadingProducer(int prod_id){
            this.prod_id = prod_id;
        }
        public void run() {
            Inventory product = new Inventory(prod_id);
            try {
                System.out.println("***** PRODUCER has started looking at Inventory*****");
                System.out.println("Producer is currently looking at "+ product.getProductName() );
                System.out.println( product.getProductName()+ "  is located in the " + product.getProductDepartment() + " Department");
                System.out.println( "It's current Selling Price is" + product.getProductPrice() );
                //adding or removing items

            } catch (Exception e){
                System.out.println("***** PRODUCER has been interrupted while looking at Inventory*****");

            }
            System.out.println("***** PRODUCER has Stopped looking at Inventory*****");

        }
}
