package com.github.diegolovison.coordinatedomission;

public class RunLatencyTest {

    public static void main(String[] args) {

        // warm up
        new MeasureLatency().configure(10, () -> 10L, 1).measure();

        System.out.println("Coordinate Omission");
        new MeasureLatency().configure(60, () -> 4L, 0).measure().generateReport();
        System.out.println();
        System.out.println("Fix Coordinate Omission");
        new MeasureLatency().configure(60, () -> 4L, 250).measure().generateReport();
    }
}
