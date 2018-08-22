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
@ComponentScan("com.shit.demo.service")
@MapperScan("com.shit.demo.mapper")
public class DemoController {
    @Resource
    private UserService userService;

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/demo/hello")
    public Result say() {
        log.info("say hello world!");
        Result result = new Result("Y", "hello world!");
        return result;
    }


    @PostMapping("/demo/find")
    public Result find(@RequestBody @Valid User u, BindingResult bindingResult) {
        Result result = new Result("Y", "成功找到数据！");
        if (bindingResult.hasErrors()) {
            result.setResultCode("N");
            result.setResultMsg(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        User user = userService.find(u.getId());
        if (user != null) {
            result.setResultDetail(user);
            return result;
        } else {
            result.setResultCode("N");
            result.setResultMsg("找不到内容，请检查参数User=" + u);
            return result;
        }
    }

}
