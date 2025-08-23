package ec.edu.espol.carrent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * Paúl Rodríguez
 */
public class Editar {
    
    private Scanner sc = new Scanner(System.in);

    private boolean ejecutarStoredProcedure(String procedureName, Object... parametros) {
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            String sql = "call " + procedureName + "(";
            
            // Construir la query con los placeholders
            for (int i = 0; i < parametros.length; i++) {
                sql += "?";
                if (i < parametros.length - 1) sql += ", ";
            }
            sql += ")";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 0; i < parametros.length; i++) {
                ps.setObject(i + 1, parametros[i]);
            }
            
            ps.execute(); 
            
            System.out.println("Actualización exitosa.");
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error en la actualización: " + e.getMessage());
            return false;
        }
    }
    
    private boolean existe(String procedureName, String valor) {
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            String sql = "call " + procedureName + "(?)";
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
        
        if (!existe("sp_existe_cliente", id)) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        
        System.out.print("¿Cambiar estado de aprobación? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo estado (true=aprobado, false=no aprobado): ");
            boolean estado = sc.nextBoolean();
            sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_cliente_estado", estado, id);
        }
    }
    
    public void editarClienteNatural() {
        System.out.println("===== EDITAR CLIENTE NATURAL =====");
        mostrarListado("SELECT id_cliente, nombre, apellido, cedula FROM cliente_natural");
        
        System.out.print("ID del cliente: ");
        String id = sc.nextLine();
        
        if (!existe("sp_existe_cliente_natural", id)) {
            System.out.println("Cliente natural no encontrado.");
            return;
        }
        
        System.out.print("¿Cambiar cédula? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nueva cédula: ");
            String cedula = sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_cliente_natural_cedula", cedula, id);
        }
        
        System.out.print("¿Cambiar nombre? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_cliente_natural_nombre", nombre, id);
        }
        
        System.out.print("¿Cambiar apellido? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo apellido: ");
            String apellido = sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_cliente_natural_apellido", apellido, id);
        }
    }
    
    public void editarClienteEmpresa() {
        System.out.println("===== EDITAR CLIENTE EMPRESA =====");
        mostrarListado("SELECT id_cliente, nombre, RUC FROM cliente_empresa");
        
        System.out.print("ID del cliente: ");
        String id = sc.nextLine();
        
        if (!existe("sp_existe_cliente_empresa", id)) {
            System.out.println("Cliente empresa no encontrado.");
            return;
        }
        
        System.out.print("¿Cambiar RUC? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo RUC: ");
            String ruc = sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_cliente_empresa_ruc", ruc, id);
        }
        
        System.out.print("¿Cambiar nombre? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_cliente_empresa_nombre", nombre, id);
        }
    }
    
    public void editarVehiculo() {
        System.out.println("===== EDITAR VEHÍCULO =====");
        mostrarListado("SELECT placa, marca, modelo, estado, kilometraje, pvp FROM Vehiculos");
        
        System.out.print("Placa del vehículo: ");
        String placa = sc.nextLine();
        
        if (!existe("sp_existe_vehiculo", placa)) {
            System.out.println("Vehículo no encontrado.");
            return;
        }
        
        System.out.print("¿Cambiar modelo? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo modelo: ");
            String modelo = sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_vehiculo_modelo", modelo, placa);
        }
        
        System.out.print("¿Cambiar marca? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nueva marca: ");
            String marca = sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_vehiculo_marca", marca, placa);
        }
        
        System.out.print("¿Cambiar estado? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo estado: ");
            String estado = sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_vehiculo_estado", estado, placa);
        }
        
        System.out.print("¿Cambiar kilometraje? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo kilometraje: ");
            int km = sc.nextInt();
            sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_vehiculo_kilometraje", km, placa);
        }
        
        System.out.print("¿Cambiar PVP? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo PVP: ");
            int pvp = sc.nextInt();
            sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_vehiculo_pvp", pvp, placa);
        }
    }
    
    public void editarEmpleado() {
        System.out.println("===== EDITAR EMPLEADO =====");
        mostrarListado("SELECT cedula, nombre, apellido, cargo, id_sucursal FROM Empleados");
        
        System.out.print("Cédula del empleado: ");
        String cedula = sc.nextLine();
        
        if (!existe("sp_existe_empleado", cedula)) {
            System.out.println("Empleado no encontrado.");
            return;
        }
        
        System.out.print("¿Cambiar nombre? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_empleado_nombre", nombre, cedula);
        }
        
        System.out.print("¿Cambiar apellido? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo apellido: ");
            String apellido = sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_empleado_apellido", apellido, cedula);
        }
        
        System.out.print("¿Cambiar cargo? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo cargo: ");
            String cargo = sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_empleado_cargo", cargo, cedula);
        }
        
        System.out.print("¿Cambiar sucursal? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.println("Sucursales disponibles:");
            mostrarListado("SELECT id_sucursal, ciudad FROM Sucursal");
            System.out.print("ID de sucursal: ");
            String sucursal = sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_empleado_sucursal", sucursal, cedula);
        }
    }
    
    public void editarContrato() {
        System.out.println("===== EDITAR CONTRATO =====");
        mostrarListado("SELECT noContrato, tipo_contrato, seguro, estado, km_establecidos FROM Contrato");
        
        System.out.print("Número de contrato: ");
        String contrato = sc.nextLine();
        
        if (!existe("sp_existe_contrato", contrato)) {
            System.out.println("Contrato no encontrado.");
            return;
        }
        
        System.out.print("¿Cambiar tipo de contrato? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo tipo: ");
            String tipo = sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_contrato_tipo", tipo, contrato);
        }
        
        System.out.print("¿Cambiar seguro? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Seguro (true=sí, false=no): ");
            boolean seguro = sc.nextBoolean();
            sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_contrato_seguro", seguro, contrato);
        }
        
        System.out.print("¿Cambiar estado? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Estado (true=activo, false=inactivo): ");
            boolean estado = sc.nextBoolean();
            sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_contrato_estado", estado, contrato);
        }
        
        System.out.print("¿Cambiar kilómetros? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevos kilómetros: ");
            String km = sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_contrato_kilometros", km, contrato);
        }
    }
    
    public void editarSucursal() {
        System.out.println("===== EDITAR SUCURSAL =====");
        mostrarListado("SELECT id_sucursal, ciudad, direccion FROM Sucursal");
        
        System.out.print("ID de sucursal: ");
        String id = sc.nextLine();
        
        if (!existe("sp_existe_sucursal", id)) {
            System.out.println("Sucursal no encontrada.");
            return;
        }
        
        System.out.print("¿Cambiar ciudad? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nueva ciudad: ");
            String ciudad = sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_sucursal_ciudad", ciudad, id);
        }
        
        System.out.print("¿Cambiar dirección? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nueva dirección: ");
            String direccion = sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_sucursal_direccion", direccion, id);
        }
    }
    
    public void editarFactura() {
        System.out.println("===== EDITAR FACTURA =====");
        mostrarListado("SELECT noFactura, estado_pago, metodo_pago, monto FROM Factura");
        
        System.out.print("Número de factura: ");
        String factura = sc.nextLine();
        
        if (!existe("sp_existe_factura", factura)) {
            System.out.println("Factura no encontrada.");
            return;
        }
        
        System.out.print("¿Cambiar estado de pago? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo estado: ");
            String estado = sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_factura_estado", estado, factura);
        }
        
        System.out.print("¿Cambiar método de pago? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo método: ");
            String metodo = sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_factura_metodo", metodo, factura);
        }
        
        System.out.print("¿Cambiar monto? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo monto: ");
            double monto = sc.nextDouble();
            sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_factura_monto", monto, factura);
        }
    }
    
    public void editarMulta() {
        System.out.println("===== EDITAR MULTA =====");
        mostrarListado("SELECT id_multa, id_cliente, causa, costo FROM Multa");
        
        System.out.print("ID de multa: ");
        String id = sc.nextLine();
        
        if (!existe("sp_existe_multa", id)) {
            System.out.println("Multa no encontrada.");
            return;
        }
        
        System.out.print("¿Cambiar causa? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nueva causa: ");
            String causa = sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_multa_causa", causa, id);
        }
        
        System.out.print("¿Cambiar costo? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nuevo costo: ");
            double costo = sc.nextDouble();
            sc.nextLine();
            ejecutarStoredProcedure("sp_actualizar_multa_costo", costo, id);
        }
    }
}
