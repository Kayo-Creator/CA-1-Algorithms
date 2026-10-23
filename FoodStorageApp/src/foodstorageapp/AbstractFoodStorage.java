/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodstorageapp;

/**
 *
 * @author Kayon
 */
// Holds the fields and methods shared by the stack and queue
public abstract class AbstractFoodStorage implements FoodStorage {

    // the maximum number of food items allowed
    protected static final int CAPACITY = 8;
    // create an array with space for eight FoodItem objects

    protected final FoodItem[] items = new FoodItem[CAPACITY];
    // knows how many items are currently stored.

    protected int count = 0;
    // check if storage contains no items

    @Override

    public boolean isEmpty() {

        return count == 0;

    }
    // see if all eight spaces are occupied

    @Override

    public boolean isFull() {

        return count == CAPACITY;
    }
    // return the number of items stored

    @Override

    public int size() {

        return count;
    }
}
