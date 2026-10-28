/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package foodstorageapp;

import java.util.Scanner;

/**
 *
 * @author kayon
 */
public class FoodStorageApp {

    public static void main(String[] args) {

        // Read the user's answers from the keyboard.
        Scanner input = new Scanner(System.in);
        // Choose the storage structure used by the menu.

        FoodStorage storage = chooseStorage(input);

// End the application if the user chooses Exit.
        if (storage == null) {
            input.close();
            System.out.println("Bye.");
            return;
        }

        // Keep the menu open until the user chooses Exit.
        boolean running = true;

        while (running) {

            // Show the available operations.
            System.out.println("\n=== Food Storage ===");
            // Show how many of the eight spaces are occupied.
            System.out.println("Stored items: " + storage.size() + "/8");
            System.out.println("1. Add food");
            System.out.println("2. Remove food");
            System.out.println("3. Peek at the next item");
            System.out.println("4. Show all food");
            System.out.println("5. Look for food");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            // Finish if keyboard input is closed.
            if (!input.hasNextLine()) {
                break;
            }

            // Read a whole line, so letters don't crash the menu.
            String choice = input.nextLine().trim();

           
            // Run the operation selected in the food menu, decide what to do with the chosen option.
            switch (choice) {

                // The Add input step will be connected next.
                case "1":
                    System.out.println("Add food selected.");
                    break;

                // Remove the next item using the selected storage structure.
                case "2":

                    // Deal with empty storage before trying to remove.
                    if (storage.isEmpty()) {
                        System.out.println("Storage is empty.");
                    } else {

                       
                        // The queue removes the oldest item, the stack removes the newest item.
                        FoodItem removedItem = storage.remove();

                        // Show which food was removed.
                        System.out.println("Removed: " + removedItem.getName());
                    }
                    break;

                // Read the next item without removing it.
                case "3":

                    // Deal with empty storage before trying to use the method Peek.
                    if (storage.isEmpty()) {
                        System.out.println("Storage is empty.");
                    } else {

                        // Get the next item while keeping it in storage.
                        FoodItem nextItem = storage.peek();

                        // Show the food's name.
                        System.out.println("Next item: " + nextItem.getName());
                    }
                    break;

                // Display and Search of my jackson will connect here.
                case "4":
                case "5":
                    System.out.println("You selected option " + choice + ".");
                    break;

                // Stop the menu loop.
                case "0":
                    running = false;
                    break;

                // in case of an incorrect menu choice.
                default:
                    System.out.println("Please choose 0, 1, 2, 3, 4 or 5.");
            }
        }

        // Release the scanner and confirm the application has finished.
        input.close();
        System.out.println("Bye.");
    }

    // Let the user choose a stack or circular queue.
    private static FoodStorage chooseStorage(Scanner input) {

        // Repeat until a valid choice is insert.
        while (true) {

            // Explain the storage types available.
            System.out.println("\nChoose a storage type:");
            System.out.println("1. Stack (LIFO)");
            System.out.println("2. Circular queue (FIFO)");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            // Signal Exit if keyboard input is closed.
            if (!input.hasNextLine()) {
                return null;
            }

            // Read the answer without crashing on letters.
            String choice = input.nextLine().trim();

            switch (choice) {

                // Create storage that removes the new item first.
                case "1":
                    System.out.println("Stack selected.");
                    return new FoodStack();

                // Create storage that removes the old item first.
                case "2":
                    System.out.println("Circular queue selected.");
                    return new CircularQueue();

                // Signal that the application should finish.
                case "0":
                    return null;

                // Show the accepted choices and repeat.
                default:
                    System.out.println("Please choose 0, 1 or 2.");
            }
        }
    }

}
