package miaopp.java8.lambda.constructor;

/**
 * Created by miaoping on 16/9/29.
 */
public interface PersonFactory<P extends Person> {

    P create(String firstName, String lastName);

}
