import java.io.*;
import java.lang.reflect.Constructor;

/**
 * Singleton Pattern -
 *  - Only one object/instance per container (here it is JVM for now)
 *  - Used when instance creation is costly
 *  - Examples usages
 *      - Runtime.getRuntime()
 *      - System.getSecurityManager()
 */

class Sample implements Serializable {

    // eager loading
    // private static Sample instance = new Sample();

    // lazy loading
    private static volatile Sample instance = null;

    // factory method
    public static Sample getInstance() {
        // double checking
        if (instance == null) {
            // synchronize the operation
            synchronized (Sample.class) {
                if (instance == null) {
                    // lazy loading
                    instance = new Sample();
                }
            }
        }
        return instance;
    }

    private Sample() {
        if (instance == null) {
            instance = this;
        } else {
            throw new IllegalStateException("you can not create object");
        }
    }

    // to fix deserialization issue
    public Object readResolve() {
        return instance;
    }

    // non static = requires an object.
    public void sayHello(String name) {
        System.out.println("Hello !!" + name);
    }
}

public class SingletonPatternDemo {
    public static void main(String[] args) throws Exception {

        // Using reflection
        Class<Sample> clazz = Sample.class;
        Constructor<Sample> constructor = clazz.getDeclaredConstructor();
        constructor.trySetAccessible();
        Sample obj = constructor.newInstance();

        // Sample s = new Sample(); // not allowed, because constructor is private.
        Sample s1 = Sample.getInstance();
        Sample s2 = Sample.getInstance();

        System.out.println("is s1 == s2 => " + (s1 == s2)); // true

        s1.sayHello("sagar");
        s2.sayHello("sagar");

        System.out.println("is s1 == obj => " + (s1 == obj)); // true

        // serialization
        ByteArrayOutputStream byteArrOut = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(byteArrOut);
        objOut.writeObject(obj);
        objOut.close();

        // collect the bytes written
        byte [] objBytes = byteArrOut.toByteArray();

        // deserialization
        ObjectInputStream objIn = new ObjectInputStream(new ByteArrayInputStream(objBytes));
        Sample obj2 = (Sample) objIn.readObject();

        System.out.println("is obj == obj2 => " + (obj == obj2)); // true
        objIn.close();


    }
}

