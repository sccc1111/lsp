package com.lsp.core.config;

import com.lsp.core.annotation.LogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by songbo on 2018/8/1.
 */
@Configuration
public class LogConfig {

    @Bean(name = "logAspect")
    public LogAspect getLogAspect(){
        return new LogAspect();
    }

}