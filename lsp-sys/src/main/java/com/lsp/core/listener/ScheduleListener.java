package com.lsp.core.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by songbo on 2018/8/1.
 */
@Configuration
@Slf4j
public class ScheduleListener implements ApplicationListener<ContextRefreshedEvent> {

}
