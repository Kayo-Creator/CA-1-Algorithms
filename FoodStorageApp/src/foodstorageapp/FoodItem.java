/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author kayon
 */
//store dates
package foodstorageapp;

import java.time.LocalDate;
//stores both date and time
import java.time.LocalDateTime;

public class FoodItem {

    //food's name
    private String name;
    //weight
    private double weightInGrams;
    //best before date
    private LocalDate bestBeforeDate;
    //declare date and time
    private LocalDateTime timeAdded;

    //constructor                       
    public FoodItem(String burguer, double weightInGrams, LocalDate bestBeforeDate) {

        if (weightInGrams <= 0 || !Double.isFinite(weightInGrams)) {
            //Its gonna make stop the food item and explain the problem.
            throw new IllegalArgumentException(
                    "Weight must be a number greater than 0 grams."
            );

        }
        //if a name has spaces or missing it will reject
        if (burguer == null || burguer.trim().isEmpty()) {
            throw new IllegalArgumentException("Enter a food name.");
        }
//      Remove spaces at the start
        burguer = burguer.trim();
//      Check if the name macthes the allowed foods
        boolean validName
                = burguer.equalsIgnoreCase("Burger")
                || burguer.equalsIgnoreCase("Pizza")
                || burguer.equalsIgnoreCase("Fries")
                || burguer.equalsIgnoreCase("Sandwich")
                || burguer.equalsIgnoreCase("Hotdog");

        // It will reject any food that is not on the list    
        if (!validName) {

            throw new IllegalArgumentException("Choose Burguer, Pizza, Fries, Sandwich or Hotdog"
            );
        }
// check best-before date
        if (bestBeforeDate == null) {
            throw new IllegalArgumentException("Enter a best-before date");

        }
        //get todays date
        LocalDate today = LocalDate.now();
        //makes sure is between today or in two weeks
        if (bestBeforeDate.isBefore(today) || bestBeforeDate.isAfter(today.plusWeeks(2))) {

            throw new IllegalArgumentException("Best-before date must be between today and in two weeks.");
        }

        name = burguer;

        this.weightInGrams = weightInGrams;

        this.bestBeforeDate = bestBeforeDate;

    }
// record entry time

    public void markAddedToStorage() {
        this.timeAdded = LocalDateTime.now();

    }

    //getter
    public String getName() {

        return this.name;
    }

    //getter
    public double getWeightInGrams() {

        return this.weightInGrams;
    }

    //getter
    public LocalDate getBestBeforeDate() {

        return this.bestBeforeDate;
    }

    //getter
    public LocalDateTime getTimeAdded() {

        return this.timeAdded;
    }
}
