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
        name = burguer;
        this.weightInGrams = weightInGrams;
        this.bestBeforeDate = bestBeforeDate;

    }
// record entry time
    public void markAddedToStorage() {
        this.timeAdded = LocalDateTime.now();
    }
    
    
}
