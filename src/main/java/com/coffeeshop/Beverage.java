package com.coffeeshop;

/**
 * com.coffeeshop.Beverage Bean - A Model Object
 */
public class Beverage {
    private SizeType size;
    private double price;
    private DrinkType type;

    // ctor
    public Beverage(SizeType size, double price, DrinkType type) {
        this.size = size;
        this.price = price;
        this.type = type;
    }

    public SizeType getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public DrinkType getType() {
        return type;
    }
}
