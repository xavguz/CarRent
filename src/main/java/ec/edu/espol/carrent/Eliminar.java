package ec.edu.espol.carrent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Eliminar {
    public void eliminarCliente(String id){
        String sql = "DELETE FROM Cliente WHERE id_cliente = ?" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarVehiculo(String id){
        String sql = "DELETE FROM Vehiculos WHERE placa = ?" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarAnexo(String id){
        String sql = "DELETE FROM Anexo WHERE id_anexo = ?" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarFactura(String id){
        String sql = "DELETE FROM Factura WHERE noFactura = ?" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarSucursal(String id){
        String sql = "DELETE FROM Sucursal WHERE id_sucursal = ?" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarContrato(String id){
        String sql = "DELETE FROM Contrato WHERE noContrato = ?" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarOrdenDeCompra(String id){
        String sql = "DELETE FROM Orden_Compra WHERE id_orden_compra = ?" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarEmpleado(String id){
        String sql = "DELETE FROM Empleados WHERE cedula = ?" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarMulta(String id){
        String sql = "DELETE FROM Multa WHERE id_multa = ?" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarServicio(String id){
        String sql = "DELETE FROM Servicios WHERE id_servicio = ?" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarModificacion(String id){
        String sql = "DELETE FROM Modificaciones WHERE id_servicio_modificacion = ?" ;
        ejecutarEliminacion(sql , id);
    }
    public void eliminarMantenimiento(String id){
        String sql = "DELETE FROM Mantenimientos WHERE id_servicio_mantenimiento = ?" ;
        ejecutarEliminacion(sql , id);
    }
    
    private void ejecutarEliminacion(String sql, String id) {
        try {
            Connection con = DBconnection.getInstance().getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            int filas = stmt.executeUpdate();
 
            if (filas > 0) {
                System.out.println("Cliente eliminado correctamente.");
            } else {
                System.out.println("No se encontró un cliente con ese ID.");
            }

            stmt.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        }
    }
    
}
