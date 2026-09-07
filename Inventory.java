import java.util.ArrayList;
import java.util.Comparator;

public class Inventory {

    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    // Adds the items

    public void addItem(Item item) {

        items.add(item);

        System.out.println(
                "Item added successfully!"
        );
    }

    // Finds the items

    public Item findItem(String id) {

        for (Item item : items) {

            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }

        return null;
    }

    // Updates the items

    public void updateItem(
            String id,
            int choice,
            long newQuantity,
            double newPrice) {

        Item item = findItem(id);

        if (item == null) {

            System.out.println("Item not found!");
            return;
        }

        if (choice == 1) {

            long oldQuantity = item.getQuantity();

            item.setQuantity(newQuantity);

            System.out.println(
                    "Quantity of Item "
                    + item.getName()
                    + " is updated from "
                    + oldQuantity
                    + " to "
                    + newQuantity
            );

        } else {

            double oldPrice = item.getPrice();

            item.setPrice(newPrice);

            System.out.println(
                    "Price of Item "
                    + item.getName()
                    + " is updated from "
                    + oldPrice
                    + " to "
                    + newPrice
            );
        }
    }

    // Removes the items

    public void removeItem(String id) {

        Item item = findItem(id);

        if (item == null) {

            System.out.println("Item not found!");
            return;
        }

        items.remove(item);

        System.out.println(
                "Item "
                + item.getName()
                + " has been removed from the inventory"
        );
    }

    // Displays the items by category

    public void displayByCategory(String category) {

        boolean found = false;

        for (Item item : items) {

            if (item.getCategory().equalsIgnoreCase(category)) {

                if (!found) {

                    printCategoryHeader();

                    found = true;
                }

                printCategoryItem(item);
            }
        }

        if (!found) {

            System.out.println(
                    "No items found in category "
                    + category
                    + "."
            );
        }
    }

    // Displays all the items

    public void displayAllItems() {

        if (items.isEmpty()) {

            System.out.println(
                    "Inventory is empty!"
            );

            return;
        }

        printAllHeader();

        for (Item item : items) {
            printAllItem(item);
        }
    }

    // Searches for the items

    public void searchItem(String id) {

        Item item = findItem(id);

        if (item == null) {

            System.out.println(
                    "Item not found!"
            );

            return;
        }

        System.out.println("\nItem Details");
        System.out.println("-----------------------------");
        System.out.println("ID       : " + item.getId());
        System.out.println("Name     : " + item.getName());
        System.out.println("Quantity : " + item.getQuantity());

        System.out.printf(
                "Price    : %.2f%n",
                item.getPrice()
        );

        System.out.println(
                "Category : " + item.getCategory()
        );
    }

    // Sorts out the items

    public void sortItems(
            int sortChoice,
            int orderChoice) {

        if (items.isEmpty()) {

            System.out.println(
                    "Inventory is empty!"
            );

            return;
        }

        ArrayList<Item> sortedItems =
                new ArrayList<>(items);

        if (sortChoice == 1) {

            // Quantity

            if (orderChoice == 1) {

                sortedItems.sort(
                        Comparator.comparingLong(
                                Item::getQuantity
                        )
                );

            } else {

                sortedItems.sort(
                        Comparator.comparingLong(
                                Item::getQuantity
                        ).reversed()
                );
            }

        } else {

            // Price

            if (orderChoice == 1) {

                sortedItems.sort(
                        Comparator.comparingDouble(
                                Item::getPrice
                        )
                );

            } else {

                sortedItems.sort(
                        Comparator.comparingDouble(
                                Item::getPrice
                        ).reversed()
                );
            }
        }

        printAllHeader();

        for (Item item : sortedItems) {
            printAllItem(item);
        }
    }

    // Displays the low stock items

    public void displayLowStock() {

        boolean found = false;

        for (Item item : items) {

            if (item.getQuantity() <= 5) {

                if (!found) {

                    printAllHeader();

                    found = true;
                }

                printAllItem(item);
            }
        }

        if (!found) {

            System.out.println(
                    "No low stock items found."
            );
        }
    }

    // Displays the category header

    private void printCategoryHeader() {

        System.out.println(
                "--------------------------------------------------------------------------"
        );

        System.out.printf(
                "%-12s %-25s %-12s %-15s%n",
                "ID",
                "Name",
                "Quantity",
                "Price"
        );

        System.out.println(
                "--------------------------------------------------------------------------"
        );
    }

    // Displays the category item

    private void printCategoryItem(Item item) {

        System.out.printf(
                "%-12s %-25s %-12d %-15.2f%n",
                item.getId(),
                item.getName(),
                item.getQuantity(),
                item.getPrice()
        );
    }

    // Displays the all items header

    private void printAllHeader() {

        System.out.println(
                "------------------------------------------------------------------------------------------------"
        );

        System.out.printf(
                "%-12s %-25s %-12s %-15s %-15s%n",
                "ID",
                "Name",
                "Quantity",
                "Price",
                "Category"
        );

        System.out.println(
                "------------------------------------------------------------------------------------------------"
        );
    }

    // Displays the all item information

    private void printAllItem(Item item) {

        System.out.printf(
                "%-12s %-25s %-12d %-15.2f%n",
                item.getId(),
                item.getName(),
                item.getQuantity(),
                item.getPrice()
        );
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}