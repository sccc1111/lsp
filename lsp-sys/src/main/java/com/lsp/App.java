package com.lsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by songbo on 2018/8/1.
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.lsp.mapper"})
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }
}
