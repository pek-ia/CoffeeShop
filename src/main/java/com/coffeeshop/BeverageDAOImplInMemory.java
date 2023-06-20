package com.coffeeshop;

import java.util.ArrayList;
import java.util.List;

public class BeverageDAOImplInMemory implements BeverageDAO {

    private final ArrayList<Beverage> beverageList = new ArrayList<>();


    public double findPrice(SizeType size, DrinkType type) {
        double value = 0.0;
        for (Beverage b : beverageList) {
            if (b.getSize() == size && b.getType() == type) value = b.getPrice();
        }
        return value;
    }

    public List<Beverage> findBeveragesByType(DrinkType type){
        List<Beverage> bevs = new ArrayList<Beverage>();
        for (Beverage b : beverageList) {
            if (b.getType() == type) bevs.add(b);
        }
        return bevs;
    }

    public BeverageDAOImplInMemory() {
        this.beverageList.add( new Beverage(SizeType.SMALL, 8.00, DrinkType.COFFEE));
        this.beverageList.add( new Beverage(SizeType.MEDIUM, 4.98, DrinkType.COFFEE));
        this.beverageList.add( new Beverage(SizeType.LARGE, 6.00, DrinkType.COFFEE));
        this.beverageList.add( new Beverage(SizeType.SMALL, 1.80, DrinkType.TEA));
        this.beverageList.add( new Beverage(SizeType.MEDIUM, 3.00, DrinkType.TEA));
        this.beverageList.add( new Beverage(SizeType.LARGE, 6.00, DrinkType.TEA));
    }

}
