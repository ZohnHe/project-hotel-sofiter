package com.hotel.sofiter.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(tags = "测试Swagger")
@Controller
public class TestController {

    @ApiOperation(value = "test")
    @RequestMapping(value = {"","login"},method = RequestMethod.GET)
    public String TestSwagger(){
        return "login";
    }
}
