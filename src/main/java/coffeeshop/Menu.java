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
    // YOUR CODE //the item method below gathers the name and price of the item picked
    private ArrayList<MenuItem> items;
        public Menu() {
            items = new ArrayList<MenuItem>();
        }
        public int size() {
            return items.size();
        }
        public MenuItem getItem (int number){
            return items.get(number);
        }

        @Override
        public String toString() {
            return items.toString();
        }

    }

