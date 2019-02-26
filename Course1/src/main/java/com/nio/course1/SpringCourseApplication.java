package com.nio.course1;

import com.google.gson.JsonObject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCourseApplication.class, args);
    }

    @RequestMapping("/hello")
    public String hello() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("respCode", "00");
        jsonObject.addProperty("respMsg", "success");
        return jsonObject.toString();
    }

}
