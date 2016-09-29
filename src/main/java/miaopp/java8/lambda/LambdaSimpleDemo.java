package miaopp.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by miaoping on 16/9/29.
 */
public class LambdaSimpleDemo {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Peter", "Anna", "Mike", "Xenia");
        //不用Lambda写法写排序
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //用Lambda表达式
        Collections.sort(names, (o1, o2) -> o1.compareTo(o2));
    }
}
