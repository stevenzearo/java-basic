package steve.spring;

import java.util.Arrays;

/**
 * @author steve
 */
@MyConfig
public class AnnotationTest {
    public static void main(String[] args) {
        var annotation = AnnotationTest.class.getAnnotations();
        if (annotation.length > 0) {
            Arrays.stream(annotation).forEach(System.out::println);
        }
    }
}
