/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodstorageapp;

// Allows to create the best-before date
import java.time.LocalDate;

/**
 *
 * @author Kayon
 */
public class FoodItemTest {

    /*
I did some manual tests to see if the code was working properly, the following are:
- Burger, 250.5 grams, date seven days ahead: accepted
- Zero weight: rejected
- Negative weight: rejected
- Food name "Cake": rejected
- Yesterday's date: rejected
- Date 15 days ahead: rejected
- Date exactly 14 days ahead: accepted
- Today's date: accepted
    
I ran them separately by changing the test inputs

     */
    // Starts this test program
    public static void main(String[] args) {
        // Create an item with an allowed name, positive weight, and a best-before date within two weeks

        // Test the last date allowed by the two-week limit
        try {
            // Check that today's date is allowed
            FoodItem food = new FoodItem(
                    "Burger",
                    250.5,
                    LocalDate.now()
            );

            // Creating the item means this test passed
            System.out.println(
                    "PASS: Accepted date: " + food.getBestBeforeDate()
            );

        } catch (IllegalArgumentException e) {

            // Rejecting this valid date means the test failed
            System.out.println("FAIL: " + e.getMessage());
        }
    }
}
