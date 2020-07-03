package com.shit.demo.action;

import com.shit.demo.bean.Result;
import com.shit.demo.redis.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RedisController {
    @Resource
    private RedisService redisService;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/redis/set")
    public Result set(){
        Result result = new Result("Y","成功保存redis");
        try {
            for(int i=0;i<1000;i++) {
                redisService.set(String.valueOf(i), String.valueOf(i));
            }
            redisService.set("1000", "1000", 30L);
            log.info("设置了key为1000的有效期为30秒");
        }catch (Exception e){
            result.setResultCode("N");
            result.setResultMsg(e.getMessage());
            log.error("保存键值对到redis失败：",e);
        }
        return result;
    }

    @PostMapping("/redis/delete")
    public Result delete(){
        Result result = new Result("Y","成功删除redis");
        try {
            redisService.remove("1");
            log.info("删除掉key：1");
            String[] keys = {"1", "2", "3"};
            redisService.remove(keys);
            log.info("删除掉key：1，2，3");
            String pattern = "^1";
            redisService.removePattern(pattern);
            log.info("删除掉以1开头的key");
        }catch (Exception e){
            result.setResultCode("N");
            result.setResultMsg(e.getMessage());
            log.error("删除遇到异常：",e);
        }
        return result;
    }

    @PostMapping("/redis/get")
    public Result get(){
        Result result = new Result("Y","成功查询redis");
        try{
            if(redisService.exists("33")){
                result.setResultDetail(redisService.get("33"));
            }
        }catch (Exception e){
            result.setResultCode("N");
            result.setResultMsg(e.getMessage());
            log.error("获取redis数据失败：",e);
        }
        return result;
    }

    @PostMapping("/redis/hash")
    public  Result hash(){
        Result result = new Result("Y","成功查询redis");
        try{
            redisService.hmSet("clx","shit","ring");
            result.setResultDetail(redisService.hmGet("clx","shit"));
        }catch (Exception e){
            result.setResultCode("N");
            result.setResultMsg(e.getMessage());
            log.error("获取redis数据失败：",e);
        }
        return result;
    }

    @PostMapping("/redis/list")
    public Result list(){
        Result result = new Result("Y","成功查询redis");
        try{
            redisService.lPush("list","A");
            redisService.lPush("list","B");
            redisService.lPush("list","C");
            result.setResultDetail(redisService.lRange("list",0,-1));
            log.info("lPop:"+redisService.lPop("list").toString());
            log.info("rPop"+redisService.rPop("list").toString());
        }catch (Exception e){
            result.setResultCode("N");
            result.setResultMsg(e.getMessage());
            log.error("获取redis数据失败：",e);
        }
        return result;
    }

    @PostMapping("/redis/mdel")
    public Result mdel(){
        Result result = new Result("Y","使用pipaline批量删除key成功");
        List<String> delList = new ArrayList<String>();
        for(int i=0;i<999;i++){
            delList.add(String.valueOf(i));
        }
        redisService.mdel(delList);
        return result;
    }

}
