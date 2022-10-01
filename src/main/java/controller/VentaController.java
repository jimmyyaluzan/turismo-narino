package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;

import beans.Venta;
import connection.DBConnection;

public class VentaController implements IVentaController {

    @Override
    public String listarVentas(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select l.id, l.sitio, l.clima, l.novedad, a.fecha from lugares l "
                + "inner join venta a on l.id = a.id inner join usuarios u on a.username = u.username "
                + "where a.username = '" + username + "'";

        List<String> ventas = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String sitio = rs.getString("sitio");
                String clima = rs.getString("clima");
                boolean novedad = rs.getBoolean("novedad");
                Date fechaVenta = rs.getDate("fecha");

                Venta venta = new Venta(id,sitio, fechaVenta, novedad,clima,sitio);

                ventas.add(gson.toJson(venta));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return gson.toJson(ventas);
    }
}

