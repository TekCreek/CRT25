/**
 * Decorator Pattern -
 *  Need -
 *     We should allow behaviour to be extended without the need to modify existing code.
 *
 *  Pros -
 *  1) Works as an alternative to subclassing, it extends the behaviour of
 *     an existing class with out modifying it.
 *  2) It mirrors the type of component that it decorates.
 *  3) You can wrap the component with any number of decorators.
 *  Cons -
 *  1) It can result in many small objects in the design, and overuse can
 *     become complex.
 *
 *  Example Decorator in Java -
 *
 *  ObjectOutputStream objOut =
 *      new ObjectOutputStream( // object serialization
 *          new BufferedOutputStream( // buffer
 *              new FileOutputStream("student.dat") // reading and writing bytes
 *          )
 *      );
 */

// abstract component
abstract class Pizza {
    public abstract double cost();
    public abstract String description();
}

// concrete components
class VegExtravaganza extends Pizza {
    @Override
    public double cost() {
        return 100;
    }

    public String description() {
        return "VegExtravaganza";
    }
}

class PeppyPaneer extends Pizza {
    @Override
    public double cost() {
        return 200;
    }

    public String description() {
        return "PeppyPaneer";
    }
}

// abstract decorator
abstract class Topping extends Pizza {

}

// concrete decorators
class ExtraCheese extends Topping {

    Pizza pizza;

    public ExtraCheese(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double cost() {
        return 50 + pizza.cost();
    }

    public String description() {
        return "ExtraCheese, " + pizza.description();
    }

}

class BlackOlives extends Topping {

    Pizza pizza;

    public BlackOlives(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double cost() {
        return 29 + pizza.cost();
    }

    public String description() {
        return "BlackOlives, " + pizza.description();
    }
}



public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Pizza pizza = new BlackOlives(new ExtraCheese(new VegExtravaganza()));
        System.out.println( "Pizza - " + pizza.description() + "; cost - " + pizza.cost() ); // 100 + 50 + 29

        Pizza pizza1 = new BlackOlives(new VegExtravaganza());
        System.out.println( "Pizza - " + pizza1.description() + "; cost - " + pizza1.cost() ); // 100 + 29

    }
}
