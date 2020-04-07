import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lila Crum
 */
class InventoryTest {
    private InventoryDao productData = new InventoryDao("carletoc", "1683864");
    private String productName;
    private String productDepartment;
    private double productPrice;
    private int initialQuantity;
    private int soldUnits;
    private int stockQuantity;
    private int numberOfProducts;

    /**
     * @author Lila Crum
     */
    @Test
    void addStock() {
        int currentStock = productData.checkStockLeft(1) + 3;
        addStock();
        assertEquals(currentStock, productData.checkStockLeft(1));
    }

    /**
     * @author Lila Crum
     */
    @Test
    void getProductName() {
        productName = productData.productName(1);
        assertEquals("USB thumb drive", productName);
    }

    /**
     * @author Lila Crum
     */
    @Test
    void getNumberOfProducts() {
        numberOfProducts = productData.numberOfProducts(1);
        assertEquals(10, numberOfProducts);
    }

    /**
     * @author Lila Crum
     */
    @Test
    void getProductDepartment() {
        productDepartment = productData.productDepartment(1);
        assertEquals("Electronics", productDepartment);
    }

    @Test
    void getProductPrice() {
        productPrice = productData.productPrice(1);
        assertEquals(22.63, productPrice);
    }

    /**
     * @author Lila Crum
     */
    @Test
    void getInitialQuantity() {
        initialQuantity = productData.checkInitialQuantity(1);
        assertEquals(10,initialQuantity);
    }

    /**
     * @author Lila Crum
     */
    @Test
    void getSoldUnits() {
        soldUnits = productData.checkSoldAmount(1);
        assertEquals(9,soldUnits);
    }

    /**
     * @author Lila Crum
     */
    @Test
    void getStockQuantity() {
        int stockQuantity = (productData.checkStockLeft(1)-1)%3;
        assertEquals(1, stockQuantity);
    }
}
