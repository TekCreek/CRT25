/**
 * Facade Pattern -
 *   Provide a unified interface to a set of interfaces in a subsystem.
 *   Facade defines a higher-level interface that makes the subsystem easier to use.
 */

// Subsystem Class 1: Kitchen - Prepares food
class Kitchen {
    public void prepareFood() {
        System.out.println("Kitchen: Preparing your food.");
    }
}

// Subsystem Class 2: Billing - Handles the payment process
class Billing {
    public void generateBill() {
        System.out.println("Billing: Generating your bill.");
    }
}

// Subsystem Class 3: Delivery - Delivers the food
class Delivery {
    public void deliverFood() {
        System.out.println("Delivery: Delivering your food.");
    }
}

// Facade Class providing a simple interface to the complex subsystem
class RestaurantFacade {
    private Kitchen kitchen;
    private Billing billing;
    private Delivery delivery;

    public RestaurantFacade() {
        kitchen = new Kitchen();
        billing = new Billing();
        delivery = new Delivery();
    }

    // Simplified method for the client to order food
    public void orderFood() {
        System.out.println("Welcome to the Restaurant!");
        kitchen.prepareFood();
        billing.generateBill();
        delivery.deliverFood();
        System.out.println("Thank you for ordering with us!");
    }
}

// Client Code
public class FacadePatternDemo {
    public static void main(String[] args) {
        // Client interacts only with the facade
        RestaurantFacade restaurant = new RestaurantFacade();
        restaurant.orderFood();
    }
}
