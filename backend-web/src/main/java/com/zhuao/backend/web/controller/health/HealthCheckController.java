package com.zhuao.backend.web.controller.health;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String healthCheck() {
        return "success";
    }

}
