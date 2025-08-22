package ec.edu.espol.carrent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Eliminar {
    public void eliminarCliente(String id){
        String sql = "CALL sp_eliminarCliente(?)" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarVehiculo(String id){
        String sql = "CALL sp_eliminarVechiulo(?)" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarAnexo(String id){
        String sql = "CALL sp_eliminarAnexo(?)" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarFactura(String id){
        String sql = "CALL sp_eliminarFactura(?)" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarSucursal(String id){
        String sql = "CALL sp_eliminarSucursal(?)" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarContrato(String id){
        String sql = "CALL sp_eliminarContrato(?)" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarOrdenDeCompra(String id){
        String sql = "CALL sp_eliminarOrdenCompra(?)" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarEmpleado(String id){
        String sql = "CALL sp_eliminarEmpleado(?)" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarMulta(String id){
        String sql = "CALL sp_eliminarMulta(?)" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarServicio(String id){
        String sql = "CALL sp_eliminarServicio(?)" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarModificacion(String id){
        String sql = "CALL sp_eliminarModificacion(?)" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarMantenimiento(String id){
        String sql = "CALL sp_eliminarMantenimientos(?)" ;
        ejecutarEliminacion(sql , id);
    }
    
    private void ejecutarEliminacion(String sql, String id) {
        try {
            Connection con = DBconnection.getInstance().getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.execute();
      
            System.out.println("Datos eliminados correctamente.");
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar el registro: " + e.getMessage());
        }
    }
    
}
