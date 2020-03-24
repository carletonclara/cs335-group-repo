public class Inventory {

    private InventoryDao productData = new InventoryDao("hassana", "1810531");
    private String productName;
    private String productDepartment;
   // private void addStock;
    private double productPrice;
    private int initialQuantity;
    private int soldUnits;
    private int stockQuantity;
    private int numberOfProducts;


    Inventory(int prodId){
        productName = productData.productName(prodId);
        productDepartment = productData.productDepartment(prodId);
        productPrice = productData.productPrice(prodId);
        initialQuantity = productData.checkInitialQuantity(prodId);
        soldUnits = productData.checkSoldAmount(prodId);
        stockQuantity = productData.checkStockLeft(prodId);
        numberOfProducts = productData.numberOfProducts(prodId);

    }

    public void addStock(int prodId){ productData.addStock(prodId); ; }

    public String getProductName(){ return productName; }

    public Integer getNumberOfProducts(){ return numberOfProducts; }

    public String getProductDepartment(){ return productDepartment; }

    public Double getProductPrice(){ return productPrice; }

    public Integer getInitialQuantity(){ return initialQuantity;}

    public Integer getSoldUnits() { return soldUnits;}

    public Integer getStockQuantity(){ return stockQuantity; }

}
