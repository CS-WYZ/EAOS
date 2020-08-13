package framework.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: CS-WYZ
 * @Date: Created in 21:18  2020/8/13
 * @Description:
 */

@RestController
public class DemoController {
    @RequestMapping("/hello1")
    public String hello1() {
        return "Hello World";
    }

    @RequestMapping("/hello2")
    public List<String> hello2() {
        return Arrays.asList(new String[] { "A", "B", "C" });
    }
}
