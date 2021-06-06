package dev.bug.timer.services;

import dev.bug.timer.info.TimerInfo;
import dev.bug.timer.utils.TimerUtils;
import org.quartz.Job;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class SchedulerService {

    private static final Logger LOG = LoggerFactory.getLogger(SchedulerService.class);

    private final Scheduler scheduler;

    @Autowired
    public SchedulerService(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void schedule(Class<? extends Job> jobType, TimerInfo info) {
        var jobDetail = TimerUtils.buildJobDetails(jobType, info);
        var trigger = TimerUtils.buildTrigger(jobType, info);
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @PostConstruct
    public void init() {
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @PreDestroy
    public void destroy() {
        try {
            scheduler.shutdown();
        } catch (SchedulerException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
