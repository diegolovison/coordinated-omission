package com.github.diegolovison.coordinatedomission;

public class RunLatencyTest {

    private static final int[] TARGET = new int[]{200_000, 160_000, 140_000, 120_000, 100_000, 80_000, 70_000, 60_000, 50_000, 40_000, 30_000, 25_000, 20_000, 15_000, 10_000};
    private static final String MESSAGE_OUTPUT = "Starting latency test rate %d using coordinated omission: %s \n %s";

    public static void main(String[] args) throws InterruptedException {

        MeasureLatency measureLatency = new MeasureLatency();

        // warm up
        measureLatency.configure(200_000, true).measure().generateReportAndReset();
        measureLatency.configure(200_000, false).measure().generateReportAndReset();

        for (int i : TARGET)
            for (boolean t : new boolean[]{true, false})
                System.out.println(String.format(MESSAGE_OUTPUT, i, t, measureLatency.configure(i, t).measure().generateReportAndReset()));
    }
}
