import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Inventory inventory = new Inventory();

        int choice = 0;

        while (choice != 9) {

            displayMenu();

            choice = Validation.validateMenuChoice(scanner);

            switch (choice) {

                case 1:
                    addItem(scanner, inventory);
                    break;

                case 2:
                    updateItem(scanner, inventory);
                    break;

                case 3:
                    removeItem(scanner, inventory);
                    break;

                case 4:
                    displayByCategory(scanner, inventory);
                    break;

                case 5:
                    inventory.displayAllItems();
                    break;

                case 6:
                    searchItem(scanner, inventory);
                    break;

                case 7:
                    sortItems(scanner, inventory);
                    break;

                case 8:
                    inventory.displayLowStock();
                    break;

                case 9:
                    System.out.println(
                            "\nThank you for using the Inventory Management System!"
                    );
                    break;
            }

        }

        scanner.close();
    }

    //Main menu display

    public static void displayMenu() {

        System.out.println();
        System.out.println(
                "=============================================="
        );
        System.out.println(
                "       INVENTORY MANAGEMENT SYSTEM"
        );
        System.out.println(
                "=============================================="
        );
        System.out.println("1. Add Item");
        System.out.println("2. Update Item");
        System.out.println("3. Remove Item");
        System.out.println("4. Display Items by Category");
        System.out.println("5. Display All Items");
        System.out.println("6. Search Item");
        System.out.println("7. Sort Items");
        System.out.println("8. Display Low Stock Items");
        System.out.println("9. Exit");
        System.out.println(
                "=============================================="
        );
    }


    // Adds the items

    public static void addItem(
            Scanner scanner,
            Inventory inventory) {

        System.out.println("\n========== ADD ITEM ==========");

        String category =
                Validation.validateCategory(
                        scanner,
                        "Enter Category: "
                );

        if (category == null) {
            return;
        }

        String id =
                Validation.validateID(
                        scanner,
                        "Enter ID: ",
                        getInventoryList(inventory),
                        true
                );

        String name =
                Validation.validateString(
                        scanner,
                        "Enter Name: "
                );

        long quantity =
                Validation.validateQuantity(
                        scanner,
                        "Enter Quantity: ",
                        false
                );

        double price =
                Validation.validatePrice(
                        scanner,
                        "Enter Price: "
                );

        Item item;

        if (category.equals("Clothing")) {

            item = new Clothing(
                    id,
                    name,
                    quantity,
                    price
            );

        } else if (category.equals("Electronics")) {

            item = new Electronics(
                    id,
                    name,
                    quantity,
                    price
            );

        } else {

            item = new Entertainment(
                    id,
                    name,
                    quantity,
                    price
            );
        }

        inventory.addItem(item);
    }


    //Updates the items

    public static void updateItem(
            Scanner scanner,
            Inventory inventory) {

        System.out.println("\n========== UPDATE ITEM ==========");

        String id =
                Validation.validateString(
                        scanner,
                        "Enter ID: "
                );

        Item item = inventory.findItem(id);

        if (item == null) {

            System.out.println(
                    "Item not found!"
            );

            return;
        }

        System.out.println("1. Update Quantity");
        System.out.println("2. Update Price");
        System.out.print("Enter choice: ");

        int choice =
                Validation.validateUpdateChoice(scanner);

        if (choice == 1) {

            long newQuantity =
                    Validation.validateQuantity(
                            scanner,
                            "Enter new Quantity: ",
                            true
                    );

            inventory.updateItem(
                    id,
                    choice,
                    newQuantity,
                    0
            );

        } else {

            double newPrice =
                    Validation.validatePrice(
                            scanner,
                            "Enter new Price: "
                    );

            inventory.updateItem(
                    id,
                    choice,
                    0,
                    newPrice
            );
        }
    }


    //removes the items

    public static void removeItem(
            Scanner scanner,
            Inventory inventory) {

        System.out.println("\n========== REMOVE ITEM ==========");

        String id =
                Validation.validateString(
                        scanner,
                        "Enter ID: "
                );

        inventory.removeItem(id);
    }


    //displays the items by category

    public static void displayByCategory(
            Scanner scanner,
            Inventory inventory) {

        System.out.println(
                "\n========== DISPLAY BY CATEGORY =========="
        );

        String category =
                Validation.validateCategory(
                        scanner,
                        "Enter Category: "
                );

        if (category == null) {
            return;
        }

        inventory.displayByCategory(category);
    }


    //searches for the items

    public static void searchItem(
            Scanner scanner,
            Inventory inventory) {

        System.out.println("\n========== SEARCH ITEM ==========");

        String id =
                Validation.validateString(
                        scanner,
                        "Enter ID: "
                );

        inventory.searchItem(id);
    }


    //sorts out the items

    public static void sortItems(
            Scanner scanner,
            Inventory inventory) {

        System.out.println("\n========== SORT ITEMS ==========");

        int sortChoice =
                Validation.validateSortField(scanner);

        int orderChoice =
                Validation.validateSortOrder(scanner);

        inventory.sortItems(
                sortChoice,
                orderChoice
        );
    }


    //retrieves the inventory list

    public static java.util.ArrayList<Item> getInventoryList(
            Inventory inventory) {

        return inventory.getItems();
    }
}