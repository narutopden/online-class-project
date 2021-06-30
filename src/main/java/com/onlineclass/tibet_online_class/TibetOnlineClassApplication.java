package com.onlineclass.tibet_online_class;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.onlineclass.tibet_online_class.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class TibetOnlineClassApplication {

    public static void main(String[] args) {
        SpringApplication.run(TibetOnlineClassApplication.class, args);

    }

}
