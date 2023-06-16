import java.util.List;

public class Main {
    public static void main(String[] args) {
        CoffeeShop shop = new CoffeeShop();

        shop.order(DrinkType.TEA, SizeType.SMALL);


        BeverageDAO db = new BeverageDAOImplMySql();

        List<Beverage> bevs = db.findBeveragesByType(DrinkType.TEA);
        for (Beverage b: bevs){
            System.out.printf("%s, %s, costs %f\n",
                    b.getType(), b.getSize(), b.getPrice());

        }
    }
}
