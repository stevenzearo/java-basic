package steve.spring;

import steve.reflect.Gender;
import steve.reflect.Person;

/**
 * @author steve
 */

@MyConfig("config")
public class Config {

    @MyBean("person")
    public Person getPerson() {
        return new Person("steve", 23, Gender.MALE);
    }
}
