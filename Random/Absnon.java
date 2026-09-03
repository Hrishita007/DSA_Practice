//difference between abstract classes and interfaces
public abstract class Absnon {
    // Abstract class can have both abstract and non-abstract methods
    public abstract void abstractMethod();
    
    public void nonAbstractMethod() {
        System.out.println("This is a non-abstract method in an abstract class.");
    }
}
// public interface InterfaceExample {
//     // Interface can only have abstract methods (until Java 8, after which default and static methods are allowed)
//     void interfaceMethod();
    
//     // Default method in interface (Java 8 and above)
//     default void defaultMethod() {
//         System.out.println("This is a default method in an interface.");
//     }
// }