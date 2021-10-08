package net.ivanvega.fragmentosdinamicos;

import android.annotation.SuppressLint;
import android.app.Application;

import java.util.Vector;

public class Aplicacion extends Application {
    private Vector <Libro> vectorLibros;
    private MiAdaptadorPersonalizado adaptador;



    @Override
    public void onCreate () {
        super.onCreate();
        vectorLibros = Libro.ejemplosLibros();
        adaptador = new MiAdaptadorPersonalizado(this, vectorLibros);
    }

    public Vector<Libro> getVectorLibros() {
        return vectorLibros;
    }

    public MiAdaptadorPersonalizado getAdaptador() {
        return adaptador;
    }
}


