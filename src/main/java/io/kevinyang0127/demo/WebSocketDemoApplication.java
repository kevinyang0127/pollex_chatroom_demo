package io.kevinyang0127.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
@EnableWebSocket
public class WebSocketDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSocketDemoApplication.class, args);
	}
}
