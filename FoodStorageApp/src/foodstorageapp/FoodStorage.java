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

}
