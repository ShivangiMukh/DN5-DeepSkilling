import java.util.HashMap;

class InventoryProduct {
    int productId;
    String productName;
    int quantity;
    double price;

    public InventoryProduct(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{id=" + productId + ", name=" + productName +
                ", qty=" + quantity + ", price=" + price + "}";
    }
}

// HashMap chosen over ArrayList - lookups/updates/deletes by productId
// are O(1) average case instead of O(n) for a linear scan through a list
class Inventory {
    private HashMap<Integer, InventoryProduct> products = new HashMap<>();

    public void addProduct(InventoryProduct product) {
        products.put(product.productId, product); // O(1) average
    }

    public void updateProduct(int productId, int newQuantity, double newPrice) {
        InventoryProduct product = products.get(productId); // O(1) average
        if (product != null) {
            product.quantity = newQuantity;
            product.price = newPrice;
        }
    }

    public void deleteProduct(int productId) {
        products.remove(productId); // O(1) average
    }

    public void displayAll() {
        for (InventoryProduct p : products.values()) {
            System.out.println(p);
        }
    }
}

class Exercise15 {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addProduct(new InventoryProduct(1, "Laptop", 10, 55000.0));
        inventory.addProduct(new InventoryProduct(2, "Mouse", 50, 500.0));

        System.out.println("Initial inventory:");
        inventory.displayAll();

        inventory.updateProduct(2, 40, 450.0);
        System.out.println();
        System.out.println("After updating Mouse:");
        inventory.displayAll();

        inventory.deleteProduct(1);
        System.out.println();
        System.out.println("After deleting Laptop:");
        inventory.displayAll();
    }
}
