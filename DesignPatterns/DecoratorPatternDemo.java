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

// The Component interface
interface View {
    String draw();
}

// Concrete Component
class TextView implements View {
    private String text;

    public TextView(String text) {
        this.text = text;
    }

    @Override
    public String draw() {
        return text;
    }
}

// Decorator (abstract)
abstract class ViewDecorator implements View {
    protected View view;

    public ViewDecorator(View view) {
        this.view = view;
    }
}

// Concrete Decorator
class ScrollView extends ViewDecorator {
    public ScrollView(View view) {
        super(view);
    }

    @Override
    public String draw() {
        // Decorate the output
        return "ScrollView(" + view.draw() + ")";
    }
}

// Demo
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        View textView = new TextView("Hello, World!");
        System.out.println("TextView only: " + textView.draw());

        View scrollableTextView = new ScrollView(textView);
        System.out.println("ScrollView + TextView: " + scrollableTextView.draw());

        // You can add more decorators if needed (for example, BorderView)
    }
}
