package coffeeshop;

import java.util.ArrayList;

// STEP 5 · CoffeeShop: the shop, its menu, and every order it finished today.
//
// Open UML.md and find "Step 5 · CoffeeShop".
//   4 private fields: name, menu, completedOrders, totalSales
//   1 constructor:    CoffeeShop(String name)
//   7 methods:        getName(), getMenu(), checkout(), getOrdersCompleted(),
//                     getTotalSales(), getItemsSold(), salesReport()
//
// Then drag check/coffeeshop/CoffeeShopTest.java into src/test/java/coffeeshop/ and run it.
// Commit message:  step 5: CoffeeShop

public class CoffeeShop {
    private String name;
    private Menu menu;
    private ArrayList<Order> completedOrders;
    private double totalSales;

    public CoffeeShop(String name) {
        this.name = name;
        this.menu = new Menu();
        this.completedOrders = new ArrayList<Order>();
        this.totalSales = 0.0;
    }
        // Returns the name of the coffee shop.
        public String getName() {
            return this.name;
        }
        // Returns the coffee shop's menu.
        public Menu getMenu() {
            return this.menu;
        }

    // Calculates the order total, saves the order, and updates total sales.
    public double checkout(Order order, int tipPercent) {
        if (order.isEmpty()) {
            return 0.0;
        }
        double total = order.getTotal(tipPercent);

        completedOrders.add(order);
        totalSales += total;

        return total;
    }
    // Returns the number of completed orders.
    public int getOrdersCompleted() {
        return completedOrders.size();
    }
    // Returns the total sales from all completed orders.
    public double getTotalSales() {
        return this.totalSales;
    }
    // Returns the total number of items sold across all completed orders.
    public int getItemsSold() {
        int itemsSold = 0;
        for (Order order : completedOrders) {
            itemsSold += order.getItemCount();
        }

        return itemsSold;
    }
    // Returns a sales report containing the shop name, orders, items sold, and total sales.
    public String salesReport() {
        return this.name
                + "\nOrders: " + getOrdersCompleted()
                + "\nItems sold: " + getItemsSold()
                + "\nTotal: $" + String.format("%.2f", getTotalSales());
    }

}
