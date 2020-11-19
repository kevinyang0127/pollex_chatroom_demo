package io.kevinyang0127.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class RestfulController {
    @GetMapping("/getLoginList")
    public List<String> getLoginList(){
        return WebSocketUtil.getLoginList();
    }

    @GetMapping("/test")
    public String test(){
        return "success!!";
    }
}
