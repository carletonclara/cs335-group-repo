import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class TestInventoryDaoTest {

    /**
     * @author Lila Crum
     */
    
    private TestInventoryDao productData;
    
    TestInventoryDaoTest(){
        //Need to add the contents of the Inventory to this ArrayList
        ArrayList<Inventory> productList = new ArrayList<Inventory>();
        productData = new TestInventoryDao(productList);
    }

    /**
     * @author Lila Crum
     */
    @Test
    void numberOfProducts() { assertEquals(10,productData.numberOfProducts(2)); }

    /**
     * @author Lila Crum
     */
    @Test
    void addStock() {
        int currentStock = productData.checkStockLeft(2) + 3;
        productData.addStock(2);
        assertEquals(currentStock, productData.checkStockLeft(2));
    }

    /**
     * @author Lila Crum
     */
    @Test
    void productName() { assertEquals("Toothbrush", productData.productName(2)); }

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
        /**Expecting the stock minus one to be divisible by 3*/
        int stockMinOne = (productData.checkStockLeft(2)-1)%3;
        assertEquals(0,stockMinOne);
    }
    
    /**
     * @author Lila Crum
     */
    @Test
    void checkSoldAmount() { assertEquals(8,productData.checkSoldAmount(2)); }

    /**
     * @author Lila Crum
     */
    @Test
    void list() {
        //I'm uncertain about how to test print statements, so this is a placeholder
        productData.list();
    }
}
