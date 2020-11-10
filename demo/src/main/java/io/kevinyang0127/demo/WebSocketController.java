package io.kevinyang0127.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {
    @GetMapping("/kkk")
    public Object kkk(){
        return "hello api";
    }
}
