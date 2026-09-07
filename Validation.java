import java.util.ArrayList;
import java.util.Scanner;

public class Validation {

    //checks the strings

    public static String validateString(Scanner scanner, String message) {

        String input = "";
        boolean valid = false;

        while (!valid) {

            System.out.print(message);

            input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty!");
            } else {
                valid = true;
            }
        }

        return input;
    }


    //checks the ID

    public static String validateID(
            Scanner scanner,
            String message,
            ArrayList<Item> inventory,
            boolean checkDuplicate) {

        String id = "";
        boolean valid = false;

        while (!valid) {

            valid = true;

            System.out.print(message);

            id = scanner.nextLine().trim();

            if (id.isEmpty()) {

                System.out.println("ID cannot be empty!");
                valid = false;
            }

            else if (!id.matches("[A-Za-z0-9]{6}")) {

                System.out.println(
                        "ID must be exactly 6 letters or numbers!"
                );

                valid = false;
            }

            //checks for duplicate ID

            if (valid && checkDuplicate) {

                boolean duplicate = false;

                for (Item item : inventory) {

                    if (item.getId().equalsIgnoreCase(id)) {
                        duplicate = true;
                        break;
                    }
                }

                if (duplicate) {

                    System.out.println("ID already exists!");
                    valid = false;
                }
            }
        }

        return id;
    }


    //checks the quantity

    public static long validateQuantity(
            Scanner scanner,
            String message,
            boolean allowZero) {

        long quantity = -1;
        boolean valid = false;

        while (!valid) {

            valid = true;

            System.out.print(message);

            String input = scanner.nextLine();

            //checks for whole numbers and leading zeros

            if (!input.matches("0|[1-9][0-9]*")) {

                System.out.println(
                        "Invalid input! Please enter a whole number without leading zeros."
                );

                valid = false;

            } else {

                try {

                    quantity = Long.parseLong(input);

                    if (!allowZero && quantity == 0) {

                        System.out.println(
                                "Quantity must be greater than 0!"
                        );

                        valid = false;
                    }

                } catch (NumberFormatException e) {

                    System.out.println(
                            "Quantity is too large!"
                    );

                    valid = false;
                }
            }
        }

        return quantity;
    }


    //checks the price

    public static double validatePrice(
            Scanner scanner,
            String message) {

        double price = 0;
        boolean valid = false;

        while (!valid) {

            valid = true;

            System.out.print(message);

            String input = scanner.nextLine().trim();

            try {

                price = Double.parseDouble(input);

                if (price <= 0) {

                    System.out.println(
                            "Price must be greater than 0!"
                    );

                    valid = false;
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Please enter a valid number."
                );

                valid = false;
            }
        }

        return price;
    }


    //checks the category

    public static String validateCategory(
            Scanner scanner,
            String message) {

        System.out.print(message);

        String category = scanner.nextLine().trim();

        if (category.equalsIgnoreCase("Clothing")) {

            return "Clothing";

        } else if (category.equalsIgnoreCase("Electronics")) {

            return "Electronics";

        } else if (category.equalsIgnoreCase("Entertainment")) {

            return "Entertainment";

        } else {

            System.out.println(
                    "Category " + category + " does not exist!"
            );

            return null;
        }
    }


    //checks the main menu choice

    public static int validateMenuChoice(Scanner scanner) {

        int choice = 0;
        boolean valid = false;

        while (!valid) {

            String input = scanner.nextLine();

            if (input.matches("[1-9]")) {

                choice = Integer.parseInt(input);
                valid = true;

            } else {

                System.out.println(
                        "Invalid choice! Please enter a number from 1 to 9."
                );
            }
        }

        return choice;
    }


    //checks the update choice

    public static int validateUpdateChoice(Scanner scanner) {

        int choice = 0;
        boolean valid = false;

        while (!valid) {

            String input = scanner.nextLine();

            if (input.matches("[12]")) {

                choice = Integer.parseInt(input);
                valid = true;

            } else {

                System.out.println(
                        "Invalid choice! Please enter 1 or 2."
                );
            }
        }

        return choice;
    }


    //checks the sort field

    public static int validateSortField(Scanner scanner) {

        int choice = 0;
        boolean valid = false;

        while (!valid) {

            System.out.print(
                    "Sort by (1 - Quantity, 2 - Price): "
            );

            String input = scanner.nextLine();

            if (input.equals("1") || input.equals("2")) {

                choice = Integer.parseInt(input);
                valid = true;

            } else {

                System.out.println(
                        "Invalid choice! Enter 1 or 2."
                );
            }
        }

        return choice;
    }


    //checks the sort order

    public static int validateSortOrder(Scanner scanner) {

        int choice = 0;
        boolean valid = false;

        while (!valid) {

            System.out.print(
                    "Order (1 - Ascending, 2 - Descending): "
            );

            String input = scanner.nextLine();

            if (input.equals("1") || input.equals("2")) {

                choice = Integer.parseInt(input);
                valid = true;

            } else {

                System.out.println(
                        "Invalid choice! Enter 1 or 2."
                );
            }
        }

        return choice;
    }
}