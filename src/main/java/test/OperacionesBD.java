/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import beans.Lugares;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;


public class OperacionesBD {
    
    public static void main(String[] args) {
       // listarLugares();
        actualizarLugar(1, "Caliente");
        
    }
    public static void actualizarLugar(int id, String clima){
        DBConnection con = new DBConnection();
        String sql = "UPDATE lugares SET clima = '"+clima+"' WHERE id = "+id;
        
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            con.desconectar();
        }
    }
    
    public static void listarLugares(){
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM lugares";
        
         try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String sitio = rs.getString("sitio");
                String clima = rs.getString("clima");
                int viajes = rs.getInt("viajes");
                boolean novedad = rs.getBoolean("novedad");
                
                Lugares lugares = new Lugares(id, sitio, clima,viajes, novedad);
                System.out.println(lugares.toString());
            }
            st.executeQuery(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
         finally{
             con.desconectar();
         }
        
    }
    
}
