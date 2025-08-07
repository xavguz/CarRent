/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.carrent;

import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 *
 * @author Nue
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
    
    
    public void añadirEmpleados(String cedula, String nombre, String apellido, String cargo, String id_sucursal){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into Empleados (cedula, nombre, apellido,id_sucursal) values (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, cargo);
            ps.setString(5, id_sucursal);

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Empleado añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }   
    
    
    public void añadirCliente(String id_cliente){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into Cliente (id_cliente) values (?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, id_cliente);

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
            
            String sql = "insert into Contrato (noContrato, id_sucursal, id_cliente, tipo_contrato, "
                         + "fecha_emision, seguro, estado, km_establecidos, dia_pago) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            
            String sql = "insert into Orden_Compra (id_orden_compra, id_anexo, fecha_emision, estado, "
                    + "fecha_entrega, monto, concecionaria) values (?, ?, ?, ?, ?, ?, ?)";
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
                                    java.sql.Date año, String ramv,
                                    String estado, double pvp){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into Vehiculos (placa, id_anexo, id_orden_compra, modelo, "
                    + "marca, chasis, tipo_vehiculo, kilometraje, año, ramv, estado, pvp) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
                System.out.println("Vehiculo añadida correctamente.");
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
            
            String sql = "insert into Anexo (id_anexo, noContrato, fecha_inicio, tipo_uso_operativo, "
                    + "fecha_fin, costo) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, idAnexo);
            ps.setString(2, noContrato);
            ps.setDate(3, fechaInicio);
            ps.setString(4, tipoUsoOperativo);
            ps.setDate(5, fechaFin);
            ps.setDouble(6, costo);

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Anexo añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirServicio(String idServicio, java.sql.Date fecha, double costo, String lugar){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into Servicios (id_servicio, fecha, costo, lugar) values (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, idServicio);
            ps.setDate(2, fecha);
            ps.setDouble(3, costo);
            ps.setString(4, lugar);

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Servicio añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirFactura(String noFactura, java.sql.Date fechaEmision,
                                  String estadoPago, java.sql.Date fechaPago,
                                  double monto, String metodoPago){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into Factura (noFactura, fecha_emision, estado_pago, fecha_pago, "
                    + "monto, metodo_pago) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, noFactura);
            ps.setDate(2, fechaEmision);
            ps.setString(3, estadoPago);
            ps.setDate(4, fechaPago);

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Factura añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirClienteNatural(String id_cliente, String cedula, String nombre, String apellido){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into cliente_natural (id_cliente, cedula, nombre, apellido) values (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, id_cliente);
            ps.setString(2, cedula);
            ps.setString(3, nombre);
            ps.setString(4, apellido);

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("ClienteNatural añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirClienteEmpresa(String id_cliente, String RUC, String nombreEmpresa){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into cliente_empresa (id_cliente, RUC, nombreEmpresa) values (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, id_cliente);
            ps.setString(2, RUC);
            ps.setString(3, nombreEmpresa);

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("ClienteEmpresa añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirModificacion(String idModificacion, String tipo){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into Modificaciones (id_servicio_modificacion, tipo_modificacion) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, idModificacion);
            ps.setString(2, tipo);

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Modificacion añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirMantenimiento(String idMantemiento, String causa){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into Mantenimientos (id_servicio_mantemiento, causa) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, idMantemiento);
            ps.setString(2, causa);

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("Mantenimiento añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirVehiculoServicio(String placa, String idServicio){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into vehiculo_servicios (placa, id_servicio) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, placa);
            ps.setString(2, idServicio);

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("VehiculoServicio añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirMulta(String id_multa, String id_cliente, java.sql.Date fecha, String causa, Double costo){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into Multa (id_multa, id_cliente, fecha, causa, costo) values (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, id_cliente);
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
    
    public void añadirFacturaRecibida(String noContrato, String idOrdenCompra){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into factura_recibida (noFactura, id_orden_compra) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, noContrato);
            ps.setString(2, idOrdenCompra);

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("FacturaRecibida añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirFacturaEmitida(String noFactura, String idAnexo, String idMulta ) {
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into factura_emitida (noFactura, id_anexo, id_multa) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, noFactura);
            ps.setString(2, idAnexo);
            ps.setString(3, idMulta);

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("FacturaEmitida añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    
    
    
    }
    
    public void añadirFacturaRecibidaServicio(String noContrato, String idServicio ){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into FacturaRecibidaServicio (noFactura, id_servicio) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, noContrato);
            ps.setString(2, idServicio);

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("FacturaRecibidaServicio añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirCorreoCliente(String id_cliente, String correo){
        try {
            Connection conn = DBconnection.getInstance().getConnection();

            String sql = "insert into correo_cliente (id_cliente, correo) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);


            ps.setString(1, id_cliente);
            ps.setString(2, correo);

            int insert = ps.executeUpdate();

            if (insert > 0) {
                System.out.println("CorreoCliente añadida correctamente.");
            }

        } catch (Exception  e) {
            e.printStackTrace();
        }

    }

    public void añadirCorreoEmpleado(String cedula, String correo){
        try {
            Connection conn = DBconnection.getInstance().getConnection();

            String sql = "insert into correo_empleado (cedula, correo) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);


            ps.setString(1, cedula);
            ps.setString(2, correo);

            int insert = ps.executeUpdate();

            if (insert > 0) {
                System.out.println("CorreoCliente añadida correctamente.");
            }

        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
    
    public void añadirTelefenosEmpleados(String cedula, String noTelefono){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into telefono_empleado (cedula, telefono) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, cedula);
            ps.setString(2, noTelefono);

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("TelefenosEmpleado añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
   
    }
    
    public void añadirTelefenosCliente(String id_cliente, String noTelefono){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "insert into telefono_cliente (id_cliente, telefono) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, id_cliente);
            ps.setString(2, noTelefono);

            int insert = ps.executeUpdate();
            
            if (insert > 0) {
                System.out.println("TelefenosCliente añadida correctamente.");
            }
            
        } catch (Exception  e) {
            e.printStackTrace();
        }
   
    }

}
