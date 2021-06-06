package dev.bug.timer.utils;

import dev.bug.timer.info.TimerInfo;
import org.quartz.*;

import java.time.Instant;
import java.util.Date;

public final class TimerUtils {

    private TimerUtils() {
    }

    public static JobDetail buildJobDetails(Class<? extends Job> jobType, TimerInfo info) {
        var jobDataMap = new JobDataMap();
        jobDataMap.put(jobType.getSimpleName(), info);
        return JobBuilder
                .newJob(jobType)
                .withIdentity(jobType.getSimpleName())
                .setJobData(jobDataMap)
                .build();
    }

    public static Trigger buildTrigger(Class<? extends Job> jobType, TimerInfo info) {
        var builder = SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(info.getRepeatIntervalMs());
        builder = (info.isRunForever())
                ? builder.repeatForever()
                : builder.withRepeatCount(info.getTotalFireCount() - 1);
        return TriggerBuilder
                .newTrigger()
                .withIdentity(jobType.getSimpleName())
                .withSchedule(builder)
                .startAt(Date.from(Instant.ofEpochMilli(System.currentTimeMillis() + info.getInitialOffsetMs())))
                .build();
    }
}
