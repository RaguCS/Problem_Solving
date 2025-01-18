package com.ragu.LLD_Patterns;

public class PizzaMain {
    public static void main(String[] args) {
        Pizza pizza=new Pizza.PizzaBuilder().setDough("thin").setSauce("tomato").setTopping("Olives").build();
        pizza.display();

    }
}
