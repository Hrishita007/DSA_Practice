// Final, Finally, and Finalize in Java
public class FinalFinallyFinalize {

    // 1. final variable
    final int number = 100;

    // 2. finalize() method
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize() method called");
    }

    public static void main(String[] args) {

        FinalFinallyFinalize obj = new FinalFinallyFinalize();

        // final variable cannot be changed
        System.out.println("Final value: " + obj.number);

        // obj.number = 200;  // Error: cannot change final variable

        // 3. finally block
        try {
            int result = 10 / 2;
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Exception occurred");
        } finally {
            System.out.println("finally block executed");
        }

        // Making object eligible for garbage collection
        obj = null;

        // Request JVM to run Garbage Collector
        System.gc();

        System.out.println("Program completed");
    }
}
