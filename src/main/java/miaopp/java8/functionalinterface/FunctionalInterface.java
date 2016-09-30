package miaopp.java8.functionalinterface;

import com.google.common.collect.Lists;
import miaopp.java8.lambda.constructor.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by miaoping on 16/9/30.
 */
public class FunctionalInterface {

    public static void main(String[] args) {
        //Predicate函数
        Predicate<String> predicate = (s) -> s.length() > 0;

        System.out.println(predicate.test("foo"));
        System.out.println(predicate.negate().test("foo"));

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        //Function函数
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        System.out.println(backToString.apply("123"));

        //Supplier函数
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();

        //Consumer消费者
        Consumer<Person> greeter = (person -> System.out.println("hello" + person.getFirstName()));
        greeter.accept(new Person("Luke", "Skywalker"));

        //Comparator
        Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");
        comparator.compare(p1, p2);
        comparator.reversed().compare(p1, p2);

        //Optional
        //Optionals 并不是一个函数接口, 相反的它的作用就是避免出现空指针异常
        Optional<String> optional = Optional.of("bam");
        System.out.println(optional.isPresent());
        System.out.println(optional.get());
        System.out.println(optional.orElse("fallback"));
        optional.ifPresent(s -> System.out.println(s.charAt(0)));

        //Stream
        List<String> stringList = Lists.newArrayList();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");
        //Filter
        stringList.stream().filter(s -> s.startsWith("a")).forEach(System.out::println);
        //Sorted
        stringList.stream().filter(s -> s.startsWith("a")).sorted().forEach(System.out::println);
        
    }
}
