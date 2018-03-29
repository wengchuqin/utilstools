package reflection;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.Invokable;
import org.junit.Test;

import java.io.IOException;
import java.util.stream.Collectors;

public class ClassPathTest {
    @Test
    public void test() throws IOException {
        ClassPath classpath = ClassPath.from(ClassPathTest.class.getClassLoader());
        classpath.getTopLevelClasses("").stream().collect(Collectors.toList());
    }
}
