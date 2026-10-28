/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodstorageapp;

/**
 *
 * @author kayon
 */
//Reuse the array, item count, and checks from the shared class.
public class FoodStack extends AbstractFoodStorage {

    //Add a food item to the top of the stack.
    @Override
    public void add(FoodItem item) {

        //Reject a missing food item.
        if (item == null) {
            throw new IllegalArgumentException(
                    "A food item must be provided."
            );
        }

        //Reject the addition when all eight spaces are occupied.
        if (isFull()) {
            throw new IllegalStateException("Storage is full.");
        }

        //Record the entry time after the checks pass.
        item.markAddedToStorage();

        //Store the item in the next free array position.
        items[count] = item;

        //Increase the number of stored items by one.
        count++;
    }

//Remove and return the most recently added food.
    @Override
    public FoodItem remove() {

        //Stop removal when there are no items.
        if (isEmpty()) {
            throw new IllegalStateException("Storage is empty.");
        }

        //Reduce the count so it points to the top item's position.
        count--;

        //Keep the item so we can return it.
        FoodItem removedItem = items[count];

        //Clear the array position that the item occupied.
        items[count] = null;

        //Return the removed food item.
        return removedItem;
    }

    // Return the stored items in the order they would be removed.
    @Override
    public FoodItem[] getItems() {

        // Create a separate array with space for the stored items.
        FoodItem[] storedItems = new FoodItem[count];

        // Copy items from the top of the stack downwards.
        for (int i = 0; i < count; i++) {
            storedItems[i] = items[count - 1 - i];
        }

        // Return the copy for Display and Search to use.
        return storedItems;
    }
// Read the top food item while keeping it in the stack.

    @Override
    public FoodItem peek() {

        // Stop when there are no items to read.
        if (isEmpty()) {
            throw new IllegalStateException("Storage is empty.");
        }

        // The top item is one position below the current count.
        return items[count - 1];
    }

}
