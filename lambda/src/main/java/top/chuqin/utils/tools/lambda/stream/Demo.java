package top.chuqin.utils.tools.lambda.stream;

import org.junit.Test;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class Demo {
    @Test
    public void test() {
        List<String> collected = Stream.of("a", "b", "c")
                .collect(toList());


        collected.stream().map(new Function<String, Object>() {

            @Override
            public Object apply(String s) {
                return null;
            }
        });


        List<String> beginningWithNumbers = Stream.of("a", "1abc", "abc1")
                .filter(value -> isDigit(value.charAt(0)))
                .collect(toList());
        assertEquals(asList("1abc"), beginningWithNumbers);


        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(toList());
        assertEquals(asList(1, 2, 3, 4), together);
    }

    @Test
    public void test2(){
        List<String> collected = Stream.of("a", "b", "c")
                .collect(toList());


        collected.stream().map(new Function<String, Object>() {

            @Override
            public Object apply(String s) {
                System.out.println(s);
                return s.toLowerCase();
            }

            @Override
            public <V> Function<V, Object> compose(Function<? super V, ? extends String> before) {
                System.out.println("compose");
                return null;
            }

            @Override
            public <V> Function<String, V> andThen(Function<? super Object, ? extends V> after) {
                System.out.println("andThen");
                return null;
            }
        }).count();
    }
}
