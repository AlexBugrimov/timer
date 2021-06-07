package dev.bug.timer.jobs;

import dev.bug.timer.info.TimerInfo;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldJob implements Job {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldJob.class);

    @Override
    public void execute(JobExecutionContext context) {
        var jobDataMap = context.getJobDetail().getJobDataMap();
        var info = (TimerInfo) jobDataMap.get(HelloWorldJob.class.getSimpleName());
        LOG.info(info.getCallbackData());
    }
}
