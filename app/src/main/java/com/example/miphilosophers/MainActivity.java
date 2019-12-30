package com.example.miphilosophers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.invoke.ConstantCallSite;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class MainActivity extends AppCompatActivity {
    public void setColor(int id){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout c = (ConstraintLayout) findViewById(R.id.main);
        Mesa m1 = new Mesa();
        String[] nombres = {"Descartes", "Nietzche", "Ortega", "Platon", "Lock"};
        int[] ids = {R.id.descartes,R.id.nietzche,R.id.ortega,R.id.platon,R.id.lock};
        Mesero mesero = new Mesero();
        ArrayList<Filosofo> filosofos = new ArrayList<>();
        for (int i = 0; i < nombres.length; i++) {
            if (i == nombres.length - 1) {
                Filosofo filo = new Filosofo(ids[i],nombres[i], m1.getPalillos().get(i), m1.getPalillos().get(0), this);
                filosofos.add(filo);
                mesero.sentarEnMesa(filo);
            } else {
                Filosofo filo = new Filosofo(ids[i],nombres[i], m1.getPalillos().get(i), m1.getPalillos().get(i + 1), this);
                filosofos.add(filo);
                mesero.sentarEnMesa(filo);
            }
        }
        mesero.start();
    }
}




