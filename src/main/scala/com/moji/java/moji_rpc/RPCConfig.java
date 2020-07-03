//package com.moji.java.moji_rpc;
//
//import com.mojithrift.config.spring.ClientBean;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.ImportResource;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//
//@Configuration
//@ImportResource(locations = {"classpath*:application_client_layer.xml"})
//public class RPCConfig {
//    @Resource
//    private ApplicationContext applicationContext;
//
//    @PostConstruct
//    public ClientBean clientBean() {
//        ClientBean clientBean = new ClientBean();
//        clientBean.setApplicationContext(applicationContext);
//        clientBean.setId("fsmServiceClient");
//        clientBean.setMonitor(true);
//        clientBean.setMaxActive(10);
//        clientBean.setMaxIdle(10);
//        clientBean.setMaxWait(8000);
//        clientBean.setName("fsmServer");
//        clientBean.setGroup("platform");
//        clientBean.setVersion("1.0.0");
//        clientBean.setService("fsmService");
//        clientBean.setIface("com.moji.java.moji_rpc.FsmService$Iface");
//        return clientBean;
//    }
//
//}
