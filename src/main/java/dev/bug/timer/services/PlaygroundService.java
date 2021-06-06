package dev.bug.timer.services;

import dev.bug.timer.info.TimerInfo;
import dev.bug.timer.jobs.HelloWorldJob;
import org.springframework.stereotype.Service;

@Service
public class PlaygroundService {

    private final SchedulerService schedulerService;

    public PlaygroundService(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    public void runHelloWorldJob() {
        var info = new TimerInfo();
        info.setTotalFireCount(5);
        info.setRepeatIntervalMs(2000);
        info.setInitialOffsetMs(1000);
        info.setCallbackData("Callback data");
        schedulerService.schedule(HelloWorldJob.class, info);
    }
}
