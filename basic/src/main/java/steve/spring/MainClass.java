package steve.spring;

import java.util.Arrays;

/**
 * @author steve
 */
public class MainClass {
    public static void main(String[] args) {
        ApplicationContext configApplicationContext = new ApplicationContext(Config.class);
        Object[] beansName = configApplicationContext.getBeansName();
        Arrays.stream(beansName).forEach(System.out::println);

    }
}
