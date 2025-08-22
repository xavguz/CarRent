/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.carrent;

import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 *
 * @author Nueva
 */
public class Añadir {
    public void añadirSucursal(String id_sucursal, String ciudad, String direccion){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "call ingresarSucursal(?, ?, ?)";
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
    
    public void añadirEmpleado(String id_sucursal, String cedula,  String nombre, 
            String apellido, String cargo, String correo, String telefono){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "call ingresarEmpleado(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, id_sucursal);
            ps.setString(2, cedula);
            ps.setString(3, nombre);
            ps.setString(4, apellido);
            ps.setString(5, cargo);
            ps.setString(6, correo);
            ps.setString(7, telefono);

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Empleado añadido correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirClienteNatural(String idCliente, String cedula,  String nombre, 
            String apellido, String correo, String telefono){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "call ingresarClienteNatural(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, idCliente);
            ps.setString(2, cedula);
            ps.setString(3, nombre);
            ps.setString(4, apellido);
            ps.setString(5, telefono);
            ps.setString(6, correo);

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Cliente añadido correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirClienteEmpresa(String id_cliente, String RUC, String nombreEmpresa, 
            String correo, String telefono){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "call ingresarClienteEmpresa(?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, id_cliente);
            ps.setString(2, RUC);
            ps.setString(3, nombreEmpresa);
            ps.setString(4, telefono);
            ps.setString(5, correo);

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Cliente añadido correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirContrato(String noContrato, String idSucursal, String idCliente, 
                                    String tipoContrato, java.sql.Date fechaEmision, 
                                    boolean seguro, boolean estado, 
                                    String kmEstablecidos, java.sql.Date diaPago){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "call ingresarContrato(?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
                System.out.println("Contrato añadido correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirAnexo(String idAnexo, String noContrato,
                                java.sql.Date fechaInicio, String tipoUsoOperativo,
                                java.sql.Date fechaFin, double costo){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "call ingresarAnexo(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, idAnexo);
            ps.setString(2, noContrato);
            ps.setDate(3, fechaInicio);
            ps.setString(4, tipoUsoOperativo);
            ps.setDate(5, fechaFin);
            ps.setDouble(6, costo);
 
            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Anexo añadido correctamente.");
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
            
            String sql = "call ingresarOrdenCompra(?, ?, ?, ?, ?, ?, ?)";
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
                System.out.println("Orden de compra añadido correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirVehiculo(String placa, String idAnexo, String idOrdenCompra,
                                    String modelo, String marca, String chasis,
                                    String tipoVehiculo, double kilometraje,
                                    java.sql.Date año, String ramv,
                                    String estado, double pvp){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "call ingresarVehiculo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, placa);
            ps.setString(2, idAnexo);
            ps.setString(3, idOrdenCompra);
            ps.setString(4, modelo);
            ps.setString(5, marca);
            ps.setString(6, chasis);
            ps.setString(7, tipoVehiculo);
            ps.setDouble(8, kilometraje);
            ps.setDate(9, año);
            ps.setString(10, ramv);
            ps.setString(11, estado);
            ps.setDouble(12, pvp);
 
            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Vehiculo añadido correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirModificacion(String placa, String idServicio, java.sql.Date fecha, double costo, 
            String lugar, String tipo){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "call ingresarModificacion(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, placa);
            ps.setString(2, idServicio);
            ps.setDate(3, fecha);
            ps.setDouble(4, costo);
            ps.setString(5, lugar);
            ps.setString(6, tipo);
 
            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Orden de compra añadido correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirMantenimiento(String placa, String idServicio, java.sql.Date fecha, double costo, 
            String lugar, String causa ){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "call ingresarMantemiento(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, placa);
            ps.setString(2, idServicio);
            ps.setDate(3, fecha);
            ps.setDouble(4, costo);
            ps.setString(5, lugar);
            ps.setString(6, causa);
 
            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Mantenimiento añadido correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirMulta(String id_multa, String id_cliente, java.sql.Date fecha, 
            String causa, Double costo){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "call ingresarMulta(?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, id_multa);
            ps.setString(2, id_cliente);
            ps.setDate(3, fecha);
            ps.setString(4, causa);
            ps.setDouble(5, costo);
 
            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Multa añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirFacturaOrdenCompra(String noFactura, java.sql.Date fechaEmision,
                                  String estadoPago, java.sql.Date fechaPago,
                                  double monto, String metodoPago, String idOrdenCompra){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "call ingresarFacturaOrdenCompra(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, noFactura);
            ps.setDate(2, fechaEmision);
            ps.setString(3, estadoPago);
            ps.setDate(4, fechaPago);
            ps.setDouble(5, monto);
            ps.setString(6, metodoPago);
            ps.setString(7, idOrdenCompra);
 
            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Factura añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirFacturaServicio(String noFactura, java.sql.Date fechaEmision,
                                  String estadoPago, java.sql.Date fechaPago,
                                  double monto, String metodoPago, String idServicio){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "call ingresarFacturaServicio(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, noFactura);
            ps.setDate(2, fechaEmision);
            ps.setString(3, estadoPago);
            ps.setDate(4, fechaPago);
            ps.setDouble(5, monto);
            ps.setString(6, metodoPago);
            ps.setString(7, idServicio);
 
            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Factura añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirFacturaEmitida(String noFactura, java.sql.Date fechaEmision,
                                  String estadoPago, java.sql.Date fechaPago,
                                  double monto, String metodoPago, String idAnexo, String idMulta){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "call ingresarFacturaEmitida(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, noFactura);
            ps.setDate(2, fechaEmision);
            ps.setString(3, estadoPago);
            ps.setDate(4, fechaPago);
            ps.setDouble(5, monto);
            ps.setString(6, metodoPago);
            ps.setString(7, idAnexo);
            ps.setString(8, idMulta);
 
            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Factura añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
}
