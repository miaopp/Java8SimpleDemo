package miaopp.java8.lambda;

/**
 * Created by miaoping on 16/9/29.
 */
@FunctionalInterface
public interface Convert<F, T> {
    T convert(F from);
}
