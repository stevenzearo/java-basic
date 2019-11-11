package steve.constructor;

/**
 * @author steve
 */
public enum  Person {
    INSTANCE;
    private Person steve;
    public String name;

    public Person getInstance() {
        this.name = "steve";
        return steve;
    }
}
