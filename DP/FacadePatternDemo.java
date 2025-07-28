/**
 * Facade Pattern -
 *   Provide a unified interface to a set of interfaces in a subsystem.
 *   Facade defines a higher-level interface that makes the subsystem easier to use.
 */

class Service1 {
    public void s1() {
        System.out.println("s1");
    }
}

class Service2 {
    public void s2() {
        System.out.println("s2");
    }
}

class ServiceFacade {
    Service1 service1 = new Service1();
    Service2 service2 = new Service2();

    public void unifiedService() {
        service1.s1();
        service2.s2();
    }
}

public class FacadePatternDemo {
    public static void main(String[] args) {
        // client
//        Service1 service1 = new Service1();
//        service1.s1();
//
//        Service2 service2 = new Service2();
//        service2.s2();

        // client
        ServiceFacade facade = new ServiceFacade();
        facade.unifiedService();
    }
}
