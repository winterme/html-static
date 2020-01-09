package com.zzq.config;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author maxwell
 * @Description: TODO
 * @date 2020/1/9 18:11
 */
@Component
@EnableScheduling
public class IndexSch {

    public AtomicInteger index = new AtomicInteger(0);

    /**
     * 定时任务：
     *  @Scheduled 设置定时方法
     *
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void scheduled(){
        index = new AtomicInteger(0);
    }

}
