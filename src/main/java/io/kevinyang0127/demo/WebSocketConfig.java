package io.kevinyang0127.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {
    /**
     * ServerEndpointExporter 作用
     * 这个Bean会自动注册使用@ServerEndpoint注解声明的websocket endpoint
     *
     * 如果使用獨立的servlet容器，而不是直接使用springboot的內建容器，
     * 就不要注入ServerEndpointExporter，因為 它(ServerEndpointExporter) 將由容器自己提供和管理
     * @return
     */
//    @Bean
//    public ServerEndpointExporter serverEndpointExporter(){
//        return new ServerEndpointExporter();
//    }
}
