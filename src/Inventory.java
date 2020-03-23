public class Inventory {

    private InventoryDao productData = new InventoryDao("carletoc", "1683864");
    private String productName;
    private String productDepartment;
    private double productPrice;
    private int initialQuantity;
    private int soldUnits;
    private int stockQuantity;

    Inventory(int prodId){
        productName = productData.productName(prodId);
        productDepartment = productData.productDepartment(prodId);
        productPrice = productData.productPrice(prodId);
        initialQuantity = productData.checkInitialQuantity(prodId);
        soldUnits = productData.checkSoldAmount(prodId);
        stockQuantity = productData.checkStockLeft(prodId);

    }

    public String getProductName(){ return productName; }

    public String getProductDepartment(){ return productDepartment; }

    public Double getProductPrice(){ return productPrice; }

    public Integer getInitialQuantity(){ return initialQuantity;}

    public Integer getSoldUnits() { return soldUnits;}

    public Integer getStockQuantity(){ return stockQuantity; }

}
