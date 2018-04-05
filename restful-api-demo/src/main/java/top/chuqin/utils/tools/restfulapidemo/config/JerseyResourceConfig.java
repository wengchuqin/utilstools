package top.chuqin.utils.tools.restfulapidemo.config;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;


public class JerseyResourceConfig extends ResourceConfig {
    public JerseyResourceConfig() {
        register(RequestContextFilter.class);
        // 配置那个包下面的会被Jersey扫描
        packages("top.chuqin.utils.tools.restfulapidemo.web");
    }
}
