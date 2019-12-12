package steve.copy;

import steve.reflect.Gender;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author steve
 */
public class CopyTest {
    public static void main(String[] args) {
        Person black = new Person("black", 23, Gender.MALE);
        Person red = new Person("red", black.getAge(), Gender.FEMALE);
        black.setAge(10);
        System.out.println(red.getAge());
        Person green = new Person("green", 18, Gender.MALE);
        Person blue = new Person("blue", 25, Gender.FEMALE);
        List<Person> people = List.of(black, red, green, blue);
        List<Person> people1 = new ArrayList<>(people);
        people1.forEach(person -> person.setAge(10));
        people.forEach(System.out::println);
    }
}
