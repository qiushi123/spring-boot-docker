package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/redis")
    public String redis(Model model) {
        stringRedisTemplate.opsForValue().set("zzp", "big z");
        model.addAttribute("redis", stringRedisTemplate.opsForValue().get("zzp"));
        return "redis/redis";
    }
}