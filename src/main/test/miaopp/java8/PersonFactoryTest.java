package miaopp.java8;

import miaopp.java8.lambda.constructor.Person;
import miaopp.java8.lambda.constructor.PersonFactory;
import org.junit.Test;

/**
 * Created by miaoping on 16/9/29.
 */
public class PersonFactoryTest {

    @Test
    public void run() {
        PersonFactory<Person> personPersonFactory = Person::new;
        Person person = personPersonFactory.create("Peter", "Parker");

    }
}
