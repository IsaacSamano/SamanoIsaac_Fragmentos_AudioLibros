package net.ivanvega.fragmentosdinamicos;

import android.content.Context;

import java.util.Locale;
import java.util.Vector;

public class AdaptadorLibrosFiltro extends MiAdaptadorPersonalizado{

    private Vector<Libro> vectorSinFiltro;
    private Vector<Integer> indiceFiltro;

    private String busqueda ="";
    private String genero = "";
    private boolean novedad = false;
    private boolean leido = false;

    private MiAdaptadorPersonalizado adaptador;

    public AdaptadorLibrosFiltro(Context ctx, Vector<Libro> libros) {
        super(ctx, libros);
        vectorSinFiltro = libros;
        recalcularFiltro();
    }

    public void setBusqueda (String busqueda) {
        this.busqueda = busqueda.toLowerCase();
        recalcularFiltro();
    }


    public void setGenero(String genero) {
        this.genero = genero;
        recalcularFiltro();
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
        recalcularFiltro();
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
        recalcularFiltro();
    }

    public void recalcularFiltro() {
        libros = new Vector<Libro>();
        indiceFiltro = new Vector<Integer>();
        for (int i = 0; i < vectorSinFiltro.size(); i ++){
            Libro libro = vectorSinFiltro.elementAt(i);
            if ((libro.getTitulo().toLowerCase().contains(busqueda) ||
                    libro.getAutor().toLowerCase().contains(busqueda)) &
                    (libro.getGenero().startsWith(genero)) && (!novedad ||
                    (novedad && libro.getNovedad())) && (!leido || (leido &&libro.getLeido()))) {
                        libros.add(libro);
                        indiceFiltro.add(i);
            }
        }
    }

    public Libro getItem (int posicion) {
        return vectorSinFiltro.elementAt(indiceFiltro.elementAt(posicion));
    }

    public long getItemId (int posicion){
        return indiceFiltro.elementAt(posicion);
    }

    public void borrar (int posicion) {
        vectorSinFiltro.remove((int)getItemId(posicion));
        recalcularFiltro();
    }

    public void insertar(Libro libro){
        vectorSinFiltro.add(libro);
        recalcularFiltro();
    }

    public MiAdaptadorPersonalizado getAdaptador() {
        return adaptador;
    }
}
