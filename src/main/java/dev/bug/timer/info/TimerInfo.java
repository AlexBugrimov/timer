package dev.bug.timer.info;

public class TimerInfo {

    private int totalFireCount;
    private boolean runForever;
    private long repeatIntervalMs;
    private long initialOffsetMs;
    private String callbackData;

    public int getTotalFireCount() {
        return totalFireCount;
    }

    public TimerInfo setTotalFireCount(int totalFireCount) {
        this.totalFireCount = totalFireCount;
        return this;
    }

    public boolean isRunForever() {
        return runForever;
    }

    public TimerInfo setRunForever(boolean runForever) {
        this.runForever = runForever;
        return this;
    }

    public long getRepeatIntervalMs() {
        return repeatIntervalMs;
    }

    public TimerInfo setRepeatIntervalMs(long repeatIntervalMs) {
        this.repeatIntervalMs = repeatIntervalMs;
        return this;
    }

    public long getInitialOffsetMs() {
        return initialOffsetMs;
    }

    public TimerInfo setInitialOffsetMs(long initialOffsetMs) {
        this.initialOffsetMs = initialOffsetMs;
        return this;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public TimerInfo setCallbackData(String callbackData) {
        this.callbackData = callbackData;
        return this;
    }
}
