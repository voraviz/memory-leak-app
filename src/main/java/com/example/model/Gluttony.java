package com.example.model;

public class Gluttony {
    private Meal meals;
    private long size;
    
    public Gluttony(Meal meals, long size) {
        this.meals = meals;
        this.size = size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getSize() {
        return size;
    }

    public Meal getMeals() {
        return meals;
    }

    public void setMeals(Meal meals) {
        this.meals = meals;
    }
    
}
