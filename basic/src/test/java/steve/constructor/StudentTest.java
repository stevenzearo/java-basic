package steve.constructor;

import com.mongodb.util.JSON;
import steve.reflect.Gender;

/**
 * @author steve
 */
public class StudentTest {
    public static void main(String[] args) {
        Student steve = new Student.StudentBuilder("0001", "steve", Gender.MALE)
            .age(23)
            .grade(7)
            .score(78.5d)
            .builder();
        System.out.println(steve);
    }
}
