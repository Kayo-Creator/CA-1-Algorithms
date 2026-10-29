/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodstorageapp;

/**
 *
 * @author kayon
 */
//lists the operations that both structures must give
public interface FoodStorage {

    // Add a food item to storage
    void add(FoodItem item);

    //Remove and return the next food item
    FoodItem remove();

    //read the next food item
    FoodItem peek();

    //When storage has no items it returns true
    boolean isEmpty();

    //Whenever it reach its capacity it will return true
    boolean isFull();

    //Return the number of stored food items
    int size();

    //the menu can use this for display and search
    FoodItem[] getItems();

/**
     * Display all food items stored in the structure.
     * The order depends on the implementation of getItems().
     */
    default void display() {

        // Get the stored items without modifying the original storage.
        FoodItem[] currentItems = getItems();

        // Stop when there are no items to display.
        if (currentItems.length == 0) {
            System.out.println("Storage is empty.");
            return;
        }

        System.out.println("Food items in storage:");

        // Display the details of every stored item.
        for (int i = 0; i < currentItems.length; i++) {

            FoodItem item = currentItems[i];

            System.out.println(
                    (i + 1) + ". " + item.getName()
                    + " | Weight: " + item.getWeightInGrams() + " g"
                    + " | Best before: " + item.getBestBeforeDate()
                    + " | Storage time: " + item.getTimeAdded()
            );
        }
    }

    /**
     * Search for food items by name.
     * The search ignores uppercase and lowercase letters.
     */
    default FoodItem[] search(String searchName) {

        // Reject an empty search name.
        if (searchName == null || searchName.trim().isEmpty()) {
            return new FoodItem[0];
        }

        // Get all stored items without changing the storage.
        FoodItem[] currentItems = getItems();

        // Create an array to hold matching items.
        FoodItem[] matches = new FoodItem[currentItems.length];

        int matchCount = 0;

        // Remove unnecessary spaces from the search name.
        String nameToFind = searchName.trim();

        // Check every stored food item.
        for (FoodItem item : currentItems) {

            // Compare food names without checking letter case.
            if (item != null
                    && item.getName() != null
                    && item.getName().equalsIgnoreCase(nameToFind)) {

                matches[matchCount] = item;
                matchCount++;
            }
        }

        // Create an array containing only the matching items.
        FoodItem[] results = new FoodItem[matchCount];

        for (int i = 0; i < matchCount; i++) {
            results[i] = matches[i];
        }

        // Return the search results.
        return results;
    }
}