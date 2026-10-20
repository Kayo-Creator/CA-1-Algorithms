/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodstorageapp;

public class CircularQueue {

    // The storage can hold only 8 food items.
    // We use a fixed value because the maximum capacity is 8.
    private static final int CAPACITY = 8;

    // We use an array to store FoodItem objects.
    // Each object contains the food name, weight and dates.
    private final FoodItem[] items;

    // Front points to the first item in the queue.
    // This item will be removed first.
    private int front;

    // Rear points to the last item added to the queue.
    private int rear;

    // Count stores the number of items in the queue.
    // We use it to check if the queue is empty or full.
    private int count;


    // This constructor creates an empty queue.
    public CircularQueue() {

        // We create an array that can hold 8 food items.
        items = new FoodItem[CAPACITY];

        // Front starts at index 0.
        front = 0;

        // Rear starts at -1 because no item has been added.
        rear = -1;

        // The queue starts with zero items.
        count = 0;
    }
    
    // This method adds a food item to the queue.
    // We return false if the item is null or the queue is full.
    // This stops the queue from storing invalid items or more than 8 items.
    public boolean enqueue(FoodItem item) {

        if (item == null || isFull()) {
            return false;
        }

        // We record the time when the food enters the storage.
        item.markAddedToStorage();

        // We move rear to the next position.
        // The % operator moves rear back to 0 after position 7.
        // This helps us reuse empty spaces in the queue.
        rear = (rear + 1) % CAPACITY;

        // We store the food item at the new rear position.
        items[rear] = item;

        // We increase the number of items by 1.
        count++;

        // We return true because the item was added successfully.
        return true;
    }


    // This method returns the first food item in the queue.
    // We do not remove the item when we use peek().
    // We return null if the queue is empty.
    public FoodItem peek() {

        if (isEmpty()) {
            return null;
        }

        // We return the front item because it will be removed first.
        return items[front];
    }

    // This method checks if the queue has no items.
    // We return true when count is 0.
    public boolean isEmpty() {
        return count == 0;
    }


    // This method checks if the queue has reached its limit.
    // We return true when count is 8.
    public boolean isFull() {
        return count == CAPACITY;
    }


    // This method returns the number of stored food items.
    // We use count because it tracks the current number of items.
    public int size() {
        return count;
    }

}