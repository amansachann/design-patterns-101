package com.codewithaman.CreationalPatterns.AbstractFactoryPattern.WithoutAbstractFactoryPattern;

// Windows UI Components
class WindowsButton {
    public void render() {
        System.out.println("Windows Button");
    }
}

class WindowsScrollbar {
    public void scroll() {
        System.out.println("Windows Scrollbar");
    }
}

// MacOS UI components
class MacOsButton {
    public void render() {
        System.out.println("Mac OS Button");
    }
}

class MacOsScrollbar {
    public void scroll() {
        System.out.println("Mac OS Scrollbar");
    }
}

public class Application {

    // Issues: Tight Coupling with the classes, hard to extend
    public static void main(String[] args) {
        WindowsScrollbar windowsScrollbar = new WindowsScrollbar();
        windowsScrollbar.scroll();
        MacOsScrollbar macOsScrollbar = new MacOsScrollbar();
        macOsScrollbar.scroll();
    }
}
