package collections.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    List<Product> cartItems = new ArrayList<Product>();
    
    public void addProductToCartByid(int id) {
        Product product = getProductByProductID(id);
        addToCart(product);
    }

    private Product getProductByProductID(int id) {
        Product product = null;
        List<Product> products = new Products().getProducts();
        for (Product prod: products) {
            if (prod.getid() == id) {
                product = prod;
                break;
            }
        }
        return product;
    }

    private void addToCart(Product product) {
        cartItems.add(product);
    }

    public void removeProductByid(int id) {
        Product prod = getProductByProductID(id);
        cartItems.remove(prod);
    }

    void printCartItems() {
        for (Product prod: cartItems) {
            System.out.println(prod.getName());
        }
    }
    
}