package com.namkyung.workservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@RefreshScope
public class WorkServiceController {

    @Value("${userinfo.name}")
    private String configName;

    @Value("${userinfo.age}")
    private String configAge;

    @Value("${userinfo.phone}")
    private String configTel;

    @GetMapping(value="/work/{username}")
    public String getWork(@PathVariable("username") String username){
        String first = "Hello, " + configName + "!\n\n";
        String second = "I Check your info\n\n your age : " + configAge + ",\n your phoneNumber : " + configTel;
        String third = "\n\nRight?";
        return first + second + third;
    }

}
