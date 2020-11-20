package io.kevinyang0127.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 打包成war需要，
 * 默認的啟動類需要繼承SpringBootServletInitializer，並覆寫configure()方法
 * SpringBootServletInitializer的執行過程
 * 簡單來說就是通過SpringApplicationBuilder構建並封裝SpringApplication對象，
 * 並最終調用SpringApplication的run方法。
 * */
public class SpringBootStartApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意這裡要指向原先用main方法執行的Application啟動類
        return builder.sources(WebSocketDemoApplication.class);
    }

}
