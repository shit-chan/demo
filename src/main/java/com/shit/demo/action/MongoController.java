package com.shit.demo.action;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.shit.demo.bean.User;
import com.shit.demo.mongodb.service.MongoService;
import com.shit.demo.bean.Result;
import net.sf.json.JSONObject;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MongoController {
    @Resource
    private MongoService mongoService;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/mongodb/test")
    public Result test() {
        StringBuilder msg = new StringBuilder("");
        MongoCollection mongoCollection = mongoService.getDatabase("shit").getCollection("table1");
        List<Object> insertList = new ArrayList<Object>();
        for (int i = 0; i < 10000; i++) {
            User user = new User(i, "shit", i);
            Document document = Document.parse(JSONObject.fromObject(user).toString());
            insertList.add(document);
        }
//        mongoCollection.insertMany(insertList);
        msg.append("插入数据成功！");
        long count = mongoCollection.count();
        msg.append("获取数据条数成功:" + count);
        FindIterable findIterable = mongoCollection.find();
        MongoCursor mongoCursor = findIterable.limit(1).iterator();
        msg.append("获取第一条数据成功:");
        while (mongoCursor.hasNext()) {
            msg.append(mongoCursor.next());
        }
        Document filter = new Document("id", 999);
        mongoCursor = findIterable.filter(filter).iterator();
        msg.append("获取第n条数据成功:");
        while (mongoCursor.hasNext()) {
            msg.append(mongoCursor.next());
        }
        Document update = new Document("$set",new Document("name","name333333"));
        UpdateResult updateResult = mongoCollection.updateMany(Filters.eq("id",333),update);
        msg.append("更新第n条数据成功，更新了"+updateResult.getModifiedCount()+"行数据,更新后的数据如下：");
        filter = new Document("id", 333);
        mongoCursor = findIterable.filter(filter).iterator();
        while (mongoCursor.hasNext()) {
            msg.append(mongoCursor.next());
        }
        DeleteResult deleteResult = mongoCollection.deleteMany(Filters.eq("id",444));
        msg.append("删除第n条数据成功，删除了"+deleteResult.getDeletedCount()+"条数据");
        Result result = new Result("Y", "mongodb", msg);
        return result;
    }

}
