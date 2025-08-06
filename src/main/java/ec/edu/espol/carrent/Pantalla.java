/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.carrent;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nueva
 */
public class Pantalla {
    
    Scanner sc = new Scanner(System.in);
    Consultar consultar = new Consultar();
    
    public void mostrarReportes(){
        
        int opcion;
        
        do {
            System.out.println("-----Reportes-----");
            System.out.println("1. Mostrar Vehiculos Disponibles");
            System.out.println("2. Mostrar Ingresos");
            System.out.println("3. Consultar Anexos");
            System.out.println("4. Consultar Clientes");
            System.out.println("5. Consultar Clientes Empesariales");
            System.out.println("6. Consultar Clientes Naturales");
            System.out.println("7. Consultar Contratos");
            System.out.println("8. Consultar Correos de Clientes");
            System.out.println("9. Consultar Correos de Empleados");
            System.out.println("10. Consultar Empleados");
            System.out.println("11. Consultar Registro de Facturas");
            System.out.println("12. Consultar Facturas Emitidas");
            System.out.println("13. Consultar Facturas Recibidas");
            System.out.println("14. Consultar Facturas Recibidas de Servicios");
            System.out.println("15. Consultar Mantenimientos");
            System.out.println("16. Consultar Modificaciones");
            System.out.println("17. Consultar Multas");
            System.out.println("18. Consultar Ordenes de Compra");
            System.out.println("19. Consultar Servicios");
            System.out.println("20. Consultar Sucursales");
            System.out.println("21. Consultar Telefonos de Clientes");
            System.out.println("22. Consultar Telefonos de Empleados");
            System.out.println("23. Consultar Vehiculos");
            System.out.println("0. Salir");
            
            opcion = sc.nextInt();
            
            consultas(opcion);
        
        } while (opcion != 0);
    }
    
    public void consultaVehiculosDisponibles(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "select * from Vehiculos where estado = 'Disponible'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String id_vehiculo = rs.getString("placa");
                String marca = rs.getString("marca");
                String placa = rs.getString("modelo");
                System.out.println(id_vehiculo + " - " + marca + " " + placa);
            }
            
            
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultaIngresos(){
        try {
            Connection conn = DBconnection.getInstance().getConnection();
            
            String sql = "select sum(monto) total  from Factura join factura_emitida using (noFactura) where estado_pago = 'Pagado' group by (estado_pago)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                float total = rs.getFloat("total");
                System.out.println("total:" + total);
            }
            
            
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
    
    public void consultas(int opcion){
        switch (opcion) {
            case 1: 
                consultaVehiculosDisponibles();
                break;
            case 2:
                consultaIngresos();
                break;
            case 3:
                consultar.consultarAnexo();
                break;
            case 4:
                consultar.consultarCliente();
                break;
            case 5:
                consultar.consultarClienteEmpresa();
                break;
            case 6:
                consultar.consultarClienteNatural();
                break;
            case 7:
                consultar.consultarContrato();
                break;
            case 8:
                consultar.consultarCorreoCliente();
                break;
            case 9:
                consultar.consultarCorreoEmpleado();
                break;
            case 10:
                consultar.consultarEmpleado();
                break;
            case 11:
                consultar.consultarFactura();
                break;
            case 12:
                consultar.consultarFacturaEmitida();
                break;
            case 13:
                consultar.consultarFacturaRecibida();
                break;
            case 14:
                consultar.consultarFacturaRecibidaServicio();
                break;
            case 15:
                consultar.consultarMantenimientos();
                break;
            case 16:
                consultar.consultarModificaciones();
                break;
            case 17:
                consultar.consultarMultas();
                break;
            case 18:
                consultar.consultarOrdenCompra();
                break;
            case 19:
                consultar.consultarServicios();
                break;
            case 20:
                consultar.consultarSucursal();
                break;
            case 21:
                consultar.consultarTelefonoCliente();
                break;
            case 22:
                consultar.consultarTelefonoEmpleado();
                break;
            case 23:
                consultar.consultarVehiculos();
                break;
        }
    }
}
