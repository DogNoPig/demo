package com.example.demo.handler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestSchedule {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedDelay = 5000)
    public void testfixDelay(){
        System.out.println("fixed===="+simpleDateFormat.format(new Date()));
    }

    @Scheduled(fixedRate = 10000)
    public void testfixedRate(){
        System.out.println("rate===="+simpleDateFormat.format(new Date()));
    }

    @Scheduled(cron = "0/100 * * * * ?")
    public void testCron() {
        System.out.println("cron====" + simpleDateFormat.format(new Date()));
    }

}
