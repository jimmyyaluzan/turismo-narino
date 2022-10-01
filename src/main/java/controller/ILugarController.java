package controller;

public interface ILugarController {

    public String listar(boolean ordenar, String orden);
    public String vender(int id, String username);
    public String modificar(int id);
    public String devolver(int id,String username);
    public String sumarCantidad(int id);

  

}
