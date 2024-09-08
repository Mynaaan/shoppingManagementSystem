import java.util.ArrayList;
import java.util.List;

class ShoppingCart {
    private List<ShoppingCartItem> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        ShoppingCartItem item = new ShoppingCartItem(product, quantity);
        items.add(item);
    }

    public void removeItem(Product product) {
        items.removeIf(item -> item.getProduct().equals(product));
    }

    public void modifyItemQuantity(Product product, int quantity) {
        for (ShoppingCartItem item : items) {
            if (item.getProduct().equals(product)) {
                item.setQuantity(quantity);
                if (quantity <= 0) {
                    items.remove(item);
                }
                break;
            }
        }
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }
}
