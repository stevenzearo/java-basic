package steve.constructor;

/**
 * @author steve
 */
public class PersonTest {
    public static void main(String[] args) {
        Person steve = Person.INSTANCE.getInstance();
        Person steve2 = Person.INSTANCE.getInstance();
        System.out.println(steve == steve2);
    }
}
