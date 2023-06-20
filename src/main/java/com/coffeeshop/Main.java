package com.coffeeshop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");

        // CoffeeShop shop = new CoffeeShop();

        CoffeeShop shop = ctx.getBean(CoffeeShop.class);

        shop.order(DrinkType.TEA, SizeType.SMALL);

    }
}
