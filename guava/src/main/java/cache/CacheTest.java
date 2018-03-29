package cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Cache有put的方法，和get方法，可以对缓存进行读写
 */
public class CacheTest {
    LoadingCache<String, String> someCache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build(new CacheLoader<String, String>() {

                public String load(String s) throws Exception {
                    System.out.println("load");
                    return "chche" + s;
                }
            });


    public String get(String s) {
        String ret = null;
        try {
            ret = someCache.get(s);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return ret;
    }


    public static void main(String[] args) {
        CacheTest cacheTest = new CacheTest();
        for (int i = 0; i < 10; i++) {
            System.out.println(cacheTest.get(String.valueOf(5)));
        }
    }
}
