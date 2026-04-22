package com.solvd.railway.threads;

import com.solvd.railway.generics.Printer;

public class WorkerTask implements Runnable {

    Printer<String> logsPrinter = new Printer<>();

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        for (int i = 1; i <= 10; i++) {
            logsPrinter.info(threadName + " - " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logsPrinter.error(threadName + " interrupted.");
                return;
            }
        }
    }
}
