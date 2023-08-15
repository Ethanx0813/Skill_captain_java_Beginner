import java.util.ArrayList;
 import java.util.Scanner;
 
 public class GroceryListManager {
     private static ArrayList<String> groceryList = new ArrayList<>();
 
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
 
         while (true) {
             System.out.println("Grocery List Manager");
             System.out.println("--------------------");
             System.out.println("1. Add item");
             System.out.println("2. Remove item");
             System.out.println("3. Print grocery list");
             System.out.println("4. Check item existence");
             System.out.println("5. Clear grocery list");
             System.out.println("6. Quit");
 
             System.out.print("Enter your choice (1-6): ");
             int choice = scanner.nextInt();
             scanner.nextLine(); // Consume the newline character
 
             switch (choice) {
                 case 1:
                     addItem(scanner);
                     break;
                 case 2:
                     removeItem(scanner);
                     break;
                 case 3:
                     printGroceryList();
                     break;
                 case 4:
                     checkItemExistence(scanner);
                     break;
                 case 5:
                     clearGroceryList();
                     break;
                 case 6:
                     System.out.println("Thank you for using Grocery List Manager. Goodbye!");
                     scanner.close();
                     System.exit(0);
                 default:
                     System.out.println("Invalid choice. Please enter a number from 1 to 6.");
             }
         }
     }
 
     private static void addItem(Scanner scanner) {
         System.out.print("Enter the item to add: ");
         String item = scanner.nextLine();
         groceryList.add(item);
         System.out.println("Item added successfully.");
         System.out.println();
     }
 
     private static void removeItem(Scanner scanner) {
         System.out.print("Enter the item to remove: ");
         String item = scanner.nextLine();
         boolean removed = groceryList.remove(item);
         if (removed) {
             System.out.println("Item removed successfully.");
         } else {
             System.out.println("Item not found in the grocery list.");
         }
         System.out.println();
     }
 
     private static void printGroceryList() {
         if (groceryList.isEmpty()) {
             System.out.println("The grocery list is empty.");
         } else {
             System.out.println("Grocery List:");
             for (int i = 0; i < groceryList.size(); i++) {
                 System.out.println((i + 1) + ". " + groceryList.get(i));
             }
         }
         System.out.println();
     }
 
     private static void checkItemExistence(Scanner scanner) {
         System.out.print("Enter the item to check: ");
         String item = scanner.nextLine();
         boolean exists = groceryList.contains(item);
         if (exists) {
             System.out.println("The item is already on the grocery list.");
         } else {
             System.out.println("The item is not on the grocery list.");
         }
         System.out.println();
     }
 
     private static void clearGroceryList() {
         groceryList.clear();
         System.out.println("Grocery list cleared.");
         System.out.println();
     }
 }