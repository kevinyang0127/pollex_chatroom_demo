package io.kevinyang0127.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class SpringBootStartApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意這裡要指向原先用main方法執行的Application啟動類
        return builder.sources(WebSocketDemoApplication.class);
    }

}
