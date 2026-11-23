package coffeeshop;

import java.util.Scanner;

// STEP 6 · CoffeeShopApp: the game you play. This is the class with main.
//
// It already runs. Click the green arrow next to main and try it.
//
// In Step 6 you finish it. Open UML.md ("Step 6") and the README ("Step 6") for the
// screens and the exact sentences. You add:
//   2 more private fields: shop and order
//   the game loop in run()
//   printBanner(), printMainMenu(), and one method for each menu choice
//
// Then drag check/coffeeshop/CoffeeShopAppTest.java into src/test/java/coffeeshop/ and run it.
// Built by : Kameron Randolph  step 6: game loop

public class CoffeeShopApp {

    private Scanner input;
    private CoffeeShop shop;
    private Order order;


    public CoffeeShopApp(Scanner input) {
        this.input = input;
        this.shop = new CoffeeShop("Hornet Coffee");
        this.order = new Order();
    }

    // The game loop. It keeps going until the user picks 0.
    public void run() {
        printBanner();

        boolean running = true;

        while (running) {
            printMainMenu();

            int choice = readNumber("Choose an option: ");

            switch (choice) {
                case 1:
                    System.out.println(shop.getMenu());
                    break;

                case 2:
                    addItem();
                    break;

                case 3:
                    removeItem();
                    break;

                case 4:
                    viewOrder();
                    break;

                case 5:
                    useCoupon();
                    break;

                case 6:
                    checkout();
                    break;

                case 7:
                    System.out.println(shop.salesReport());
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("That is not on the list. Pick 0 to 7.");
                    break;
            }
        }
        System.out.println("Shop closed. Goodbye!");
    }
        // Prints the coffee shop banner.
        private void printBanner() {
            System.out.println(" ( (");
            System.out.println("       ) )");
            System.out.println("    ........");
            System.out.println("    |      |]");
            System.out.println("    \\      /");
            System.out.println("     `----'");
            System.out.println("  HORNET COFFEE");
        }






    // Prints the main menu, order number, and item count.
    private void printMainMenu() {
        System.out.println();
        System.out.println("=====================================");
        System.out.println("   HORNET COFFEE  -  Order #" + order.getOrderNumber()
                + "  (" + order.getItemCount() + " items)");
        System.out.println("=====================================");
        System.out.println(" 1. See the menu");
        System.out.println(" 2. Add an item");
        System.out.println(" 3. Remove an item");
        System.out.println(" 4. View my order");
        System.out.println(" 5. Use a coupon");
        System.out.println(" 6. Check out");
        System.out.println(" 7. Today's sales");
        System.out.println(" 0. Close the shop");
        System.out.println("-------------------------------------");
    }
    // Displays the menu and adds a new Drink or Food to the order.
    private void addItem() {
        System.out.println(shop.getMenu());
        int number = readNumber("Item number:");

        MenuItem picked = shop.getMenu().getItem(number);

        if (picked == null) {
            System.out.println("That item was not found.");
            return;
        }
        if (picked.isDrink()) {
            String answer = readText("Size (S, M, L):");

            char sizeLetter = 'S';

            if (!answer.isEmpty()) {
                sizeLetter = answer.charAt(0);
            }
            order.addItem(new Drink(
                    picked.getName(),
                    picked.getPrice(),
                    sizeLetter
            ));
        } else {
            String answer = readText("Heat it up? (y/n):");

            boolean heated = answer.equalsIgnoreCase("y");
            order.addItem(new Food(
                    picked.getName(),
                    picked.getPrice(),
                    heated
            ));
        }
    }
    // Removes an item from the current order.
    private void removeItem() {
        if (order.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }
        System.out.println(order);
        int number = readNumber("Item number to remove:");

        if (order.removeItem(number)) {
            System.out.println("Item removed.");
        } else {
            System.out.println("Invalid item number.");
        }
    }
    // Displays the current order.
    private void viewOrder() {
        if (order.isEmpty()) {
            System.out.println("Your order is empty.");
        } else {
            System.out.println(order);
        }
    }
    // Asks for a coupon code and applies it if valid.
    private void useCoupon() {
        String code = readText("Coupon code:");

        if (order.applyCoupon(code)) {
            System.out.println("Coupon applied!");
        } else {
            System.out.println("Invalid coupon code.");
        }
    }
    // Checks out the order and creates a new order afterward.
    private void checkout() {
        if (order.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }
        System.out.println(order);

        int tipPercent = readNumber("Tip percent (0, 10, 15, 20):");

        double total = shop.checkout(order, tipPercent);

        System.out.println("Total: $" + String.format("%.2f", total));

        order = new Order();
    }


    // GIVEN CODE. Do not change it. Use it for every number the user types.
    // It keeps asking until the user types a whole number, so letters can not crash your game.
    private int readNumber(String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.nextLine();                    // throw away what they typed
            System.out.print("Please type a number: ");
        }
        int number = input.nextInt();
        input.nextLine();                        // throw away the Enter key
        return number;
    }

    // GIVEN CODE. Do not change it. Use it for every word the user types.
    // Reads one line of text, with the spaces at the ends cut off.
    private String readText(String prompt) {
        System.out.print(prompt);
        return input.nextLine().trim();
    }

    // Start here. Click the green arrow next to this line to run the game.
    public static void main(String[] args) {
        CoffeeShopApp app = new CoffeeShopApp(new Scanner(System.in));
        app.run();
    }
}
