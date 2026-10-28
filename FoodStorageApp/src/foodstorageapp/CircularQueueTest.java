/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodstorageapp;

import java.time.LocalDate;

public class CircularQueueTest {

    // This method creates a food item for testing.
    // We use a date within the next 14 days.
    private static FoodItem createFood(String name, double weight, int days) {
        return new FoodItem(
                name,
                weight,
                LocalDate.now().plusDays(days)
        );
    }

    // This method shows if a test passes or fails.
    private static void check(boolean result, String testName) {
        if (result) {
            System.out.println("PASS: " + testName);
        } else {
            System.out.println("FAIL: " + testName);
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Circular Queue Tests ===");

        // Test 1: Check an empty queue.
        CircularQueue queue = new CircularQueue();

        check(queue.isEmpty(), "New queue is empty");
        check(queue.peek() == null, "Peek on an empty queue");
        check(queue.dequeue() == null, "Remove from an empty queue");


        // Test 2: Add, peek and remove a food item.
        FoodItem burger = createFood("Burger", 250, 7);

        check(queue.enqueue(burger), "Add a valid Burger");
        check(queue.size() == 1, "Size is 1 after adding");
        check(queue.peek() == burger, "Peek returns the first item");
        check(queue.size() == 1, "Peek does not remove the item");
        check(queue.dequeue() == burger, "Remove returns the first item");
        check(queue.isEmpty(), "Queue is empty after removal");


        // Test 3: Fill the queue with 8 food items.
        CircularQueue fullQueue = new CircularQueue();

        String[] names = {
            "Burger", "Pizza", "Fries", "Sandwich",
            "Hotdog", "Burger", "Pizza", "Fries"
        };

        FoodItem[] originalItems = new FoodItem[8];

        for (int i = 0; i < names.length; i++) {
            originalItems[i] = createFood(names[i], 100 + i, 7);

            check(
                    fullQueue.enqueue(originalItems[i]),
                    "Add item " + (i + 1)
            );
        }

        check(fullQueue.isFull(), "Queue is full at 8 items");
        check(fullQueue.size() == 8, "Queue size is 8");


        // Test 4: Reject the ninth food item.
        FoodItem ninthItem = createFood("Sandwich", 200, 7);

        check(
                !fullQueue.enqueue(ninthItem),
                "Reject the ninth item"
        );

        check(fullQueue.size() == 8, "Size stays at 8");


        // Test 5: Remove three items.
        check(
                fullQueue.dequeue() == originalItems[0],
                "Remove the first item"
        );

        check(
                fullQueue.dequeue() == originalItems[1],
                "Remove the second item"
        );

        check(
                fullQueue.dequeue() == originalItems[2],
                "Remove the third item"
        );


        // Test 6: Add three new items to the empty spaces.
        FoodItem newItem1 = createFood("Hotdog", 201, 5);
        FoodItem newItem2 = createFood("Burger", 202, 5);
        FoodItem newItem3 = createFood("Pizza", 203, 5);

        check(fullQueue.enqueue(newItem1), "Reuse an empty space");
        check(fullQueue.enqueue(newItem2), "Reuse another empty space");
        check(fullQueue.enqueue(newItem3), "Reuse another empty space");

        check(fullQueue.isFull(), "Queue becomes full again");
        check(fullQueue.size() == 8, "Size is 8 after reusing spaces");


        // Test 7: Check that the FIFO order is correct.
        FoodItem[] currentItems = fullQueue.getItems();

        check(currentItems.length == 8, "getItems returns 8 items");

        check(
                currentItems[0] == originalItems[3],
                "FIFO order is correct after removing three items"
        );

        check(
                currentItems[5] == newItem1
                        && currentItems[6] == newItem2
                        && currentItems[7] == newItem3,
                "New items are in the correct order"
        );


        // Test 8: Search for food items.
        FoodItem[] searchResults = fullQueue.search("burger");

        check(
                searchResults.length == 2,
                "Search finds both Burgers without checking capital letters"
        );

        check(
                fullQueue.search("  ").length == 0,
                "Search rejects blank input"
        );

        check(
                fullQueue.search("Chicken").length == 0,
                "Search returns no results for an unknown food"
        );


               // Test 9: Check invalid food information.
        CircularQueue validationQueue = new CircularQueue();

        // We try to create food with an invalid name.
        // The FoodItem constructor may reject it.
        try {
            FoodItem invalidName = createFood("Chicken", 200, 7);

            check(
                    !validationQueue.enqueue(invalidName),
                    "Reject an unapproved food name"
            );

        } catch (IllegalArgumentException e) {

            // The constructor rejected the invalid name.
            check(true, "Reject an unapproved food name");
        }


        // We test a negative weight.
        try {
            FoodItem invalidWeight = createFood("Burger", -100, 7);

            check(
                    !validationQueue.enqueue(invalidWeight),
                    "Reject a negative weight"
            );

        } catch (IllegalArgumentException e) {

            check(true, "Reject a negative weight");
        }


        // We test a date in the past.
        try {
            FoodItem pastDate = createFood("Burger", 200, -1);

            check(
                    !validationQueue.enqueue(pastDate),
                    "Reject a date in the past"
            );

        } catch (IllegalArgumentException e) {

            check(true, "Reject a date in the past");
        }


        // We test a date more than 14 days away.
        try {
            FoodItem futureDate = createFood("Burger", 200, 15);

            check(
                    !validationQueue.enqueue(futureDate),
                    "Reject a date more than 14 days away"
            );

        } catch (IllegalArgumentException e) {

            check(true, "Reject a date more than 14 days away");
        }


        // We test an invalid weight value.
        try {
            FoodItem invalidNumber = createFood("Burger", Double.NaN, 7);

            check(
                    !validationQueue.enqueue(invalidNumber),
                    "Reject an invalid weight value"
            );

        } catch (IllegalArgumentException e) {

            check(true, "Reject an invalid weight value");
        }


        // We check that invalid items were not stored.
        check(
                validationQueue.isEmpty(),
                "Invalid items are not stored"
        );


        // Test 10: Display the food items.
        System.out.println();
        System.out.println("=== Display Test ===");
        fullQueue.display();

        System.out.println();
        System.out.println("=== Tests Finished ===");
    }
}