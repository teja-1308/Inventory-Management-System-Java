import java.io.*;
import java.util.*;

public class InventoryManager {
    ArrayList<Product> products = new ArrayList<>();
    final String FILE_NAME = "inventory.txt";
    final int LOW_STOCK_LIMIT = 5;

    // Load data from file
    public InventoryManager() {
        loadFromFile();
    }

    void addProduct(Product p) {
        products.add(p);
        saveToFile();
        System.out.println("Product Added Successfully!");
    }

    void updateStock(int id, int newQty) {
        for (Product p : products) {
            if (p.id == id) {
                p.quantity = newQty;
                saveToFile();
                System.out.println("Stock Updated!");
                return;
            }
        }
        System.out.println("Product ID not found!");
    }

    void deleteProduct(int id) {
        products.removeIf(p -> p.id == id);
        saveToFile();
        System.out.println("Product Deleted!");
    }

    void searchProduct(String name) {
        boolean found = false;
        for (Product p : products) {
            if (p.name.equalsIgnoreCase(name)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) System.out.println("Product not found!");
    }

    void lowStockAlert() {
        System.out.println("--- LOW STOCK ALERT ---");
        boolean alert = false;
        for (Product p : products) {
            if (p.quantity < LOW_STOCK_LIMIT) {
                System.out.println(p + " <-- LOW STOCK!");
                alert = true;
            }
        }
        if (!alert) System.out.println("All products have sufficient stock.");
    }

    void displayAll() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }
        for (Product p : products) System.out.println(p);
    }

    void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(products);
        } catch (IOException e) {
            System.out.println("Error saving: " + e);
        }
    }

    void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            products = (ArrayList<Product>) ois.readObject();
        } catch (FileNotFoundException e) {
            // First time, file undadu. No problem.
        } catch (Exception e) {
            System.out.println("Error loading: " + e);
        }
    }
}