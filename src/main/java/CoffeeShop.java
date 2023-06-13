import java.util.ArrayList;

public class CoffeeShop {

    private ArrayList<Beverage> beverageList = new ArrayList<>();


    double order(DrinkType beverage, SizeType size) {
        double price = 0.0;

        price = findPrice(size, beverage);


        System.out.println("you ordered a " + size + " " + beverage);
        System.out.printf("That will be $%5.2f\n", price);

        return price;
    }




    public double findPrice(SizeType size, DrinkType type) {
        double value = 0.0;
        for (Beverage b : beverageList) {
            if (b.getSize() == size && b.getType() == type) value = b.getPrice();
        }
        return value;
    }


    public CoffeeShop() {
        this.beverageList.add( new Beverage(SizeType.SMALL, 8.00, DrinkType.COFFEE));
        this.beverageList.add( new Beverage(SizeType.MEDIUM, 4.98, DrinkType.COFFEE));
        this.beverageList.add( new Beverage(SizeType.LARGE, 6.00, DrinkType.COFFEE));
        this.beverageList.add( new Beverage(SizeType.SMALL, 180.00, DrinkType.TEA));
        this.beverageList.add( new Beverage(SizeType.MEDIUM, 3.00, DrinkType.TEA));
        this.beverageList.add( new Beverage(SizeType.LARGE, 6.00, DrinkType.TEA));
    }
}
