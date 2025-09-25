package assignment2_1;

public class CoffeeMakerDriver {
    public static void main(String[] args) {
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        // Switch the device on (only if it's not already on)
        if (!coffeeMaker.isOn())
            coffeeMaker.pressOnOff();
        System.out.println(coffeeMaker.getStatus());

        // Set coffee type to espresso
        coffeeMaker.setCoffeeType("espresso");
        System.out.println("Coffee type is " + coffeeMaker.getCoffeeType());

        // Set coffee amount to 50 ml
        coffeeMaker.setCoffeeAmount(50);
        System.out.println("Coffee amount is " + coffeeMaker.getCoffeeAmount() + " ml");

        // Switch the device off
        coffeeMaker.pressOnOff();
        System.out.println(coffeeMaker.getStatus());
    }
}