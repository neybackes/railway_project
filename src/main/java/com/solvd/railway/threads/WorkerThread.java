package com.solvd.railway.threads;


import com.solvd.railway.generics.Printer;


public class WorkerThread extends Thread {

    Printer<String> logsPrinter = new Printer<>();

    public WorkerThread(String nome) {
        super(nome);

    }
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            logsPrinter.info(getName() + " - WorkerThread -" + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logsPrinter.error(getName() + " \n" + "interrupted.");
                return;
            }
        }
    }
}

