package com.moji.java.moji_rpc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mojithrift.model.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserLayer {
    private static final Logger logger = LogManager.getLogger("TestApplicationTests");
    ApplicationContext cxt = new ClassPathXmlApplicationContext("classpath:application_client_layer.xml");
    FsmService.Iface service = (FsmService.Iface) cxt.getBean("fsmService");

    public JSONObject getUserLayer(String params) {
        Long currentTimeMills = System.currentTimeMillis();

        Response result = null;
        try {
            result = service.statisticsLayer(params);
        } catch (TException e) {
            e.printStackTrace();
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        logger.info("time_cost:" + (currentTimeMillis2 - currentTimeMills) / 1000);
        System.out.println(JSON.toJSONString(result));
        if (result != null) return JSON.parseObject(JSON.toJSONString(result));
        else return null;
    }

    public static void main(String[] args) {
        List<Map<String, Object>> users = new ArrayList<>();
        Map<String, Object> param = new HashMap<>();
        param.put("uid", "100017731");
        param.put("platform", "android");
        param.put("version", "1006000102");
        param.put("activeDays", "0");
        param.put("lastActiveDays", "0");
        param.put("appStartCount", "0");
        param.put("vipStatus", "2");
        param.put("newDate", "2013-02-28");
        param.put("silenceDays", "0");
        param.put("snsid", "2");
        JSONObject result = new UserLayer().getUserLayer(JSON.toJSON(users).toString());
        if (result != null && result.get("code").toString().equals("200")) {
            System.out.println(result.get("result").toString());
        }
    }
}
