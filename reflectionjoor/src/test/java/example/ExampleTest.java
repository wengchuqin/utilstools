package example;

import static org.joor.Reflect.*;

import org.junit.Test;

public class ExampleTest {
    @Test
    public void test() {
        String world = on("java.lang.String")  // Like Class.forName()
                .create("Hello World") // Call most specific matching constructor
                .call("substring", 6)  // Call most specific matching substring() method
                .call("toString")      // Call toString()
                .get();                // Get the wrapped object, in this case a String

        System.out.println(world);
    }

}
