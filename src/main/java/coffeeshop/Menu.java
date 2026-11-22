package coffeeshop;

import java.util.ArrayList;

// STEP 3 · Menu: the 8 things the shop sells.
//
// Open UML.md and find "Step 3 · Menu". The table there lists the 8 items, in order.
//   1 private field: items   (an ArrayList<MenuItem>)
//   1 constructor:   Menu(). It makes the list and adds the 8 items.
//   3 methods:       size(), getItem(int number), toString()
//
// Then drag check/coffeeshop/MenuTest.java into src/test/java/coffeeshop/ and run it.
// Commit message:  step 3: Menu

public class Menu {
    private ArrayList<MenuItem> items;
    public Menu() {
        items = new ArrayList<MenuItem>();
        // Add the 8 menu items from UML.md here.
        items.add(new Drink("Coffee", 2.00, 'S'));
        boolean bagel = items.add(new Food("Bagel", 2.75, false));
    }
    // Returns the total number of items in the menu.
    public int size() {
        return items.size();
    }
    // Returns the menu item at the requested position.
    // Subtracts 1 because menu numbering starts at 1.
    public MenuItem getItem(int number) {
        return items.get(number - 1);
    }
    // Returns a String representation of the menu.
    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < items.size(); i++) {
            result += (i + 1) + ". " + items.get(i).toString() + "\n";
        }

        return result;
    }

}
