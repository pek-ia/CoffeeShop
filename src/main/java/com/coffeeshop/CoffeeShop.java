package com.coffeeshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoffeeShop {

    BeverageDAO bevd;

    @Autowired
    public CoffeeShop(BeverageDAO bevd){
        this.bevd = bevd;
    }

    double order(DrinkType beverage, SizeType size) {


//        BeverageDAO db = new BeverageDAOImplMySql();
        double price = bevd.findPrice(size, beverage);


        System.out.println("you ordered a " + size + " " + beverage);
        System.out.printf("That will be $%5.2f\n", price);

        return price;
    }

}
