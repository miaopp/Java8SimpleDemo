package miaopp.java8.functionalinterface;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import miaopp.java8.lambda.constructor.Person;

import java.util.*;
import java.util.concurrent.TimeUnit;
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
        //Map映射
        stringList.stream().map(String::toUpperCase).sorted((a, b) -> a.compareTo(b)).forEach(System.out::println);
        //Match(匹配)
        boolean anyStartWithA = stringList.stream().anyMatch(s -> s.startsWith("a"));
        System.out.println(anyStartWithA);//true
        boolean allStartWithA = stringList.stream().allMatch(s -> s.startsWith("a"));
        System.out.println(allStartWithA);//false
        boolean nonStartWithE = stringList.stream().noneMatch(s -> s.startsWith("e"));
        System.out.println(nonStartWithE);
        //Count
        long count = stringList.stream().filter(s -> s.startsWith("a")).count();
        System.out.println(count);
        //Reduce(合并)完成一个流中元素合并操作通过给定的函数.返回的结果通过 Optional来保存值
        Optional<String> reduced = stringList.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
        //Parallel Streams(并行流)
        List<String> values = Lists.newArrayListWithCapacity(1000000);
        for (int i = 0; i < 1000000; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        //Sequential Sort(串行排序)
        long t0 = System.nanoTime();
        long count1 = values.stream().sorted().count();
        //排序时间
        System.out.println(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - t0));//899ms
        //Parallel Sort(并行排序)
        long t1 = System.nanoTime();
        long count2 = values.parallelStream().sorted().count();
        System.out.println(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - t1));//472ms
        //Map(映射)
        Map<Integer, String> map = Maps.newHashMap();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "value_" + i);
        }
        //遍历map
        map.forEach((key, value) -> System.out.println(value));

    }
}
