package com.coffeeshop;

import java.util.List;

public interface BeverageDAO {
    List<Beverage> findBeveragesByType(DrinkType type);
    public double findPrice(SizeType size, DrinkType type);

}
