package com.github.diegolovison.coordinatedomission;

import org.HdrHistogram.Histogram;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.function.Supplier;

public class MeasureLatency {

    private Histogram latencyHistogram;
    private long timeNs;
    private Supplier<Long> request;
    private long intervalNs;

    public MeasureLatency configure(long timeSec, Supplier<Long> request, int opsPerSec) {
        this.timeNs = TimeUnit.SECONDS.toNanos(timeSec);
        this.latencyHistogram = new Histogram(timeNs, 2);
        this.request = request;
        if (opsPerSec > 0) {
            this.intervalNs = 1000000000 / opsPerSec;
        }

        return this;
    }

    public MeasureLatency measure() {

        int i = 0;
        long start = System.nanoTime();
        while (true) {

            long intendedTime;
            if (this.intervalNs > 0) {
                intendedTime = start + (i++) * intervalNs;
                long now;
                while ((now = System.nanoTime()) < intendedTime)
                    LockSupport.parkNanos(intendedTime - now);
            } else {
                intendedTime = System.nanoTime();
            }

            // request
            long deadLine = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(request.get());
            long now;
            while ((now = System.nanoTime()) < deadLine)
                LockSupport.parkNanos(deadLine - now);

            if (System.nanoTime() - start < timeNs) {
                long end = System.nanoTime();
                this.latencyHistogram.recordValue(end - intendedTime);
            } else {
                break;
            }
        }

        return this;
    }

    public void generateReport() {

        System.out.println("======= Latency =======");
        System.out.println("Operations: " + latencyHistogram.getTotalCount());
        System.out.println("AverageLatency(us): " + latencyHistogram.getMean() / 1000);
        System.out.println("MinLatency(us): " + latencyHistogram.getMinValue() / 1000);
        System.out.println("MaxLatency(us): " + latencyHistogram.getMaxValue() / 1000);
        System.out.println("95thPercentileLatency(ms): " + latencyHistogram.getValueAtPercentile(90) / 1000000);
        System.out.println("99thPercentileLatency(ms): " + latencyHistogram.getValueAtPercentile(99) / 1000000);
    }
}
