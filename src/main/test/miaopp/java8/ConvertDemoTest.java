package miaopp.java8;

import miaopp.java8.lambda.Convert;
import org.junit.Test;

/**
 * Created by miaoping on 16/9/29.
 */
public class ConvertDemoTest {

    @Test
    public void run() {
        //写法一
        Convert<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);

        //写法二
        Convert<String, Integer> converter1 = Integer::valueOf;
        Integer converted1 = converter1.convert("123");
        System.out.println(converted1);

        Something something = new Something();
        Convert<String, String> converter2 = something::startWith;
        String converted2 = converter2.convert("Java");
        System.out.println(converted2);

        //Lambda表达式可以从局部读取一个final修饰的局部变量
        final int num = 1;
        Convert<Integer, String> stringConverter = (form) -> String.valueOf(form + num);
        String converted3 = stringConverter.convert(2);
        System.out.println(converted3);



    }

    class Something {
        String startWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }
}
