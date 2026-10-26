/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodstorageapp;


import java.time.LocalDate;

/**
 *
 * @author kayon
 */
public class FoodStackTest {

    public static void main(String[] args) {

        //Create an empty stack and a valid best-before date.
        FoodStack stack = new FoodStack();
        LocalDate date = LocalDate.now().plusDays(7);

        //Test 1: add one item and check the entry time.
        FoodItem first = new FoodItem("Burger", 250.5, date);
        boolean timeWasEmpty = first.getTimeAdded() == null;

        stack.add(first);

        System.out.println("1. Item added and time recorded: "
                + (stack.size() == 1
                && timeWasEmpty
                && first.getTimeAdded() != null));

        //Test 2: add seven more items to fill all eight spaces.
        for (int i = 1; i < 8; i++) {
            stack.add(new FoodItem("Pizza", 200, date));
        }

        System.out.println("2. Eight items accepted: "
                + (stack.size() == 8 && stack.isFull()));

        //Test 3: try adding the item number 9.
        FoodItem ninth = new FoodItem("Fries", 150, date);
        boolean ninthRejected = false;

        try {
            stack.add(ninth);

        } catch (IllegalStateException e) {

            //The full-storage error is expected.
            ninthRejected = true;
        }

        //Check that the count stayed at eight.
        //The rejected item should still have no entry time.
        System.out.println("3. Ninth item rejected: "
                + (ninthRejected
                && stack.size() == 8
                && stack.isFull()
                && ninth.getTimeAdded() == null));
    }
}