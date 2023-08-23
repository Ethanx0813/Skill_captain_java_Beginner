package First;

import java.util.List;

class Product {
    private int productId;
    private String productName;
    private double price;
    private int quantity;

    public Product(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class Cart {
    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addToCart(Product product) {
        products.add(product);
    }

    public void removeFromCart(Product product) {
        products.remove(product);
    }

    public void updateQuantity(Product product, int quantity) {
        if (products.contains(product)) {
            product.setQuantity(quantity);
        }
    }

    public void viewCart() {
        System.out.println("Cart Contents:");
        for (Product product : products) {
            System.out.println(product.getProductName() + " - Quantity: " + product.getQuantity());
        }
    }

    public void checkout() {
        double total = 0;
        System.out.println("Checkout:");
        for (Product product : products) {
            System.out.println(product.getProductName() + " - Quantity: " + product.getQuantity() + " - Price: $" + product.getPrice() * product.getQuantity());
            total += product.getPrice() * product.getQuantity();
        }
        System.out.println("Total: $" + total);
    }
}

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1, "Product A", 10.99, 2);
        Product product2 = new Product(2, "Product B", 5.49, 3);

        Cart cart = new Cart();

        cart.addToCart(product1);
        cart.addToCart(product2);

        System.out.println("Initial Cart:");
        cart.viewCart();

        cart.updateQuantity(product1, 4);
        cart.removeFromCart(product2);

        System.out.println("\nUpdated Cart:");
        cart.viewCart();

        cart.checkout();
    }
}

