package coffeeshop;

import java.util.ArrayList;

// STEP 4 · Order: one customer's order.
//
// Open UML.md and find "Step 4 · Order". This is the biggest class. Build it one method at a
// time, and run the test after each one.
//   2 constants:      COUPON_CODE, COUPON_PERCENT   (public static final)
//   1 static field:   nextOrderNumber, starts at 1
//   3 private fields: orderNumber, items, discountPercent
//   1 constructor:    Order()
//   10 methods:       getOrderNumber(), addItem(), removeItem(), getItemCount(), isEmpty(),
//                     getSubtotal(), applyCoupon(), getDiscount(), getTotal(), toString()
//
// Then drag check/coffeeshop/OrderTest.java into src/test/java/coffeeshop/ and run it.
// Commit message:  step 4: Order

public class Order {

    public static final String COUPON_CODE = "HORNET10";
    public static final int COUPON_PERCENT = 10;
    private static int nextOrderNumber = 1;
    private int orderNumber;
    private ArrayList<MenuItem> items;
    private int discountPercent;

    public Order() {
        this.orderNumber = nextOrderNumber;
        nextOrderNumber++;

        this.items = new ArrayList<MenuItem>();
        this.discountPercent = 0;
    }
    // Returns the order number.
    public int getOrderNumber() {
        return this.orderNumber;
    }
    // Adds a menu item to the order.
    public void addItem(MenuItem item) {
        items.add(item);
    }
    // Removes an item using its position in the order.
    public boolean removeItem(int number) {
        if (number < 1 || number > items.size()) {
            return false;
        }
        items.remove(number - 1);
        return true;
    }
    // Returns the number of items in the order.
    public int getItemCount() {
        return items.size();
    }
    // Checks whether the order has any items.
    public boolean isEmpty() {
        return items.isEmpty();
    }
    // Calculates and returns the subtotal before discounts.
    public double getSubtotal() {
        double subtotal = 0.0;

        for (MenuItem item : items) {
            subtotal += item.getPrice();
        }

        return subtotal;
    }

}
