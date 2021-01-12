package com.qf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

//exclude 启动时不需要加载数据库的连接信息
@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class)
@EnableZuulProxy
@EnableDiscoveryClient
public class ZhiHuZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZhiHuZuulApplication.class);
    }
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize("400MB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("400MB");
        return factory.createMultipartConfig();
    }

}
