import java.util.ArrayList;

public class CoffeeShop {

    double order(DrinkType beverage, SizeType size) {
        double price = 0.0;

        PriceDB db = new PriceDB();
        price = db.findPrice(size, beverage);


        System.out.println("you ordered a " + size + " " + beverage);
        System.out.printf("That will be $%5.2f\n", price);

        return price;
    }

}
