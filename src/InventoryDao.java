import java.sql.*;
import java.util.Random;
public class InventoryDao {

    private Connection connection;

    //Constructor
    InventoryDao(String user, String password){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://dany.simmons.edu:3306/33501sp20_hassana?useUnicode=yes&characterEncoding=UTF-8",
                    user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Adds Stock to a product
    public void addStock(int prodId){
        try {
            Random rand = new Random();
            int randAddNum = rand.nextInt(10);//Random Number of stock to add
            int stockQuantNum = rand.nextInt(10); //Random Number to trigger the add stock Function to actually work
            Statement addStock = connection.createStatement();
            addStock.execute(
                    "UPDATE Inventory SET stock_quantity = stock_quantity + 1" +
                            " WHERE product_id =" + prodId + "AND stock_quantity < 1 ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Check Basic info of the Product
    public void checkStock(int prodId){
        try {
            Statement checkStock = connection.createStatement();
            checkStock.execute(
                    "SELECT PRODUCT_ID, PRODUCT_NAME, STOCK_QUANTITY FROM Inventory "
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Removes product from Inventory List
    public void delete(int prodId){
        try {
            Statement deleteProduct = connection.createStatement();
            deleteProduct.execute(
                        "DELETE PRODUCT_ID, PRODUCT_NAME, STOCK_QUANTITY FROM Inventory "
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Read and print all products in INVENTORY
    public void list() {
        try {
            Statement selectProducts = connection.createStatement();
            ResultSet rs = selectProducts.executeQuery(
                    "SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_DEPARTMENT, PRODUCT_PRICE, INITIAL_QUANTITY, STOCK_QUANTITY, SOLD_UNITS FROM Inventory");
            // Iterate over result set and print each book description.
            while (rs.next()) {
                System.out.println("Product Id: " + rs.getInt(1));
                System.out.println("Product Name: " + rs.getString(2));
                System.out.println("Product Department: " + rs.getString(3));
                System.out.println("Product Price: " + rs.getDouble(4));
                System.out.println("Initial Quantity: " + rs.getInt(5));
                System.out.println("Stock Quantity: " + rs.getInt(6));
                System.out.println("Sold Units: " + rs.getInt(7));
                System.out.println("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
