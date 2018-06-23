package strmantest;

import org.junit.Test;
import strman.Strman;

import java.util.Arrays;

public class StrmanTest {
    @Test
    public void test() {
        String[] strs = Strman.between("(hello)", "h", "o");
        System.out.println(Arrays.toString(strs));
    }
}
