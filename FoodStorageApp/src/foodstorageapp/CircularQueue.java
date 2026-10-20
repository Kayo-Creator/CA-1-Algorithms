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