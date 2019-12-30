package com.example.miphilosophers;

import java.util.concurrent.Semaphore;

class Palillo extends Thread {
    Semaphore ocupado;

    public Palillo() {
        ocupado = new Semaphore(1);
    }

    public void coger() {
        try {
            this.ocupado.acquire();
        } catch (InterruptedException ex) {
            System.out.println("Mec al coger palillo...");
        }
    }

    public void soltar() {
        this.ocupado.release();
    }

    public Semaphore getOcupado() {
        return this.ocupado;
    }
}