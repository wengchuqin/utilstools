package top.chuqin.utils.tools.lambda;

import org.junit.Test;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class 多种表达形式 {
    @Test
    public void test() {
        Runnable noArguments = () -> System.out.println("hello world");

        ActionListener oneArgument = event -> System.out.println("button clicked");

        Runnable muliStatement = () -> {
            System.out.println("hello");
            System.out.println("world");
        };

        BinaryOperator<Long> add = (x, y) -> x + y;

        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;


    }
}
