import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();
        int choice;

        do {
            System.out.println("\n--- INVENTORY MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. Delete Product");
            System.out.println("4. Search Product");
            System.out.println("5. Low Stock Alert");
            System.out.println("6. Display All Products");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    manager.addProduct(new Product(id, name, qty, price));
                    break;
                case 2:
                    System.out.print("Enter Product ID to update: ");
                    int uid = sc.nextInt();
                    System.out.print("Enter New Quantity: ");
                    int newQty = sc.nextInt();
                    manager.updateStock(uid, newQty);
                    break;
                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int did = sc.nextInt();
                    manager.deleteProduct(did);
                    break;
                case 4:
                    sc.nextLine();
                    System.out.print("Enter Product Name to search: ");
                    String sname = sc.nextLine();
                    manager.searchProduct(sname);
                    break;
                case 5:
                    manager.lowStockAlert();
                    break;
                case 6:
                    manager.displayAll();
                    break;
                case 7:
                    System.out.println("Exiting... Data saved to inventory.txt");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);
        sc.close();
    }
}