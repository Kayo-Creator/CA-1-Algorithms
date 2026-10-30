/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodstorageapp;

import java.time.LocalDate;

/**
 *
 * @author kayon
 */
public class FoodStackTest {

    public static void main(String[] args) {

        //Create an empty stack and a valid best-before date.
        FoodStack stack = new FoodStack();
        LocalDate date = LocalDate.now().plusDays(7);

        //Test 1: add one item and check the entry time.
        FoodItem first = new FoodItem("Burger", 250.5, date);
        boolean timeWasEmpty = first.getTimeAdded() == null;

        stack.add(first);

        System.out.println("1. Item added and time recorded: "
                + (stack.size() == 1
                && timeWasEmpty
                && first.getTimeAdded() != null));

        //Test 2: add seven more items to fill all eight spaces.
        for (int i = 1; i < 8; i++) {
            stack.add(new FoodItem("Pizza", 200, date));
        }

        System.out.println("2. Eight items accepted: "
                + (stack.size() == 8 && stack.isFull()));

        //Test 3: try adding the item number 9.
        FoodItem ninth = new FoodItem("Fries", 150, date);
        boolean ninthRejected = false;

        try {
            stack.add(ninth);

        } catch (IllegalStateException e) {

            //The full-storage error is expected.
            ninthRejected = true;
        }

        //Check that the count stayed at eight.
        //The rejected item should still have no entry time.
        System.out.println("3. Ninth item rejected: "
                + (ninthRejected
                && stack.size() == 8
                && stack.isFull()
                && ninth.getTimeAdded() == null));

        //Create a fresh stack for these checks.
        FoodStack testStack = new FoodStack();
        LocalDate testDate = LocalDate.now().plusDays(7);

        FoodItem burger = new FoodItem("Burger", 250, testDate);
        FoodItem pizza = new FoodItem("Pizza", 400, testDate);

        testStack.add(burger);
        testStack.add(pizza);

//Test 4: Peek returns Pizza and keeps both items stored.
        System.out.println("4. Peek keeps the item: "
                + (testStack.peek() == pizza && testStack.size() == 2));

//Test 5: Get the items in removal order.
        FoodItem[] listedItems = testStack.getItems();

        boolean correctOrder = listedItems.length == 2
                && listedItems[0] == pizza
                && listedItems[1] == burger;

//Change the returned array to check that it is a separate copy.
        if (listedItems.length > 0) {
            listedItems[0] = null;
        }

//The actual stack should still contain Pizza and Burger.
        FoodItem[] freshCopy = testStack.getItems();

        boolean separateCopy = freshCopy.length == 2
                && freshCopy[0] == pizza
                && freshCopy[1] == burger
                && testStack.size() == 2;

        System.out.println("5. Item order and separate copy: "
                + (correctOrder && separateCopy));

//Test 6: Remove Pizza first, then Burger.
        FoodItem firstRemoved = testStack.remove();
        FoodItem secondRemoved = testStack.remove();

        System.out.println("6. Correct removal order and empty stack: "
                + (firstRemoved == pizza
                && secondRemoved == burger
                && testStack.isEmpty()
                && testStack.size() == 0));

//Test 7: Removing from an empty stack should report an error.
        boolean removeBlocked = false;

        try {
            testStack.remove();
        } catch (IllegalStateException e) {
            removeBlocked = true;
        }

//Reading the top of an empty stack should also report an error.
        boolean peekBlocked = false;

        try {
            testStack.peek();
        } catch (IllegalStateException e) {
            peekBlocked = true;
        }

//Both errors should leave the stack empty.
        System.out.println("7. Empty operations not accepted: "
                + (removeBlocked && peekBlocked
                && testStack.size() == 0
                && testStack.getItems().length == 0));

 // Test 8: Test the shared Display and Search methods.
        // Use FoodStorage so the common methods can be tested.

        FoodStorage commonStack = new FoodStack();

        // Create a valid date within the next 14 days.
        LocalDate displayDate = LocalDate.now().plusDays(7);

        // Add three food items to the Stack.
        commonStack.add(new FoodItem("Burger", 250.0, displayDate));
        commonStack.add(new FoodItem("Pizza", 120.0, displayDate));
        commonStack.add(new FoodItem("Fries", 90.0, displayDate));

 // Test 8: Display all food items.
        // Check the Output window to verify the food details.
        System.out.println("\n8. Shared Display Test:");
        commonStack.display();

        // Test 9: Search should ignore uppercase and lowercase letters.
        FoodItem[] searchResults = commonStack.search("pIzZa");

        System.out.println(
                "9. Case-insensitive search: "
                + (searchResults.length == 1
                && searchResults[0].getName().equals("Pizza"))
        );
        
 // Test 10: A blank search should return no results.
        System.out.println(
                "10. Blank search rejected: "
                + (commonStack.search(" ").length == 0)
        );

 // Test 11: An unknown food name should return no results.
        System.out.println(
                "11. Unknown food search: "
                + (commonStack.search("Chicken").length == 0)
        );
  }
}