package com.qf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
//标注当前工程是配置中心得服务端
@EnableConfigServer
//eureka的客户端
@EnableDiscoveryClient
public class ZhiHuConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZhiHuConfigApplication.class);
    }
}
