package com.shit.demo.action;

import com.shit.demo.bean.Result;
import com.shit.demo.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shit.demo.bean.User;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Resource
    private UserService userService;

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hello")
    public Result say() {
        log.info("say hello world!");
        Result result = new Result("Y", "hello world!");
        return result;
    }


    @PostMapping("/find")
    public Result find(@RequestBody @Valid User u, BindingResult bindingResult) {
        Result result = new Result("Y", "成功找到数据！");
        if (bindingResult.hasErrors()) {
            result.setResultCode("N");
            result.setResultMsg(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        User user = userService.select(u.getId());
        if (user != null) {
            result.setResultDetail(user);
            return result;
        } else {
            result.setResultCode("N");
            result.setResultMsg("找不到内容，请检查参数User=" + u);
            return result;
        }
    }

    @PostMapping("/insert")
    public Result insert(){
        Result result = new Result("Y", "成功找到数据！");
        User user = new User(2,"luo",18);
        userService.insert(user);
        return new Result("Y", "插入成功",user);
    }
}
