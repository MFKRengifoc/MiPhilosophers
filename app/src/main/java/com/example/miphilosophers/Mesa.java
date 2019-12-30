package com.example.miphilosophers;

import java.util.ArrayList;

class Mesa extends Thread {

    ArrayList<Palillo> palillos = new ArrayList<>();

    public Mesa() {
        fillPalillos();
    }

    public ArrayList<Palillo> getPalillos() {
        return palillos;
    }

    public void setPalillos(ArrayList<Palillo> palillos) {
        this.palillos = palillos;
    }

    public void fillPalillos() {
        for (int i = 0; i < 5; i++) {
            this.palillos.add(new Palillo());
        }
    }

    @Override
    public void run() {
        while (true) {

        }
    }

}