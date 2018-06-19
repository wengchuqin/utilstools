package top.chuqin.utils.tools.lambda;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 调式流 {

    @Test
    public void test() {
        List<String> list = Stream.of("abc").map(调式流::firstToUppercase).map(调式流::lastToUppercase)
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println(list);
    }


    static String firstToUppercase(String value) {
        char firstChar = Character.toUpperCase(value.charAt(0));
        return firstChar + value.substring(1);
    }

    static String lastToUppercase(String value) {
        char lastChar = Character.toUpperCase(value.charAt(value.length() - 1));
        return value.substring(0, value.length() - 1) + lastChar;
    }
}


