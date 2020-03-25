import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lila Crum
 */
class InventoryDaoTest {
    private InventoryDao productData = new InventoryDao("carletoc", "1683864");

    /**
     * @author Lila Crum
     */
    @Test
    void numberOfProducts() {
        assertEquals(10,productData.numberOfProducts(2));
    }

    /**
     * @author Lila Crum
     */
    @Test
    void addStock() {
        productData.addStock(2);
        assertEquals(13, productData.checkStockLeft(2));
    }

    /**
     * @author Lila Crum
     */
    @Test
    void productName() {
        assertEquals("Toothbrush", productData.productName(2));
    }

    /**
     * @author Lila Crum
     */
    @Test
    void productDepartment() {
        assertEquals("Health",productData.productDepartment(2));
    }

    /**
     * @author Lila Crum
     */
    @Test
    void productPrice() {
        assertEquals(4.99, productData.productPrice(2));
    }

    /**
     * @author Lila Crum
     */
    @Test
    void checkInitialQuantity() {
        assertEquals(10,productData.checkInitialQuantity(2));
    }

    /**
     * @author Lila Crum
     */
    @Test
    void checkStockLeft() {
        assertEquals(10,productData.checkStockLeft(2));
    }

    /**
     * @author Lila Crum
     */
    @Test
    void checkSoldAmount() {
        assertEquals(0,productData.checkSoldAmount(2));
    }

//I was a bit afraid that testing these last three would screw something up    
    /**
     * @author Lila Crum
     */
   /* @Test
    void addProduct(String cols[]) {
        addProduct(cols);
        assertEquals(11, productData.numberOfProducts(1));

    }*/

    /**
     * @author Lila Crum
     */
   /* @Test
    void delete(int prodId) {
        delete(prodId);
        assertEquals(9, productData.numberOfProducts(1));
    }*/

    @Test
    void list() {
    }
}
