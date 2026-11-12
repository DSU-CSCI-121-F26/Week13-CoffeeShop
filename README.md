# Week 13 Project: Hornet Coffee ☕

**CSCI 121 · one week · about 9 to 10 hours of work**

This week you build one whole program, start to finish: a coffee shop game. You get a
`coffeeshop` package with an empty file for each class and a `main` that already runs. You fill
in every class yourself, one step at a time, until the game works.

Everything is in **your fork of this repo**. There are two parts:

| # | What | Where it lives |
|---|---|---|
| 1 | **The Coffee Shop.** 7 classes, built in 7 steps. | `src/main/java/coffeeshop/` |
| 2 | **The Challenges.** 14 short logic problems, like the Challenge sections in the Follow-Along. | `src/main/java/challenges/` |

## 📅 Dates

| When | What |
|---|---|
| **Mon Nov 16, in class** | Part 1: fork this repo, run the game, make your first commit. Then start Step 1 together. |
| **Wed Nov 18, 11:59 PM** | Checkpoint 1: Steps 1–3 pushed (MenuItem, Drink, Food, Menu). |
| **Fri Nov 20, 11:59 PM** | Checkpoint 2: Steps 4–5 pushed (Order, CoffeeShop). |
| **Mon Nov 23, 2:00 PM (before class)** | **Everything is due:** Steps 6–7 and all the Challenges. At 2:00 PM I grade what is on GitHub. Work pushed later does not count. |

Tue–Sun this week is on your own. Message me on Canvas any time you are stuck.

## ⏱️ How long it takes

| Piece | Time |
|---|---|
| Part 1: fork, set up, first commit (Monday, in class) | 1 hour |
| Refresh videos (watch the ones you need) | 1 to 2 hours |
| Part 2, Steps 1–3: the item classes and the menu | 1.5 hours |
| Part 2, Steps 4–5: orders and the shop | 1.5 hours |
| Part 2, Step 6: the game loop | 1.5 hours |
| Part 2, Step 7: README and comments | 30 minutes |
| Part 3: the 14 Challenges | 2 hours |
| **Total** | **about 9 to 10 hours** |

Do not try to do it all on Sunday night. Two hours a day, five days, is the plan.

---

## 🎮 What you will build

A coffee shop game that runs in IntelliJ's Run window. It shows a menu screen. You type a
number. It does that thing. Then it shows the menu screen **again**. It keeps going until you
pick `0`. That repeating screen is called a **game loop**.

```
      ( (
       ) )
    ........
    |      |]
    \      /
     `----'
  HORNET COFFEE

=====================================
   HORNET COFFEE  -  Order #1  (0 items)
=====================================
 1. See the menu
 2. Add an item
 3. Remove an item
 4. View my order
 5. Use a coupon
 6. Check out
 7. Today's sales
 0. Close the shop
-------------------------------------
Pick a number: 2
1. Coffee (S) - $2.00
2. Latte (S) - $3.25
3. Cappuccino (S) - $3.25
4. Hot Chocolate (S) - $2.50
5. Iced Tea (S) - $2.25
6. Bagel - $2.75
7. Blueberry Muffin - $2.50
8. Breakfast Sandwich - $4.50
Item number: 2
Size (S, M, L): M
Added. Your order has 1 items.

=====================================
   HORNET COFFEE  -  Order #1  (1 items)
=====================================
 ...the menu screen again...
```

**The plan for every class is in [UML.md](UML.md).** UML is a standard way to draw classes as
boxes. Open UML.md now and look at the picture. You will build those 7 boxes, one step at a
time. Each box already has its own empty file in `src/main/java/coffeeshop/`.

---

## 📺 Refresh videos

These are from the same Bro Code video you used for Parts 00–24
([Java Full Course](https://www.youtube.com/watch?v=xk4_1vDrzzo)). Each link jumps to the
right spot. Watch the ones you feel shaky on **before** the step that needs them. You can also
reopen that part's `GUIDE.md` in your Follow-Along fork and read it instead of watching.

| You need it for | Topic | Part | Watch |
|---|---|---|---|
| Step 1 | `final` and your first objects | 15 | [2:57:15 to 3:09:48](https://www.youtube.com/watch?v=xk4_1vDrzzo&t=10635s) |
| Step 1 | Constructors | 16 | [3:10:07 to 3:19:32](https://www.youtube.com/watch?v=xk4_1vDrzzo&t=11407s) |
| Steps 1–2 | Overloaded constructors and `toString` | 17 | [3:25:40 to 3:38:30](https://www.youtube.com/watch?v=xk4_1vDrzzo&t=12340s) |
| Steps 1–2 | `printf` (the same `%.2f` works in `String.format`) | 14 | [2:45:54 to 2:56:50](https://www.youtube.com/watch?v=xk4_1vDrzzo&t=9954s) |
| Step 2 | `static` (for the constants) | 19 | [3:50:00 to 3:57:15](https://www.youtube.com/watch?v=xk4_1vDrzzo&t=13800s) |
| Step 2 | `extends`, `super` and `@Override` | 23, 24 | No video. Read `part23/GUIDE.md` and `part24/GUIDE.md` in your FollowAlong5-Robots fork. |
| Steps 3–5 | `ArrayList` and the for-each loop | 12 | [2:12:02 to 2:27:20](https://www.youtube.com/watch?v=xk4_1vDrzzo&t=7922s) |
| Steps 3–5 | Arrays of objects, passing objects to a method | 18 | [3:38:40 to 3:49:20](https://www.youtube.com/watch?v=xk4_1vDrzzo&t=13121s) |
| Step 4 | Methods that take and give back values | 13 | [2:27:54 to 2:39:30](https://www.youtube.com/watch?v=xk4_1vDrzzo&t=8874s) |
| Step 6 | Reading what the user types (`Scanner`) | 03 | [35:40 to 47:00](https://www.youtube.com/watch?v=xk4_1vDrzzo&t=2140s) |
| Step 6 | `if` and `switch` | 06 | [1:08:48 to 1:20:18](https://www.youtube.com/watch?v=xk4_1vDrzzo&t=4128s) |
| Step 6 | Logical operators and `while` loops (the game loop) | 07 | [1:20:43 to 1:31:54](https://www.youtube.com/watch?v=xk4_1vDrzzo&t=4843s) |
| Challenges B | String methods | 11 | [1:58:15 to 2:03:35](https://www.youtube.com/watch?v=xk4_1vDrzzo&t=7095s) |
| Challenges C | `for` loops and nested loops | 08 | [1:32:37](https://www.youtube.com/watch?v=xk4_1vDrzzo&t=5557s), about 10 minutes |
| Challenges C | Arrays and 2D arrays | 10 | [1:43:42](https://www.youtube.com/watch?v=xk4_1vDrzzo&t=6222s), about 13 minutes |

**Extra, if inheritance still feels new.** These come right after Part 19 in the same video. The
times are close, not exact.
[Inheritance, about 3:58](https://www.youtube.com/watch?v=xk4_1vDrzzo&t=14280s) ·
[Method overriding, about 4:04](https://www.youtube.com/watch?v=xk4_1vDrzzo&t=14640s) ·
[The `super` keyword, about 4:08](https://www.youtube.com/watch?v=xk4_1vDrzzo&t=14880s)

---

## Part 1 · Get set up (Monday, in class)

### 1. Fork this repo

A **fork** is your own copy of the class repo on GitHub. I grade what is in your fork.

1. Go to **[github.com/DSU-CSCI-121-F26/Week13-CoffeeShop](https://github.com/DSU-CSCI-121-F26/Week13-CoffeeShop)**.
   Click **Fork**, then **Create fork**.
2. On your fork, click the **Actions** tab, then **I understand my workflows, go ahead and enable them**.

✅ **Check:** the top of the page says `your-username / Week13-CoffeeShop`.

### 2. Open it in IntelliJ

1. In IntelliJ: **File → New → Project from Version Control**.
2. Paste the link to **your fork** (it has your username in it) → **Clone** → **Trust Project**.
3. Wait until the progress bar at the bottom of IntelliJ is gone.

Do not clone it inside the folder of another project. If your terminal is in an old project
folder, type `cd ..` first.

✅ **Check:** on the left you see `src/main/java`, with two packages inside: `coffeeshop` and
`challenges`.

### 3. Look around

| Folder or file | What is in it |
|---|---|
| `src/main/java/coffeeshop/` | **Your project.** 7 files, one per class. Each one is empty except for a comment that says which step it is and what to build. |
| `src/main/java/challenges/` | **The Challenges.** 4 files of short problems (Part 3). |
| `UML.md` | **The plan.** A picture of all 7 classes, and a table for each one. |
| `check/coffeeshop/` | **The check tests.** One per step. You drag each one in when you start that step. |
| `src/test/java/coffeeshop/` | Where you drag the check tests. Empty for now. |
| `src/test/java/challenges/` | The tests for the Challenges. They are ready to run. |

### 4. Run the game

1. Open `src/main/java/coffeeshop/CoffeeShopApp.java`.
2. Find the line `public static void main(String[] args) {`.
3. Click the green ▶ next to it, then **Run**.

✅ **Check:** the Run window at the bottom says:

```
Hornet Coffee is not open yet.
Build Steps 1 to 5, then write the game loop here in Step 6.
```

That is your game right now. By Step 6, it will be the full coffee shop at the top of this page.

Look at the rest of `CoffeeShopApp.java`. Two methods are marked **GIVEN CODE**: `readNumber`
and `readText`. They read what the user types. You will use them in Step 6. Do not change them.

### 5. Make your first commit

1. Open `CoffeeShopApp.java`. Find the comment block at the top.
2. Add one line at the very top of that comment, with your name, like this: `// Built by: Sam Lee`
3. **Git → Commit**. Check the file. Message: `setup: my name`. Click **Commit and Push**.

✅ **Check:** open your fork on GitHub, click the commit count, and see `setup: my name`.

> **Commit and push in IntelliJ, every time:** **Git → Commit**, check your files, type the
> message, then click **Commit and Push**. Then open your fork on GitHub and check that the commit
> is there. If it is only on your laptop, I can not see it.

---

## Part 2 · Build the coffee shop

Every step works the same way:

1. **Open** that step's file in `src/main/java/coffeeshop/`. The comment at the top says what to build.
2. **Read** that class in [UML.md](UML.md). It tells you every field and method, and what each one does.
3. **Write** the class, where it says `// YOUR CODE`.
4. **Drag** that step's test from `check/coffeeshop/` into `src/test/java/coffeeshop/`. (In
   IntelliJ, drag the file in the project panel on the left, then click **Refactor** or **OK**.)
5. **Run** the test (the green ▶ next to the class name). Fix things until it is all green.
6. **Commit and push** with the exact message given.

> ⚠️ **Drag a test in only when you start its step.** A test that looks for a method you have
> not written yet turns the whole test folder red. Then no test can run, not even the Challenges.
> If that happens, drag the test back into `check/coffeeshop/` for now.

### Rules for every class

- Every field is `private`.
- Every method has a `//` comment right above it, in **your own words**, saying what it does.
  "returns the price" is fine. Copying the UML table is not.
- Use the **exact** names from UML.md. Capital letters count: `getPrice` is not `getprice`.

### Step 1 · `MenuItem`

Fields, a constructor, two getters, `isDrink()`, and `toString()`.

`toString()` must show the price with 2 decimals. This does it:

```java
return name + " - $" + String.format("%.2f", getPrice());
```

Use `getPrice()` there, **not** `price`. In Step 2 you will see why: a Drink changes
`getPrice()`, and this line then uses the Drink's price.

- **Test:** `MenuItemTest`
- **Commit:** `step 1: MenuItem`

### Step 2 · `Drink` and `Food`

First change each class line to `public class Drink extends MenuItem {` and
`public class Food extends MenuItem {`. Both constructors start with `super(name, price);`.
Both **override** `getPrice()`. Put `@Override` on the line above each method you override.

Inside an override, `super.getPrice()` gives you `MenuItem`'s price, before the upcharge.

Turning a size like `'m'` into `'M'`:

```java
char upper = Character.toUpperCase(size);
```

- **Test:** `DrinkTest` and `FoodTest`
- **Commit:** `step 2: Drink and Food`

### Step 3 · `Menu`

An `ArrayList<MenuItem>` that holds 8 items. Look at the table in UML.md.

One list can hold **both** Drinks and Food, because a Drink **is a** MenuItem and so is Food:

```java
items.add(new Drink("Coffee", 2.00, 'S'));
items.add(new Food("Bagel", 2.75, false));
```

`getItem(int number)` counts from 1, but an `ArrayList` counts from 0. So item 1 is
`items.get(0)`.

- **Test:** `MenuTest`
- **Commit:** `step 3: Menu`
- 📌 **Checkpoint 1: Steps 1–3 pushed by Wed Nov 18, 11:59 PM.**

### Step 4 · `Order`

The biggest class. Do it one method at a time, and run `OrderTest` after each one. More of it
turns green each time.

`nextOrderNumber` is **static**: there is one copy shared by all Orders. That is how every new
Order gets the next number:

```java
private static int nextOrderNumber = 1;

public Order() {
    orderNumber = nextOrderNumber;
    nextOrderNumber++;
    // ...make the empty list, set discountPercent to 0
}
```

Check the tip math against the example in UML.md: `7.00 − 0.70 = 6.30`, then `6.30 + 1.26 = 7.56`.

- **Test:** `OrderTest`
- **Commit:** `step 4: Order`

### Step 5 · `CoffeeShop`

The shop keeps a `Menu` and a list of finished Orders. `checkout` finds the total, saves the
order, and adds to the day's sales.

- **Test:** `CoffeeShopTest`
- **Commit:** `step 5: CoffeeShop`
- 📌 **Checkpoint 2: Steps 4–5 pushed by Fri Nov 20, 11:59 PM.**

### Step 6 · `CoffeeShopApp`: the game loop

This is the program you play. Here is the game loop idea in plain words:

```
print the banner once
running = true
while running:
    print the main menu
    read a number
    switch on the number:
        1 -> show the menu
        2 -> add an item
        3 -> remove an item
        4 -> view my order
        5 -> use a coupon
        6 -> check out
        7 -> today's sales
        0 -> running = false
        anything else -> "That is not on the list. Pick 0 to 7."
print "Shop closed. Goodbye!"
```

**The program must never end by itself.** Only `0` ends it. Wrong numbers and letters must
**not** end it or crash it.

**Already done for you** in `CoffeeShopApp.java`: `main`, the `input` field, the
constructor's first line, and the two **GIVEN CODE** methods, `readNumber` and `readText`.
Use them for **all** input. `readNumber` keeps asking until the user types a whole number, so
letters can not crash your game.

**What you add:**

1. The fields `shop` and `order`, and two lines in the constructor that make them:
   `new CoffeeShop("Hornet Coffee")` and `new Order()`.
2. `run()`: replace the two "not open yet" lines with the game loop above.
3. `printBanner()`, `printMainMenu()`, and one `private` method for each choice:
   `addItem()`, `removeItem()`, `viewOrder()`, `useCoupon()`, `checkout()`.

`main` stays the way it is. All the work happens in `run()`.

**What each choice does.** The test checks the sentences in **bold**, so type them exactly.

| Pick | What happens |
|---|---|
| (start) | Print the coffee cup art and **`HORNET COFFEE`**. Copy the art from the top of this README. One trap: inside a Java String, a backslash `\` must be typed twice, `\\`. So the line `    \      /` becomes `System.out.println("    \\      /");` |
| (every time) | The main menu, as shown at the top of this README, with **`0. Close the shop`** as the last choice. Show the order number and how many items are in it. |
| `1` | Print the menu (`shop.getMenu()`). |
| `2` | Print the menu. Ask `Item number: `. If `getItem` gives back `null`, say so. If the item `isDrink()`, ask `Size (S, M, L): ` and add a **new** `Drink` with that size. If not, ask `Heat it up? (y/n): ` and add a **new** `Food`. |
| `3` | If the order is empty, print **`Your order is empty.`** Otherwise print the order, ask which number to remove, and remove it. |
| `4` | If the order is empty, print **`Your order is empty.`** Otherwise print the order. |
| `5` | Ask `Coupon code: `. Say whether it worked. |
| `6` | If the order is empty, print **`Your order is empty.`** Otherwise print the order, ask `Tip percent (0, 10, 15, 20): `, check out, and print **`Total: $7.56`** (with the real total, 2 decimals). Then start a **new** `Order`. |
| `7` | Print `shop.salesReport()`. |
| `0` | End the loop. Print **`Shop closed. Goodbye!`** |
| anything else | Print **`That is not on the list. Pick 0 to 7.`** and show the menu again. |

**Why a new Drink in choice 2?** The menu's Latte is size S. If you change it, the menu changes
too. So you make a fresh one: `new Drink(picked.getName(), picked.getPrice(), sizeLetter)`.
The size letter is the first letter the user typed: `answer.charAt(0)`. If they typed nothing,
use `'S'`.

- **Test:** `CoffeeShopAppTest`. It plays your game by typing keys for you. If it says the test
  **timed out**, your loop never stopped. Check what `0` does.
- **Also play it yourself.** Click the green ▶ next to `main`. Order something, use the coupon
  `HORNET10`, check out, look at today's sales, then quit.
- **Commit:** `step 6: game loop`

### Step 7 · Finish like a pro

1. **About your shop.** Right-click the top `Week13-CoffeeShop` folder → **New → File** →
   `MY-SHOP.md`. Write:
   - one sentence on what the program is,
   - how to run it (which file, which button),
   - the 7 classes, with one sentence each on what they do, in your own words,
   - one thing that was hard and how you fixed it.
2. **Comments.** Check that every method in every class has a `//` comment above it.
3. **Run every test one last time.** Right-click `src/test/java` → **Run 'All Tests'**. All green?

- **Commit:** `step 7: MY-SHOP and comments`

✅ **Check:** your fork on GitHub has `MY-SHOP.md`, and the commit list shows `setup`, then
`step 1` to `step 7`.

---

## Part 3 · The Challenges

These are in `src/main/java/challenges/`, in the same fork. They work the same way
as the Challenge section of every Follow-Along part: fill in each method, run its test, get it
green. You do not change the test files.

| Section | File | Problems | Topic |
|---|---|---|---|
| A | `LogicChallenges.java` | `sizeUpcharge`, `isHappyHour`, `freeDrinks`, `coinsForChange` | `if`, `&&`, `||`, `/` and `%` |
| B | `StringChallenges.java` | `orderCode`, `cupName`, `countWord`, `receiptLine` | String methods, building a String in a loop |
| C | `ArrayChallenges.java` | `cheapest`, `countOver`, `busiestDay` | arrays, a 2D array |
| D | `ListChallenges.java` | `removeSoldOut`, `longestName`, `hasRepeat` | `ArrayList`, for-each, nested loops |

Each method has a comment above it that says what to give back, with examples. The test is
`src/test/java/challenges/<the same name>Test.java`.

> ⚠️ **A few tests are green before you write anything.** For example, a method that should
> give back `0` for an empty array already gives back `0`. That does not mean you are done.
> Work until the **whole** test class is green.

Commit after each section, with these exact messages:

| Section | Commit message |
|---|---|
| A | `challenge A: logic` |
| B | `challenge B: strings` |
| C | `challenge C: arrays` |
| D | `challenge D: lists` |

---

## ✅ Hand it in

Before **Mon Nov 23, 2:00 PM**, when class starts:

- [ ] Your fork has the `setup` commit and `step 1` to `step 7`.
- [ ] All 7 check tests are in `src/test/java/coffeeshop/`, and they are all green.
- [ ] The game runs, and only `0` ends it.
- [ ] `MY-SHOP.md` is in your fork.
- [ ] The 4 challenge commits are there, and the Challenge tests are green.
- [ ] You opened your fork on GitHub and saw your latest commits there.

If it is only on your laptop, I can not see it.

## 🧮 How it is graded (100 points)

| Part | Points | How I check it |
|---|---|---|
| Setup and step commits: `setup`, then `step 1` to `step 7` | 10 | Your fork's commit list |
| Steps 1–5: the classes | 35 | The check tests, run on your code |
| Step 6: the game loop | 15 | `CoffeeShopAppTest`, and I play your game |
| Step 7: `MY-SHOP.md` and comments | 10 | I read them |
| Challenges A–D | 30 | 7.5 points per section, by how many of its tests pass |

**One commit with everything in it** at the end tells me you did not build it step by step.
Commit after every step, like the plan says.

## 🆘 Stuck?

- **Red word in your code?** Hover over it. IntelliJ tells you what is wrong. **Alt+Enter**
  (Option+Enter on a Mac) often fixes a missing `import`.
- **A test is red?** Click it. At the bottom, IntelliJ shows **Expected** and **Actual**. The
  difference is your bug. Look for a missing space, a missing `$`, or the wrong number of decimals.
- **Can't find a method name?** Check UML.md. The name must match exactly.
- **Still stuck?** Message me on Canvas. Tell me the step, paste the red error, and say what you
  already tried.
