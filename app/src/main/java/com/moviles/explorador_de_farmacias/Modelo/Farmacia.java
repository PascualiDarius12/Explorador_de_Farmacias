package com.moviles.explorador_de_farmacias.Modelo;

import com.google.android.gms.maps.model.LatLng;
import com.moviles.explorador_de_farmacias.R;

import java.io.Serializable;
import java.util.ArrayList;

public class Farmacia implements Serializable {
    private String Nombre;
    private String Direccion;
    private LatLng location;
    private String horaApertura;
    private String horaCierre;
    private int foto;

    public Farmacia() {
    }

    public Farmacia(String nombre, String direccion, LatLng location, String horaApertura, String horaCierre, int foto) {
        Nombre = nombre;
        Direccion = direccion;
        this.location = location;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.foto = foto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public String getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    public String getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public ArrayList<Farmacia> getFarmacias(){


        ArrayList<Farmacia> listaFarmacias = new ArrayList<>();


        Farmacia farmacia1 = new Farmacia("Farmacia Santa Rita","Av. Juan Gilberto Funes 660, D5702GWJ San Luis",
                new LatLng(-33.309799014949434, -66.33002180217798),"8 a.m","8 p.m", R.drawable.foto1);
        listaFarmacias.add(farmacia1);
        Farmacia farmacia2 = new Farmacia("Farmacia Del Bosque","Salvador Segado 800, San Luis",
                new LatLng(-33.31568082956788, -66.32817523467192),"8 a.m","8 p.m", R.drawable.foto2);
        listaFarmacias.add(farmacia2);
        Farmacia farmacia3 = new Farmacia("Farmacia Los Alamos","Playa GNC Del Valle, Av. Lafinur 15 Local interno, D5700 San Luis",
                new LatLng(-33.31117752024916, -66.34431232721073),"8 a.m","8 p.m", R.drawable.foto3);
        listaFarmacias.add(farmacia3);
        Farmacia farmacia4 = new Farmacia("Farmacity","Rivadavia 602, D5702 San Luis",
                new LatLng(-33.303466863350174, -66.33560107932409),"8 a.m","8 p.m", R.drawable.foto4);
        listaFarmacias.add(farmacia4);
        Farmacia farmacia5 = new Farmacia("Farmacia San Benito","José F. Franco 110, San Luis",
                new LatLng(-33.28187517655633, -66.30536417543502),"8 a.m","8 p.m", R.drawable.foto5);
        listaFarmacias.add(farmacia5);
        Farmacia farmacia6 = new Farmacia("Farmacia San Isidro","Av. Pte. Juan Domingo Perón 1028, D5700CLT San Luis",
                new LatLng(-33.29582503468993, -66.32733783957852),"8 a.m","8 p.m", R.drawable.foto6);
        listaFarmacias.add(farmacia6);
        Farmacia farmacia7 = new Farmacia("Farmacia San Luis","Rivadavia 1052, D5700 San Luis",
                new LatLng(-33.29762670929584, -66.33757309556398),"8 a.m","8 p.m", R.drawable.foto7);

        listaFarmacias.add(farmacia7);

        return listaFarmacias;
    }

}
