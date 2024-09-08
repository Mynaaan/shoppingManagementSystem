class Product {
    private String productId;
    private String productName;
    private String manufacturer;
    private String productionDate;
    private String model;
    private double purchasePrice;
    private double retailPrice;
    private int quantity;

    public Product(String productId, String productName, String manufacturer, String productionDate, String model,
                   double purchasePrice, double retailPrice, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.productionDate = productionDate;
        this.model = model;
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "商品编号: " + productId + ", 商品名称: " + productName + ", 生产厂家: " + manufacturer + ", 生产日期: "
                + productionDate + ", 型号: " + model + ", 进货价: " + purchasePrice + ", 零售价格: " + retailPrice
                + ", 数量: " + quantity;
    }
}
