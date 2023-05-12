import java.util.ArrayList;
import java.util.Collections;

public class CoffeeShop {

    public static void main(String[] args) {
        CoffeeShop shop = new CoffeeShop();
        shop.order(DrinkType.COFFEE, SizeType.MEDIUM);
    }

    private ArrayList<Beverage> beverageList = new ArrayList<>();

    public CoffeeShop() {
        this.beverageList.add( new Beverage(SizeType.SMALL, 8.00, DrinkType.COFFEE));
        this.beverageList.add( new Beverage(SizeType.MEDIUM, 4.98, DrinkType.COFFEE));
        this.beverageList.add( new Beverage(SizeType.LARGE, 6.00, DrinkType.COFFEE));
        this.beverageList.add( new Beverage(SizeType.SMALL, 180.00, DrinkType.TEA));
        this.beverageList.add( new Beverage(SizeType.MEDIUM, 3.00, DrinkType.TEA));
        this.beverageList.add( new Beverage(SizeType.LARGE, 6.00, DrinkType.TEA));
    }


    public double findPrice(SizeType size, DrinkType type) {
        double value = 0.0;
        for (Beverage b : beverageList) {
            if (b.getSize() == size && b.getType() == type) value = b.getPrice();
        }
        return value;
    }



    double order(DrinkType beverage, SizeType size) {
        double price = 0.0;

        price = findPrice(size, beverage);


        System.out.println("you ordered a " + size + " " + beverage);
        System.out.printf("That will be $%5.2f\n", price);

        return price;
    }
}
