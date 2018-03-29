package preconditions;

import static com.google.common.base.Preconditions.*;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.List;

//只能检查是否null，不能检查empty，相比之下，感觉Spring的Assert能够检查是否为empty，感觉更好
//但是guava更具可读性，而且只用在检查常数，感觉自己可以增强一下，然后使用。
public class PreconditionsTest {
    @Test
    public void test(){
        service(null, null, null);
    }

    public Integer service(Integer a, Integer b, List<String> list){
        checkNotNull(a, "a不能为null");
        return null;
    }
}
