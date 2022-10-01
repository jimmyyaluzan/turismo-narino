/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.sql.Date;

/**
 *
 * @author hfabi
 */
public class Venta {
    
    private int id;
    private String username;
    private Date fechaVenta;
    private boolean novedad;
    private String clima;
    private String sitio;
    public Venta(int id, String username, Date fechaVenta, boolean novedad, String clima,String sitio) {
        this.id = id;
        this.username = username;
        this.fechaVenta = fechaVenta;
        this.novedad = novedad;
        this.clima = clima;
        this.sitio = sitio;
    }

    public Venta(String sitio) {
        this.sitio = sitio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", username=" + username + ", fechaVenta=" + fechaVenta + ", novedad=" + novedad + ", clima=" + clima + '}';
    }
    
    
    
    
}
