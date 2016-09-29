package miaopp.java8.defaultmethod;

/**
 * Created by miaoping on 16/9/29.
 */
public interface Formula {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
