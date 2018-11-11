package cn.ldm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("cn.ldm.mapper")
@SpringBootApplication
@EnableEurekaClient
public class AppM {
    public static void main(String[] args) {
        SpringApplication.run(AppM.class, args);
    }
}