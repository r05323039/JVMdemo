package jvm.controller;

import jvm.pojo.User;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/leak")
public class LeakController {
    private static Map<Long, User> userCache = new HashMap<>();
    private static List<byte[]> bigheap = new ArrayList<>();

    @GetMapping("/test")
    public void test1() throws InterruptedException {
        byte[] bytes = new byte[1024 * 1024 * 100];//100m
        Thread.sleep(10 * 1000);
    }

    @PostMapping("/login")
    public void login(String name, long id) {
        userCache.put(id, new User(id, name));
    }
}
