package cn.ldm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("cn.ldm.mapper")
@SpringBootApplication
@EnableEurekaClient
public class AppS {
    public static void main(String[] args) {
        SpringApplication.run(AppS.class, args);
    }
}