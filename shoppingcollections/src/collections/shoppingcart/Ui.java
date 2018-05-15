package collections.shoppingcart;

import java.util.List;
import java.util.Scanner;

public class Ui {

	 Cart cart = new Cart();
	    private int ch = 0;
	    
	    public Ui () {
	        menu();
	    }
	    
	    public void startScreen () {
	        System.out.println("1. Display Store Products");
	        System.out.println("2. Display Cart");
	        System.out.println("3. Exit");
	    }
	    
	    public void storeProductsMenu() {
	    
	        System.out.println("1. Add to Cart");
	        System.out.println("2. Remove From Cart");
	        System.out.println("3. Exit");
	    }
	    
	    public void menu () {
	        do {
	            startScreen();
	            getUserInput();
	            
	            switch (ch) {
	                case 1: 
	                    displayStoreProducts();
	                    storeProductsMenu();
	                    getUserInput();
	                    innerChoice1();
	                    break;
	                case 2:
	                    showCart();
	                    break;
	                case 3:
	                    System.exit(0);
	                    break;
	                default:
	                    
	                    break;
	            }
	        } while (ch != 0);
	    }

	    private void innerChoice1() {
	        switch (ch) {
	            case 1:
	                addProductToCart();
	                showCart();
	                break;
	            case 2:
	                removeProductFromCart();
	                break;
	            default:
	                
	                break;
	        }
	    }

	    private int getUserInput() throws NumberFormatException {
	        @SuppressWarnings("resource")
			Scanner in = new Scanner (System.in);
	        ch = Integer.parseInt(in.nextLine());
	        return ch;
	    }

	    private void displayStoreProducts() {
	        List<Product> products = new Products().getProducts();
	        for (Product prod: products) {
	            System.out.println(
	                    prod.getid() + "- " +
	                            prod.getName() + " " +
	                            prod.getPrice() + " " +
	                            prod.getStock()
	            );
	        }
	    }

	    private void addProductToCart() {
	        int id = getUserInput();
	        cart.addProductToCartByid(id);      
	    }

	    private void showCart() {
	        cart.printCartItems();
	    }

	    private void removeProductFromCart() {
	        int id = getUserInput();
	        cart.removeProductByid(id);
	    }
	
}
