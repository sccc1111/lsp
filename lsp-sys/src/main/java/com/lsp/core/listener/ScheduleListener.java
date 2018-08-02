package com.lsp.core.listener;

import com.lsp.entity.SysCron;
import com.lsp.service.CronService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.List;

/**
 * Created by songbo on 2018/8/1.
 */
@Configuration
@Slf4j
public class ScheduleListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired @Qualifier("Scheduler")
    private Scheduler scheduler;

    @Autowired
    private CronService cronService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("启动定时任务");
        List<SysCron> cronList = cronService.selectAll();
        if(null != cronList && cronList.size() > 0){
            for (SysCron cron: cronList) {
                try {
                    Class cls = Class.forName(cron.getClassname()) ;
                    cls.newInstance();
                    JobDetail job = JobBuilder.newJob(cls)
                            .withIdentity(cron.getName(),cron.getTgroup()).withDescription(cron.getDescription()).build();

                    // 触发时间点
                    CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron.getExpression());

                    Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger"+cron.getName(), cron.getTgroup())
                            .startNow().withSchedule(cronScheduleBuilder).build();

                    //交由Scheduler安排触发
                    scheduler.scheduleJob(job, trigger);

                    //启动任务
                    if("1".equals(cron.getStatus())){
                        scheduler.triggerJob(new JobKey(cron.getName(),cron.getTgroup()));
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (SchedulerException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
