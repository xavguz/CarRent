package ec.edu.espol.carrent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.math.BigDecimal;

public class Editar {
    
    private void ejecutarActualizacion(String sql, Object... parametros) {
        try {
            Connection con = DBconnection.getInstance().getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            for (int i = 0; i < parametros.length; i++) {
                stmt.setObject(i + 1, parametros[i]);
            }
            
            int filas = stmt.executeUpdate();
            
            if (filas > 0) {
                System.out.println("Registro actualizado correctamente.");
            } else {
                System.out.println("No se encontró el registro para actualizar.");
            }
            
            stmt.close();
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar registro: " + e.getMessage());
        }
    }
    
    public void editarAnexo(String id_anexo, String noContrato, Date fecha_inicio, 
                           String tipo_uso_operativo, Date fecha_fin, BigDecimal costo) {
        String sql = "UPDATE Anexo SET noContrato = ?, fecha_inicio = ?, tipo_uso_operativo = ?, " +
                    "fecha_fin = ?, costo = ? WHERE id_anexo = ?";
        ejecutarActualizacion(sql, noContrato, fecha_inicio, tipo_uso_operativo, 
                            fecha_fin, costo, id_anexo);
    }
    
    public void editarCliente(String id_cliente, boolean aprobado) {
        String sql = "UPDATE Cliente SET aprobado = ? WHERE id_cliente = ?";
        ejecutarActualizacion(sql, aprobado, id_cliente);
    }
    
    public void editarContrato(String noContrato, String id_sucursal, String id_cliente, 
                              String tipo_contrato, Date fecha_emision, boolean seguro, 
                              boolean estado, String km_establecidos, Date dia_pago) {
        String sql = "UPDATE Contrato SET id_sucursal = ?, id_cliente = ?, tipo_contrato = ?, " +
                    "fecha_emision = ?, seguro = ?, estado = ?, km_establecidos = ?, dia_pago = ? " +
                    "WHERE noContrato = ?";
        ejecutarActualizacion(sql, id_sucursal, id_cliente, tipo_contrato, fecha_emision, 
                            seguro, estado, km_establecidos, dia_pago, noContrato);
    }
    
    public void editarEmpleado(String cedula, String nombre, String apellido, 
                              String cargo, String id_sucursal) {
        String sql = "UPDATE Empleados SET nombre = ?, apellido = ?, cargo = ?, " +
                    "id_sucursal = ? WHERE cedula = ?";
        ejecutarActualizacion(sql, nombre, apellido, cargo, id_sucursal, cedula);
    }
    
    public void editarFactura(String noFactura, Date fecha_emision, String estado_pago, 
                             Date fecha_pago, BigDecimal monto, String metodo_pago) {
        String sql = "UPDATE Factura SET fecha_emision = ?, estado_pago = ?, fecha_pago = ?, " +
                    "monto = ?, metodo_pago = ? WHERE noFactura = ?";
        ejecutarActualizacion(sql, fecha_emision, estado_pago, fecha_pago, 
                            monto, metodo_pago, noFactura);
    }
    
    public void editarMantenimiento(String id_servicio_mantemiento, String causa) {
        String sql = "UPDATE Mantenimientos SET causa = ? WHERE id_servicio_mantemiento = ?";
        ejecutarActualizacion(sql, causa, id_servicio_mantemiento);
    }
    
    public void editarModificacion(String id_servicio_modificacion, String tipo_modificacion) {
        String sql = "UPDATE Modificaciones SET tipo_modificacion = ? WHERE id_servicio_modificacion = ?";
        ejecutarActualizacion(sql, tipo_modificacion, id_servicio_modificacion);
    }
    
    public void editarMulta(String id_multa, String id_cliente, Date fecha, String causa, BigDecimal costo) {
        String sql = "UPDATE Multa SET id_cliente = ?, fecha = ?, causa = ?, costo = ? WHERE id_multa = ?";
        ejecutarActualizacion(sql, id_cliente, fecha, causa, costo, id_multa);
    }
    
    public void editarOrdenCompra(String id_orden_compra, String id_anexo, Date fecha_emision, 
                                 String estado, Date fecha_entrega, BigDecimal monto, String concecionaria) {
        String sql = "UPDATE Orden_Compra SET id_anexo = ?, fecha_emision = ?, estado = ?, " +
                    "fecha_entrega = ?, monto = ?, concecionaria = ? WHERE id_orden_compra = ?";
        ejecutarActualizacion(sql, id_anexo, fecha_emision, estado, fecha_entrega, 
                            monto, concecionaria, id_orden_compra);
    }
    
    public void editarServicio(String id_servicio, Date fecha, BigDecimal costo, String lugar) {
        String sql = "UPDATE Servicios SET fecha = ?, costo = ?, lugar = ? WHERE id_servicio = ?";
        ejecutarActualizacion(sql, fecha, costo, lugar, id_servicio);
    }
    
    public void editarSucursal(String id_sucursal, String ciudad, String direccion) {
        String sql = "UPDATE Sucursal SET ciudad = ?, direccion = ? WHERE id_sucursal = ?";
        ejecutarActualizacion(sql, ciudad, direccion, id_sucursal);
    }
    
    public void editarVehiculo(String placa, String id_anexo, String id_orden_compra, 
                              String modelo, String marca, String chasis, String tipo_vehiculo,
                              BigDecimal kilometraje, Date año, String ramv, String estado, BigDecimal pvp) {
        String sql = "UPDATE Vehiculos SET id_anexo = ?, id_orden_compra = ?, modelo = ?, " +
                    "marca = ?, chasis = ?, tipo_vehiculo = ?, kilometraje = ?, año = ?, ramv = ?, " +
                    "estado = ?, pvp = ? WHERE placa = ?";
        ejecutarActualizacion(sql, id_anexo, id_orden_compra, modelo, marca, chasis, tipo_vehiculo,
                            kilometraje, año, ramv, estado, pvp, placa);
    }
    
    public void editarClienteEmpresa(String id_cliente, String RUC, String nombre) {
        String sql = "UPDATE cliente_empresa SET RUC = ?, nombre = ? WHERE id_cliente = ?";
        ejecutarActualizacion(sql, RUC, nombre, id_cliente);
    }
    
    public void editarClienteNatural(String id_cliente, String cedula, String nombre, String apellido) {
        String sql = "UPDATE cliente_natural SET cedula = ?, nombre = ?, apellido = ? WHERE id_cliente = ?";
        ejecutarActualizacion(sql, cedula, nombre, apellido, id_cliente);
    }
    
    public void editarCorreoCliente(String id_cliente, String correoAntiguo, String correoNuevo) {
        String sql = "UPDATE correo_cliente SET correo = ? WHERE id_cliente = ? AND correo = ?";
        ejecutarActualizacion(sql, correoNuevo, id_cliente, correoAntiguo);
    }
    
    public void editarCorreoEmpleado(String cedula, String correoAntiguo, String correoNuevo) {
        String sql = "UPDATE correo_empleado SET correo = ? WHERE cedula = ? AND correo = ?";
        ejecutarActualizacion(sql, correoNuevo, cedula, correoAntiguo);
    }
    
    public void editarFacturaEmitida(String noFactura, String id_anexo, String id_multa) {
        String sql = "UPDATE factura_emitida SET id_multa = ? WHERE noFactura = ? AND id_anexo = ?";
        ejecutarActualizacion(sql, id_multa, noFactura, id_anexo);
    }
    
    public void editarFacturaRecibida(String noFactura, String id_orden_compra) {
        String sql = "SELECT 1 FROM factura_recibida WHERE noFactura = ? AND id_orden_compra = ?";
    }
    
    public void editarTelefonoCliente(String id_cliente, String telefonoAntiguo, String telefonoNuevo) {
        String sql = "UPDATE telefono_cliente SET telefono = ? WHERE id_cliente = ? AND telefono = ?";
        ejecutarActualizacion(sql, telefonoNuevo, id_cliente, telefonoAntiguo);
    }
    
    public void editarTelefonoEmpleado(String cedula, String telefonoAntiguo, String telefonoNuevo) {
        String sql = "UPDATE telefono_empleado SET telefono = ? WHERE cedula = ? AND telefono = ?";
        ejecutarActualizacion(sql, telefonoNuevo, cedula, telefonoAntiguo);
    }
    
    public void editarVehiculoServicio(String placa, String id_servicio) {
        String sqlDelete = "DELETE FROM vehiculo_servicios WHERE placa = ? AND id_servicio = ?";
        String sqlInsert = "INSERT INTO vehiculo_servicios (placa, id_servicio) VALUES (?, ?)";
    }
    
    public void editarCampo(String tabla, String campoId, String valorId, 
                           String campoEditar, Object nuevoValor) {
        String sql = "UPDATE " + tabla + " SET " + campoEditar + " = ? WHERE " + campoId + " = ?";
        ejecutarActualizacion(sql, nuevoValor, valorId);
    }
    
    public boolean existeRegistro(String tabla, String campoId, String valorId) {
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            String sql = "SELECT COUNT(*) FROM " + tabla + " WHERE " + campoId + " = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, valorId);
            
            var rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar existencia del registro: " + e.getMessage());
        }
        return false;
    }
}
