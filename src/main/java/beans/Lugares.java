/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;


public class Lugares {
    private int id;
    private String sitio;
    private String clima;
    private int viajes;
    private boolean novedad;

    public Lugares(int id, String sitio, String clima, int viajes, boolean novedad) {
        this.id = id;
        this.sitio = sitio;
        this.clima = clima;
        this.viajes= viajes;
        this.novedad = novedad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    

    

    public int getViajes() {
        return viajes;
    }

    public void setViajes(int viajes) {
        this.viajes = viajes;
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    @Override
    public String toString() {
        return "Lugares{" + "id=" + id + ",sitio=" + sitio+ ", clima=" + clima + ", viajes=" + viajes + ", novedad=" + novedad + '}';
    }
    
    
    
}
