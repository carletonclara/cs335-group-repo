
/**
 * @author Amran Hassan
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InventoryTest {

    private int prod_id = 5;
    private Inventory product;

    @BeforeEach
    void setUp(){
        product = new Inventory(prod_id);
    }

    @Test
    void testGetProductName(){
        assertEquals("Iron", product.getProductName());
    }

    @Test
    void testGetNumberOfProducts(){ assertEquals(10, product.getNumberOfProducts());}

    @Test
    void testGetProductDepartment(){ assertEquals("Home",product.getProductDepartment());}

    @Test
    void testGetProductPrice() {assertEquals(39.99, product.getProductPrice());}

    @Test
    void testGetStockQuantity() {assertEquals(17, product.getStockQuantity());}

    @Test
    void testGetInitialQuantity() {assertEquals(10, product.getInitialQuantity());}

    @Test
    void testGetSoldQuantity() {assertEquals(3, product.getSoldUnits());}

}