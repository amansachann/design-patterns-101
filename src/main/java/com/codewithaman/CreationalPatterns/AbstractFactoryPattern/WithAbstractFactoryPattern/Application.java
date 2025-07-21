package com.codewithaman.CreationalPatterns.AbstractFactoryPattern.WithAbstractFactoryPattern;

interface Button {
    void render();
}

interface Scrollbar {
    void scroll();
}

// Windows UI Components
class WindowsButton implements Button {
    public void render() {
        System.out.println("Windows Button");
    }
}

class WindowsScrollbar implements Scrollbar {
    public void scroll() {
        System.out.println("Windows Scrollbar");
    }
}

// MacOS UI components
class MacOsButton implements Button {
    public void render() {
        System.out.println("Mac OS Button");
    }
}

class MacOsScrollbar implements Scrollbar {
    public void scroll() {
        System.out.println("Mac OS Scrollbar");
    }
}

// Abstract Factory
interface UIFactory {
    Button createButton();
    Scrollbar createScrollbar();
}

// Concrete Factory
class WindowsUIFactory implements UIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public Scrollbar createScrollbar() {
        return new WindowsScrollbar();
    }
}

class MacOsUIFactory implements UIFactory {
    public Button createButton() {
        return new MacOsButton();
    }
    public Scrollbar createScrollbar() {
        return new MacOsScrollbar();
    }
}

public class Application {
    private Button button;
    private Scrollbar scrollbar;

    public Application(UIFactory uiFactory) {
        this.button = uiFactory.createButton();
        this.scrollbar = uiFactory.createScrollbar();
    }

    public void renderUi() {
        button.render();
        scrollbar.scroll();
    }

    public static void main(String[] args) {
        Application app = new Application(new MacOsUIFactory());
        app.renderUi();
    }
}
