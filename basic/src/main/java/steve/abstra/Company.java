package steve.abstra;

/**
 * @author steve
 */
public interface Company {
    default void start() {
        System.out.println("company is start to opening...");
    }

    void run();

    interface Person {
        void eat();
    }
}
