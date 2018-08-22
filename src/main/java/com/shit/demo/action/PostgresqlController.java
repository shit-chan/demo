package com.shit.demo.action;

import com.shit.demo.bean.Result;
import com.shit.demo.postgresql.service.PostgresqlService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PostgresqlController {

    @Resource
    private PostgresqlService postgresqlService;

    @RequestMapping("/postgresql/test")
    public Result test() {
        Result result = new Result("Y", "进入PostgreSQL时代！");
        return result;
    }
}
