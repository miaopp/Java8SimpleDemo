package miaopp.java8;

import miaopp.java8.defaultmethod.Formula;
import org.junit.Test;

/**
 * Created by miaoping on 16/9/29.
 */
public class FormulaTest {
    @Test
    public void run() {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula.calculate(100));
        System.out.println(formula.calculate(16));
    }
}
