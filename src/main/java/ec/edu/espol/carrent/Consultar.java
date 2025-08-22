/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.carrent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.CallableStatement;

/**
 *
 * @author usuario
 */
public class Consultar {
    
    private Scanner sc = new Scanner(System.in);
    
    public void consultarAnexo(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM Anexo";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID Anexo: " + rs.getString("id_anexo") +
                               ", Nro de Contrato: " + rs.getString("noContrato") +
                               ", Fecha inicio del contrato: " + rs.getString("fecha_inicio") +
                               ", Uso operativo: " + rs.getString("tipo_uso_operativo") +
                               ", Fecha fin del contrato: " + rs.getString("fecha_fin") +
                               ", Costo: " + rs.getString("costo"));
            }
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarCliente(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM Cliente";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID Cliente: " + rs.getString("id_cliente") +
                               ", Estado: " + rs.getInt("aprobado"));
            }
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarClienteEmpresa(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM cliente_empresa";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID Cliente: " + rs.getString("id_cliente") +
                               ", RUC: " + rs.getString("RUC") +
                               ", Nombre: " + rs.getString("nombre"));
            } 
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarClienteNatural(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM cliente_natural";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID Cliente: " + rs.getString("id_cliente") +
                               ", Cedula: " + rs.getString("cedula") +
                               ", Nombre: " + rs.getString("nombre") +
                               ", Apellido: " + rs.getString("apellido"));
            } 
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarContrato(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM Contrato";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("Número de Contrato: " + rs.getString("noContrato") +
                               ", ID Sucursal: " + rs.getString("id_sucursal") +
                               ", ID Cliente: " + rs.getString("id_cliente") +
                               ", Tipo de contrato: " + rs.getString("tipo_contrato") +
                               ", Fecha de emisión: " + rs.getDate("fecha_emision") +
                               ", Seguro: " + rs.getInt("seguro") +
                               ", Estado: " + rs.getInt("estado") +
                               ", KM establecidos: " + rs.getString("km_establecidos") +
                               ", Dia de Pago: " + rs.getDate("dia_pago"));
            } 
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarCorreoCliente(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM correo_cliente";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID Cliente: " + rs.getString("id_cliente") +
                               ", Correo Electrónico: " + rs.getString("correo"));
            } 
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarCorreoEmpleado(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM correo_empleado";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("Cédula del Empleado: " + rs.getString("cedula") +
                               ", Correo Electrónico: " + rs.getString("correo"));
            } 
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarEmpleado(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM Empleados";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("Cédula del Empleado: " + rs.getString("cedula") +
                               ", Nombre del Empleado: " + rs.getString("nombre") +
                               ", Apellido del Empleado: " + rs.getString("apellido") +
                               ", Cargo del Empleado: " + rs.getString("cargo") +
                               ", ID Sucursal: " + rs.getString("id_sucursal"));
            } 
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarFactura(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM Factura";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("Número de la Factura: " + rs.getString("noFactura") +
                               ", Fecha de Emisión: " + rs.getDate("fecha_emision") +
                               ", Estado del Pago: " + rs.getString("estado_pago") +
                               ", Fecha del Pago: " + rs.getDate("fecha_pago") +
                               ", Monto del Pago: " + rs.getFloat("monto") +
                               ", Método del pago: " + rs.getString("metodo_pago"));
            } 
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarFacturaEmitida(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM factura_emitida";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("Número de la Factura: " + rs.getString("noFactura") +
                               ", ID del Anexo: " + rs.getString("id_anexo") +
                               ", ID de la Multa: " + rs.getString("id_multa"));
            } 
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarFacturaRecibida(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM factura_recibida";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("Número de la Factura: " + rs.getString("noFactura") +
                               ", ID Orden de Compra: " + rs.getString("id_orden_compra"));
            } 
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarFacturaRecibidaServicio(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM FacturaRecibidaServicio";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("Número de la Factura: " + rs.getString("noFactura") +
                               ", ID del Servicio: " + rs.getString("id_servicio"));
            } 
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarMantenimientos(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM Mantenimientos";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID Servicio Mantenimiento: " + rs.getString("id_servicio_mantemiento") +
                               ", Causa del Mantenimeinto: " + rs.getString("causa"));
            } 
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarModificaciones(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM Modificaciones";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID Servicio Modificacion: " + rs.getString("id_servicio_modificacion") +
                               ", Tipo de Modificacion: " + rs.getString("tipo_modificacion"));
            } 
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarMultas(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM Multa";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID Multa: " + rs.getString("id_multa") +
                               ", ID Cliente: " + rs.getString("id_cliente") +
                               ", Fecha de Emision de Multa: " + rs.getDate("fecha") +
                               ", Causa de la Multa: " + rs.getString("causa") +
                               ", Costo Multa: " + rs.getFloat("costo"));
            } 
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarOrdenCompra(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM Orden_Compra";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID Orden de Compra: " + rs.getString("id_orden_compra") +
                               ", ID Anexo: " + rs.getString("id_anexo") +
                               ", Fecha de Emision: " + rs.getDate("fecha_emision") +
                               ", Estado: " + rs.getString("estado") +
                               ", Fecha de Entrega: " + rs.getDate("fecha_entrega") +
                               ", Monto: " + rs.getFloat("monto") +
                               ", Concecionaria: " + rs.getString("concecionaria"));
            } 
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarServicios(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM Servicios";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID Servicio: " + rs.getString("id_servicio") +
                               ", Fecha del Servicio: " + rs.getDate("fecha") +
                               ", Costo: " + rs.getFloat("costo") +
                               ", Lugar: " + rs.getString("lugar"));
            } 
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarSucursal(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM Sucursal";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID Sucursal: " + rs.getString("id_sucursal") +
                               ", Ciudad: " + rs.getString("ciudad") +
                               ", Direccion: " + rs.getString("direccion"));
            } 
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarTelefonoCliente(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM telefono_cliente";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID Cliente: " + rs.getString("id_cliente") +
                               ", Telefono del Cliente: " + rs.getString("telefono"));
            } 
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarTelefonoEmpleado(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM telefono_empleado";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("Cedula del Empleado: " + rs.getString("cedula") +
                               ", Telefono del Empleado: " + rs.getString("telefono"));
            } 
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultarVehiculos(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "SELECT * FROM Vehiculos";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("Placa del vehiculo: " + rs.getString("placa") +
                               ", ID Anexo: " + rs.getString("id_anexo") +
                               ", ID Orden de Compra: " + rs.getString("id_orden_compra") +
                               ", Modelo: " + rs.getString("modelo") +
                               ", Marca: " + rs.getString("marca") +
                               ", Chasis: " + rs.getString("chasis") +
                               ", Tipo de Vehiculo: " + rs.getString("tipo_vehiculo") +
                               ", Kilometraje: " + rs.getFloat("kilometraje") +
                               ", Año: " + rs.getDate("año") +
                               ", RAMV: " + rs.getString("ramv") +
                               ", Estado: " + rs.getString("estado") +
                               ", Precio de Venta Público: " + rs.getFloat("pvp"));
            } 
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void repVehiculosXanio() {
    System.out.print("Ingrese el año que desea consultar: ");
    int anio = sc.nextInt();
    sc.nextLine(); // limpiar buffer

    String sql = "{ call sp_vehiculos_alquilados_por_anio(?) }"; // usa el nombre real de tu SP

    try (Connection conn = DBconnection.getInstance().getConnection();
         CallableStatement cs = conn.prepareCall(sql)) {

        cs.setInt(1, anio);
        ResultSet rs = cs.executeQuery();

        System.out.println("===== VEHÍCULOS ALQUILADOS EN EL AÑO " + anio + " =====");
        while (rs.next()) {
            System.out.println(
                "Cliente ID: " + rs.getInt("id_cliente") +
                " | Modelo: " + rs.getString("modelo") +
                " | Tipo: " + rs.getString("tipo_vehiculo") +
                " | Sucursal: " + rs.getString("sucursal") +
                " | Inicio: " + rs.getDate("fecha_inicio") +
                " | Fin: " + rs.getDate("fecha_fin")
            );
        }
        } catch (SQLException e) {
        System.out.println("Error al ejecutar el procedimiento: " + e.getMessage());
        }
    }   
    
    public void repingresosPorSucursal() {
        System.out.print("Ingrese el año que desea consultar: ");
        int anio = sc.nextInt();
        sc.nextLine();

        String sql = """
            SELECT s.ciudad, SUM(a.costo) AS ingresos_totales
            FROM Contrato cto
            JOIN Anexo a ON cto.noContrato = a.noContrato
            JOIN Sucursal s ON cto.id_sucursal = s.id_sucursal
            WHERE YEAR(a.fecha_inicio) = ?
            GROUP BY s.ciudad
            ORDER BY ingresos_totales DESC;
        """;

        try (Connection conn = DBconnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, anio);
            ResultSet rs = ps.executeQuery();

            System.out.println("===== INGRESOS POR SUCURSAL EN " + anio + " =====");
            while (rs.next()) {
                System.out.println(
                        "Sucursal: " + rs.getString("ciudad") +
                        " | Ingresos: $" + rs.getDouble("ingresos_totales")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar reporte: " + e.getMessage());
        }
    }
    
    public void repmultasPorCliente() {
        System.out.print("Ingrese el año que desea consultar: ");
        int anio = sc.nextInt();
        sc.nextLine();

        String sql = """
            SELECT c.id_cliente, s.ciudad, COUNT(m.id_multa) AS total_multas, SUM(m.costo) AS costo_total
            FROM Multa m
            JOIN Contrato cto ON m.id_cliente = cto.id_cliente
            JOIN Sucursal s ON cto.id_sucursal = s.id_sucursal
            JOIN Cliente c ON m.id_cliente = c.id_cliente
            WHERE YEAR(m.fecha) = ?
            GROUP BY c.id_cliente, s.ciudad
            ORDER BY costo_total DESC;
        """;

        try (Connection conn = DBconnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, anio);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== MULTAS POR CLIENTE EN " + anio + " =====");
            while (rs.next()) {
                System.out.println(
                    "Cliente ID: " + rs.getInt("id_cliente") +
                    " | Sucursal: " + rs.getString("ciudad") +
                    " | Multas: " + rs.getInt("total_multas") +
                    " | Costo Total: $" + rs.getDouble("costo_total")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar reporte: " + e.getMessage());
        }
    }
    
    public void repvehiculosVendidosPorSucursal() {
        System.out.print("Ingrese el año que desea consultar: ");
        int anio = sc.nextInt();
        sc.nextLine();

        String sql = """
            SELECT s.ciudad, COUNT(v.placa) AS total_vendidos, SUM(v.pvp) AS monto_total
            FROM Vehiculos v
            JOIN Anexo a ON v.id_anexo = a.id_anexo
            JOIN Contrato c ON a.noContrato = c.noContrato
            JOIN Sucursal s ON c.id_sucursal = s.id_sucursal
            WHERE v.estado = 'Vendido' AND YEAR(a.fecha_inicio) = ?
            GROUP BY s.ciudad
            ORDER BY monto_total DESC;
        """;

        try (Connection conn = DBconnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, anio);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== VEHÍCULOS VENDIDOS POR SUCURSAL EN " + anio + " =====");
            while (rs.next()) {
                System.out.println(
                    "Sucursal: " + rs.getString("ciudad") +
                    " | Vehículos vendidos: " + rs.getInt("total_vendidos") +
                    " | Monto total: $" + rs.getDouble("monto_total")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar reporte: " + e.getMessage());
        }
    }
}
