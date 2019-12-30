package com.example.miphilosophers;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/*

* @Autor: Santiago Rengifo De La Cruz
* @anio: 2019
* @clase: Dispositivos/DAM
*
* */

class Mesero extends Thread {

    Mesa mesa;
    ArrayList<Filosofo> comensalesComiendo = new ArrayList<>();
    ArrayList<Filosofo> comensalesEsperando = new ArrayList<>();
    Semaphore permiso;

    public Mesero() {
        this.permiso = new Semaphore(0);
    }

    public void pasar() {
        try {
            this.permiso.acquire();
        } catch (Exception e) {
        }
    }

    public void sentarEnMesa(Filosofo filosofo) {
        this.comensalesEsperando.add(filosofo);
    }

    public void ponerMesa(Mesa m) {
        this.mesa = m;
    }

    @Override
    public void run() {
        System.out.println("Bienvenidos caballeros, tienen 10 seg para comer y pensar...");
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("Mec al presentar...");
        }
        long init = System.currentTimeMillis();
        while (true) {
            long ac = System.currentTimeMillis();
            if (ac - init > 11000) {
                for (int i = 0; i < this.comensalesEsperando.size(); i++) {
                    Filosofo filo = this.comensalesEsperando.get(i);
                    filo.setActivo(false);
                }
                break;
            }
            for (int i = 0; i < this.comensalesEsperando.size(); i++) {
                Filosofo filo = this.comensalesEsperando.get(i);
                if (filo.getState() == Thread.State.NEW) {
                    filo.start();
                }
            }
        }
        for (int i = 0; i < this.comensalesEsperando.size(); i++) {
            Filosofo filo = this.comensalesEsperando.get(i);
            System.out.println(filo.getNombre() + " comio: " + filo.getVc());
        }
    }

}