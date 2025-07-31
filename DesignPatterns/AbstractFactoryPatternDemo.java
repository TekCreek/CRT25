// Abstract Factory Interface
interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory for Windows
class WindowsUIFactory implements UIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Concrete Factory for MacOS
class MacUIFactory implements UIFactory {
    public Button createButton() {
        return new MacButton();
    }
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Abstract Product: Button
interface Button {
    void render();
}

// Abstract Product: Checkbox
interface Checkbox {
    void render();
}

// Concrete Products for Windows
class WindowsButton implements Button {
    public void render() {
        System.out.println("Rendering a Windows style Button.");
    }
}
class WindowsCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering a Windows style Checkbox.");
    }
}

// Concrete Products for MacOS
class MacButton implements Button {
    public void render() {
        System.out.println("Rendering a MacOS style Button.");
    }
}
class MacCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering a MacOS style Checkbox.");
    }
}

// Client Code
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        UIFactory factory;
        
        // Example: Create UI for Windows
        factory = new WindowsUIFactory();
        Button winButton = factory.createButton();
        Checkbox winCheckbox = factory.createCheckbox();
        winButton.render();
        winCheckbox.render();
        
        // Example: Create UI for MacOS
        factory = new MacUIFactory();
        Button macButton = factory.createButton();
        Checkbox macCheckbox = factory.createCheckbox();
        macButton.render();
        macCheckbox.render();
    }
}
