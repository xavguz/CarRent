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

/**
 *
 * @author usuario
 */
public class Editar {
    
    private Scanner sc = new Scanner(System.in);
    
    // Método genérico para ejecutar actualizaciones
    private boolean ejecutarActualizacion(String sql, Object... parametros) {
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 0; i < parametros.length; i++) {
                ps.setObject(i + 1, parametros[i]);
            }
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Actualización exitosa.");
                return true;
            } else {
                System.out.println("No se pudo actualizar.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la actualización: " + e.getMessage());
            return false;
        }
    }
    
    // Método genérico para verificar existencia
    private boolean existe(String tabla, String columna, String valor) {
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            String sql = "SELECT COUNT(*) FROM " + tabla + " WHERE " + columna + " = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, valor);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Método genérico para mostrar listados
    private void mostrarListado(String sql) {
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println(formatearResultado(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private String formatearResultado(ResultSet rs) throws SQLException {
        StringBuilder sb = new StringBuilder();
        int columnCount = rs.getMetaData().getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            if (i > 1) sb.append(" - ");
            sb.append(rs.getString(i));
        }
        return sb.toString();
    }
    
    public void editarCliente() {
        System.out.println("===== EDITAR CLIENTE =====");
        mostrarListado("SELECT id_cliente, aprobado FROM Cliente");
        
        System.out.print("ID del cliente: ");
        String id = sc.nextLine();
        
        if (!existe("Cliente", "id_cliente", id)) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        
        System.out.print("¿Cambiar estado de aprobación? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo estado (1=aprobado, 0=no aprobado): ");
            int estado = sc.nextInt();
            sc.nextLine();
            ejecutarActualizacion("UPDATE Cliente SET aprobado = ? WHERE id_cliente = ?", estado, id);
        }
    }
    
    public void editarClienteNatural() {
        System.out.println("===== EDITAR CLIENTE NATURAL =====");
        mostrarListado("SELECT id_cliente, nombre, apellido, cedula FROM cliente_natural");
        
        System.out.print("ID del cliente: ");
        String id = sc.nextLine();
        
        if (!existe("cliente_natural", "id_cliente", id)) {
            System.out.println("Cliente natural no encontrado.");
            return;
        }
        
        System.out.print("¿Cambiar cédula? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nueva cédula: ");
            String cedula = sc.nextLine();
            ejecutarActualizacion("UPDATE cliente_natural SET cedula = ? WHERE id_cliente = ?", cedula, id);
        }
        
        System.out.print("¿Cambiar nombre? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();
            ejecutarActualizacion("UPDATE cliente_natural SET nombre = ? WHERE id_cliente = ?", nombre, id);
        }
        
        System.out.print("¿Cambiar apellido? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo apellido: ");
            String apellido = sc.nextLine();
            ejecutarActualizacion("UPDATE cliente_natural SET apellido = ? WHERE id_cliente = ?", apellido, id);
        }
    }
    
    public void editarClienteEmpresa() {
        System.out.println("===== EDITAR CLIENTE EMPRESA =====");
        mostrarListado("SELECT id_cliente, nombre, RUC FROM cliente_empresa");
        
        System.out.print("ID del cliente: ");
        String id = sc.nextLine();
        
        if (!existe("cliente_empresa", "id_cliente", id)) {
            System.out.println("Cliente empresa no encontrado.");
            return;
        }
        
        System.out.print("¿Cambiar RUC? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo RUC: ");
            String ruc = sc.nextLine();
            ejecutarActualizacion("UPDATE cliente_empresa SET RUC = ? WHERE id_cliente = ?", ruc, id);
        }
        
        System.out.print("¿Cambiar nombre? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();
            ejecutarActualizacion("UPDATE cliente_empresa SET nombre = ? WHERE id_cliente = ?", nombre, id);
        }
    }
    
    public void editarVehiculo() {
        System.out.println("===== EDITAR VEHÍCULO =====");
        mostrarListado("SELECT placa, marca, modelo, estado FROM Vehiculos");
        
        System.out.print("Placa del vehículo: ");
        String placa = sc.nextLine();
        
        if (!existe("Vehiculos", "placa", placa)) {
            System.out.println("Vehículo no encontrado.");
            return;
        }
        
        System.out.print("¿Cambiar modelo? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo modelo: ");
            String modelo = sc.nextLine();
            ejecutarActualizacion("UPDATE Vehiculos SET modelo = ? WHERE placa = ?", modelo, placa);
        }
        
        System.out.print("¿Cambiar marca? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nueva marca: ");
            String marca = sc.nextLine();
            ejecutarActualizacion("UPDATE Vehiculos SET marca = ? WHERE placa = ?", marca, placa);
        }
        
        System.out.print("¿Cambiar estado? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo estado: ");
            String estado = sc.nextLine();
            ejecutarActualizacion("UPDATE Vehiculos SET estado = ? WHERE placa = ?", estado, placa);
        }
        
        System.out.print("¿Cambiar kilometraje? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo kilometraje: ");
            double km = sc.nextDouble();
            sc.nextLine();
            ejecutarActualizacion("UPDATE Vehiculos SET kilometraje = ? WHERE placa = ?", km, placa);
        }
        
        System.out.print("¿Cambiar PVP? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo PVP: ");
            double pvp = sc.nextDouble();
            sc.nextLine();
            ejecutarActualizacion("UPDATE Vehiculos SET pvp = ? WHERE placa = ?", pvp, placa);
        }
    }
    
    public void editarEmpleado() {
        System.out.println("===== EDITAR EMPLEADO =====");
        mostrarListado("SELECT cedula, nombre, apellido, cargo FROM Empleados");
        
        System.out.print("Cédula del empleado: ");
        String cedula = sc.nextLine();
        
        if (!existe("Empleados", "cedula", cedula)) {
            System.out.println("Empleado no encontrado.");
            return;
        }
        
        System.out.print("¿Cambiar nombre? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();
            ejecutarActualizacion("UPDATE Empleados SET nombre = ? WHERE cedula = ?", nombre, cedula);
        }
        
        System.out.print("¿Cambiar apellido? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo apellido: ");
            String apellido = sc.nextLine();
            ejecutarActualizacion("UPDATE Empleados SET apellido = ? WHERE cedula = ?", apellido, cedula);
        }
        
        System.out.print("¿Cambiar cargo? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo cargo: ");
            String cargo = sc.nextLine();
            ejecutarActualizacion("UPDATE Empleados SET cargo = ? WHERE cedula = ?", cargo, cedula);
        }
        
        System.out.print("¿Cambiar sucursal? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.println("Sucursales disponibles:");
            mostrarListado("SELECT id_sucursal, ciudad FROM Sucursal");
            System.out.print("ID de sucursal: ");
            String sucursal = sc.nextLine();
            ejecutarActualizacion("UPDATE Empleados SET id_sucursal = ? WHERE cedula = ?", sucursal, cedula);
        }
    }
    
    public void editarContrato() {
        System.out.println("===== EDITAR CONTRATO =====");
        mostrarListado("SELECT noContrato, tipo_contrato, estado FROM Contrato");
        
        System.out.print("Número de contrato: ");
        String contrato = sc.nextLine();
        
        if (!existe("Contrato", "noContrato", contrato)) {
            System.out.println("Contrato no encontrado.");
            return;
        }
        
        System.out.print("¿Cambiar tipo de contrato? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo tipo: ");
            String tipo = sc.nextLine();
            ejecutarActualizacion("UPDATE Contrato SET tipo_contrato = ? WHERE noContrato = ?", tipo, contrato);
        }
        
        System.out.print("¿Cambiar seguro? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Seguro (1=sí, 0=no): ");
            int seguro = sc.nextInt();
            sc.nextLine();
            ejecutarActualizacion("UPDATE Contrato SET seguro = ? WHERE noContrato = ?", seguro, contrato);
        }
        
        System.out.print("¿Cambiar estado? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Estado (1=activo, 0=inactivo): ");
            int estado = sc.nextInt();
            sc.nextLine();
            ejecutarActualizacion("UPDATE Contrato SET estado = ? WHERE noContrato = ?", estado, contrato);
        }
        
        System.out.print("¿Cambiar kilómetros? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevos kilómetros: ");
            String km = sc.nextLine();
            ejecutarActualizacion("UPDATE Contrato SET km_establecidos = ? WHERE noContrato = ?", km, contrato);
        }
    }
    
    public void editarSucursal() {
        System.out.println("===== EDITAR SUCURSAL =====");
        mostrarListado("SELECT id_sucursal, ciudad, direccion FROM Sucursal");
        
        System.out.print("ID de sucursal: ");
        String id = sc.nextLine();
        
        if (!existe("Sucursal", "id_sucursal", id)) {
            System.out.println("Sucursal no encontrada.");
            return;
        }
        
        System.out.print("¿Cambiar ciudad? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nueva ciudad: ");
            String ciudad = sc.nextLine();
            ejecutarActualizacion("UPDATE Sucursal SET ciudad = ? WHERE id_sucursal = ?", ciudad, id);
        }
        
        System.out.print("¿Cambiar dirección? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nueva dirección: ");
            String direccion = sc.nextLine();
            ejecutarActualizacion("UPDATE Sucursal SET direccion = ? WHERE id_sucursal = ?", direccion, id);
        }
    }
    
    public void editarFactura() {
        System.out.println("===== EDITAR FACTURA =====");
        mostrarListado("SELECT noFactura, estado_pago, monto FROM Factura");
        
        System.out.print("Número de factura: ");
        String factura = sc.nextLine();
        
        if (!existe("Factura", "noFactura", factura)) {
            System.out.println("Factura no encontrada.");
            return;
        }
        
        System.out.print("¿Cambiar estado de pago? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo estado: ");
            String estado = sc.nextLine();
            ejecutarActualizacion("UPDATE Factura SET estado_pago = ? WHERE noFactura = ?", estado, factura);
        }
        
        System.out.print("¿Cambiar método de pago? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo método: ");
            String metodo = sc.nextLine();
            ejecutarActualizacion("UPDATE Factura SET metodo_pago = ? WHERE noFactura = ?", metodo, factura);
        }
        
        System.out.print("¿Cambiar monto? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo monto: ");
            double monto = sc.nextDouble();
            sc.nextLine();
            ejecutarActualizacion("UPDATE Factura SET monto = ? WHERE noFactura = ?", monto, factura);
        }
    }
    
    public void editarMulta() {
        System.out.println("===== EDITAR MULTA =====");
        mostrarListado("SELECT id_multa, causa, costo FROM Multa");
        
        System.out.print("ID de multa: ");
        String id = sc.nextLine();
        
        if (!existe("Multa", "id_multa", id)) {
            System.out.println("Multa no encontrada.");
            return;
        }
        
        System.out.print("¿Cambiar causa? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nueva causa: ");
            String causa = sc.nextLine();
            ejecutarActualizacion("UPDATE Multa SET causa = ? WHERE id_multa = ?", causa, id);
        }
        
        System.out.print("¿Cambiar costo? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo costo: ");
            double costo = sc.nextDouble();
            sc.nextLine();
            ejecutarActualizacion("UPDATE Multa SET costo = ? WHERE id_multa = ?", costo, id);
        }
    }
}
