package com.github.diegolovison.coordinatedomission;

import org.HdrHistogram.Histogram;

import java.util.concurrent.TimeUnit;

public class MeasureLatency {

    private static final String REPORT_MESSAGE =
            "Latency measured : \n" +
                " %d operations\n" +
                " %.2f us for average latency\n" +
                " %.2f us for min latency\n" +
                " %.2f us for 50 percentile\n" +
                " %.2f us for 90 percentile\n" +
                " %.2f us for 99 percentile\n" +
                " %.2f us for 99.9 percentile\n" +
                " %.2f us for 99.99 percentile\n" +
                " %.2f us for max latency\n";

    private Histogram hdrHistogram;
    private int tests;
    private long rate;
    private boolean coordinatedOmission;

    public MeasureLatency() {
        this.hdrHistogram = new Histogram(TimeUnit.MINUTES.toNanos(1), 2);
    }

    public MeasureLatency configure(int targetThroughput, boolean coordinatedOmission) {
        this.coordinatedOmission = coordinatedOmission;
        this.tests = Math.min(120 * targetThroughput, 10_000_000);
        this.rate = (long) (1e9 / targetThroughput);
        return this;
    }

    public MeasureLatency measure() throws InterruptedException {
        long now = System.nanoTime();
        for (int i = 0; i < this.tests; i++) {
            if (this.coordinatedOmission)
                now = System.nanoTime();
            now += this.rate;
            while (System.nanoTime() < now)

            Thread.sleep((long) Math.random() * 10);

            observe(System.nanoTime() - now);
        }

        return this;
    }

    public String generateReportAndReset() {
        String message = String.format(REPORT_MESSAGE,
                this.hdrHistogram.getTotalCount(),
                us(this.hdrHistogram.getMean()),
                us(this.hdrHistogram.getMinValue()),
                us(this.hdrHistogram.getValueAtPercentile(50)),
                us(this.hdrHistogram.getValueAtPercentile(90)),
                us(this.hdrHistogram.getValueAtPercentile(99)),
                us(this.hdrHistogram.getValueAtPercentile(99.9)),
                us(this.hdrHistogram.getValueAtPercentile(99.99)),
                us(this.hdrHistogram.getMaxValue())
        );
        this.hdrHistogram.reset();
        return message;
    }

    private void observe(long time) {
        this.hdrHistogram.recordValue(time);
    }

    private static double us(double d) {
        return d / 1e3;
    }
}
