public class CoffeeShop {

    public static void main(String[] args) {
        CoffeeShop shop = new CoffeeShop();
        shop.order(DrinkType.COFFEE, SizeType.MEDIUM);
    }

    double order(DrinkType beverage, SizeType size){
        double price = 0.0;

        switch (beverage) {
            case COFFEE -> {
                switch (size) {
                    case LARGE -> {
                        price = 6.0;
                    }
                    case MEDIUM -> {
                        price = 4.98;
                    }
                    case SMALL -> {
                        price = 8.0;
                    }
                }
            }
            case TEA -> {
                switch (size) {
                    case LARGE -> {
                        price = 6.0;
                    }
                    case MEDIUM -> {
                        price = 3.0;
                    }
                    case SMALL -> {
                        price = 180.0;
                    }
                }
            }

        }

        System.out.println("you ordered a " + size + " " + beverage);
        System.out.printf("That will be $%5.2f\n", price);

        return price;
    }
}
