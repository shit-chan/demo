package com.shit.demo.action;

import com.shit.demo.bean.Result;
import com.shit.demo.rabbitmq.Sender;
import com.shit.demo.rabbitmq.Sender1;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RabbitMqController {
    @Resource
    private Sender sender;
    @Resource
    private Sender1 sender1;
    @PostMapping(value="/rabbitmq/hello")
    public Result send(){
        Result result = new Result("Y","调用rabbitmq成功！");
        sender.send();
        sender1.send();
        return result;
    }
}
