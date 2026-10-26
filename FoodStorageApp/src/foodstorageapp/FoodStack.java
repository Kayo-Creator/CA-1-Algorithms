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

    //The following are temporary methods
    @Override
    public FoodItem remove() {
        throw new UnsupportedOperationException("Remove is not ready yet.");
    }

    @Override
    public FoodItem peek() {
        throw new UnsupportedOperationException("Peek is not ready yet.");
    }

    @Override
    public FoodItem[] getItems() {
        throw new UnsupportedOperationException("Reading items is not ready yet.");
    }
}
