/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.carrent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nueva
 */
public class Añadir {
    
    public void añadirSucursal(String id_sucursal, String ciudad, String direccion){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into Sucursal (id_sucursal, ciudad, direccion) values (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, id_sucursal);
            ps.setString(2, ciudad);
            ps.setString(3, direccion);

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Sucursal añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    
    public void añadirEmpleados(String cedula, String nombre, String apellido, String id_sucursal){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into Empleados (cedula, nombre, apellido,id_sucursal) values (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, id_sucursal);

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Empleado añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }   
    
    
    public void añadirCliente(String id_cliente, boolean aprobado){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into Cliente (id_cliente, aprobado) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, id_cliente);
            ps.setBoolean(2, aprobado);
 

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Cliente añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirContratos(String noContrato, String idSucursal, String idCliente, 
                                    String tipoContrato, java.sql.Date fechaEmision, 
                                    boolean seguro, boolean estado, 
                                    String kmEstablecidos, java.sql.Date diaPago){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into Contratos (noContrato, idSucursal, idCliente, tipoContrato, "
                         + "fechaEmision, seguro, estado, kmEstablecidos, diaPago) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, noContrato);
            ps.setString(2, idSucursal);
            ps.setString(3, idCliente);
            ps.setString(4, tipoContrato);
            ps.setDate(5, fechaEmision);
            ps.setBoolean(6, seguro);
            ps.setBoolean(7, estado);
            ps.setString(8, kmEstablecidos);
            ps.setDate(9, diaPago);
 

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Contrato añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirOrdenCompra(String idOrdenCompra, String idAnexo,
                                       java.sql.Date fechaEmision, String estado,
                                       java.sql.Date fechaEntrega, double monto,
                                       String concecionaria){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into Orden_Compra (idOrdenCompra, idAnexo, fechaEmision, estado, "
                    + "fechaEntrega, monto, concecionaria) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, idOrdenCompra);
            ps.setString(2, idAnexo);
            ps.setDate(3, fechaEmision);
            ps.setString(4, estado);
            ps.setDate(5, fechaEntrega);
            ps.setDouble(6, monto);
            ps.setString(7, concecionaria);
            
 

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("OrdenCompra añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirVehiculo(String placa, String idAnexo, String idOrdenCompra,
                                    String modelo, String marca, String chasis,
                                    String tipoVehiculo, double kilometraje,
                                    java.sql.Date anio, String ramv,
                                    String estado, double pvp){
    
    }
    
    public void añadirAnexo(String idAnexo, String noContrato,
                                java.sql.Date fechaInicio, String tipoUsoOperativo,
                                java.sql.Date fechaFin, double costo){
    
    }
    
    public void añadirServicio(String idServicio, java.sql.Date fecha, double costo, String lugar){
    
    }
    
    public void añadirFactura(String noFactura, java.sql.Date fechaEmision,
                                  String estadoPago, java.sql.Date fechaPago,
                                  double monto, String metodoPago){
    
    }
    
    
    
    
}
