import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CartDao{

    private Connection connection;
    private int stockQuantity;
    private double totalPrice;
    private double price;

    // Constructor initializes database connection.
    CartDao(String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://dany.simmons.edu:3306/33501sp20_carletoc?useUnicode=yes&characterEncoding=UTF-8",
                    user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Checks if Item is in Stock.
    // If so, adds the item into a cart while subtracting 1 from the stock_quantity in Inventory Column
    public void addItem(int userId, int prodId) {
        try {
            Statement insertItem = connection.createStatement();
            Statement inventoryStockCheck = connection.createStatement();
            Statement minusStockQuant = connection.createStatement();
            ResultSet rs = inventoryStockCheck.executeQuery(
                    "SELECT Inventory.stock_quantity FROM Inventory where Inventory.product_id="+ prodId );
            while (rs.next()) {
                stockQuantity = (rs.getInt(1));
            }
            if( stockQuantity > 0 ){
                insertItem.execute(
                        "INSERT INTO ShoppingCart (user_id, product_id)" +
                                "VALUES ("+ userId + "," + prodId +")"
                );
                minusStockQuant.execute(
                        "UPDATE Inventory SET stock_quantity = stock_quantity - 1 WHERE product_id =" + prodId);

            }
            else{
                System.out.print("YOU CAN NOT ADD THIS ITEM");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Deleting an item from a cart. And adds the adds 1 to the stock_quantity in Inventory Column
    public void deleteItem(int userId, int prodId) {
        try {
            Statement deleteItem = connection.createStatement();
            deleteItem.execute(
                    "DELETE FROM ShoppingCart WHERE (product_id = '" + prodId +
                            "' AND user_id = '" + userId + "') ORDER BY cart_items_id ASC LIMIT 1 "
            );
            Statement addStockQuant = connection.createStatement();
            addStockQuant.execute(
                    "UPDATE Inventory SET stock_quantity = stock_quantity + 1 WHERE product_id =" + prodId);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Getting Prices of Items in Cart
    public Double itemPrice(int id) {
        try {
            Statement itemPrice = connection.createStatement();
            ResultSet rs = itemPrice.executeQuery(
                    "SELECT Inventory.product_price FROM Inventory INNER JOIN ShoppingCart " +
                            "ON Inventory.product_id=ShoppingCart.product_id WHERE ShoppingCart.user_id= "+ id);
            while (rs.next()) {
                price = (rs.getDouble(1));
                totalPrice += price;
            }

            return totalPrice;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Reads and prints all items in a user's cart
    public void list(int id) {
        try {
            Statement selectItems = connection.createStatement();
            ResultSet rs = selectItems.executeQuery(
                    "SELECT ShoppingCart.cart_items_id, ShoppingCart.user_id, Inventory.product_id, Inventory.product_price " +
                    "FROM Inventory INNER JOIN ShoppingCart " +
                            "ON Inventory.product_id=ShoppingCart.product_id WHERE ShoppingCart.user_id="+id);
            while (rs.next()) {
                System.out.println("Cart_Items_ID: " + rs.getInt(1));       // Item Index
                System.out.println("UserID: " + rs.getInt(2));      // UserID
                System.out.println("ProductID: " + rs.getInt(3));  // Product ID
                System.out.println("ProductPrice: " + rs.getInt(4));  // Product ID
                System.out.println("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}