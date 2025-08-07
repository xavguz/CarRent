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
    
    Eliminar eliminar = new Eliminar();
    Consultar consultar = new Consultar();
    
    Scanner sc = new Scanner(System.in);
    
    public void mostrarReportes(){
        
        int opcion;
        
        do {
            System.out.println("-----Reportes-----");
            System.out.println("1. Mostrar Vehiculos Disponibles");
            System.out.println("2. Mostrar Ingresos");
            System.out.println("3. Eliminar Registros");
            System.out.println("4. Consultar Registros");  
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
                int subOpcion;
        
                    do {
                        System.out.println("-----Seleccione el dato a eliminar-----");
                        System.out.println("1. Eliminar registro de la tabla Cliente");
                        System.out.println("2. Eliminar registro de la tabla Vehiculo");
                        System.out.println("3. Eliminar registro de la tabla Anexo");
                        System.out.println("4. Eliminar registro de la tabla Sucursal");
                        System.out.println("5. Eliminar registro de la tabla Factura");
                        System.out.println("6. Eliminar registro de la tabla Contrato");
                        System.out.println("7. Eliminar registro de la tabla OrdenDeCompra");
                        System.out.println("8. Eliminar registro de la tabla Empleado");
                        System.out.println("9. Eliminar registro de la tabla Multa");
                        System.out.println("10. Eliminar registro de la tabla Servicio");
                        System.out.println("11. Eliminar registro de la tabla Modificacion");
                        System.out.println("12. Eliminar registro de la tabla Mantenimiento");
                        System.out.println("13. SALIR");
                        
                        subOpcion = sc.nextInt();
                        sc.nextLine();
                        switch (subOpcion) {
                            case 1: 
                            System.out.println("Escriba el id del Cliente");
                            String id = sc.nextLine();
                            eliminar.eliminarCliente(id);
                            break;
                            case 2: 
                            System.out.println("Escriba la placa del Vehiculo");
                            String idVehiculo = sc.nextLine();
                            eliminar.eliminarVehiculo(idVehiculo);
                            break;
                            case 3: 
                            System.out.println("Escriba el id del Anexo");
                            String idAnexo = sc.nextLine();
                            eliminar.eliminarAnexo(idAnexo);
                            break;
                            case 4: 
                            System.out.println("Escriba el id de la Factura");
                            String idFactura = sc.nextLine();
                            eliminar.eliminarFactura(idFactura);
                            break;
                            case 5: 
                            System.out.println("Escriba el id de la Sucursal");
                            String idSucursal = sc.nextLine();
                            eliminar.eliminarSucursal(idSucursal);
                            break;
                            case 6: 
                            System.out.println("Escriba el id del Contrato");
                            String idContrato = sc.nextLine();
                            eliminar.eliminarContrato(idContrato);
                            break;
                            case 7: 
                            System.out.println("Escriba el id de la OrdenDeCompra");
                            String idODC = sc.nextLine();
                            eliminar.eliminarOrdenDeCompra(idODC);
                            break;
                            case 8: 
                            System.out.println("Escriba el id del Empleado");
                            String idEmpleado = sc.nextLine();
                            eliminar.eliminarEmpleado(idEmpleado);
                            break;
                            case 9: 
                            System.out.println("Escriba el id de la Multa");
                            String idMulta = sc.nextLine();
                            eliminar.eliminarMulta(idMulta);
                            break;
                            case 10: 
                            System.out.println("Escriba el id del Servicio");
                            String idServicio = sc.nextLine();
                            eliminar.eliminarServicio(idServicio);
                            break;
                            case 11: 
                            System.out.println("Escriba el id de la Modificacion");
                            String idModi = sc.nextLine();
                            eliminar.eliminarModificacion(idModi);
                            break;
                            case 12: 
                            System.out.println("Escriba el id del Mantenimiento");
                            String idMan = sc.nextLine();
                            eliminar.eliminarMantenimiento(idMan);
                            break;
                            default:
                                System.out.println("Opcion incorrecta");
                            
                        }
                    }while (subOpcion != 13);
            case 4:
                int subOpcion2;
                   do {
                        System.out.println("-----Seleccione que desea consultar-----");
                        System.out.println("1. Consultar Anexos");
                        System.out.println("2. Consultar Clientes");
                        System.out.println("3. Consultar Clientes Empesariales");
                        System.out.println("4. Consultar Clientes Naturales");
                        System.out.println("5. Consultar Contratos");
                        System.out.println("6. Consultar Correos de Clientes");
                        System.out.println("7. Consultar Correos de Empleados");
                        System.out.println("8. Consultar Empleados");
                        System.out.println("9. Consultar Registro de Facturas");
                        System.out.println("10. Consultar Facturas Emitidas");
                        System.out.println("11. Consultar Facturas Recibidas");
                        System.out.println("12. Consultar Facturas Recibidas de Servicios");
                        System.out.println("13. Consultar Mantenimientos");
                        System.out.println("14. Consultar Modificaciones");
                        System.out.println("15. Consultar Multas");
                        System.out.println("16. Consultar Ordenes de Compra");
                        System.out.println("17. Consultar Servicios");
                        System.out.println("18. Consultar Sucursales");
                        System.out.println("19. Consultar Telefonos de Clientes");
                        System.out.println("20. Consultar Telefonos de Empleados");
                        System.out.println("21. Consultar Vehiculos");
                        System.out.println("22. SALIR");
                        
                        subOpcion2 = sc.nextInt();
                        sc.nextLine();
                        
                        switch (subOpcion2) {
                            case 1:
                                consultar.consultarAnexo();
                                break;
                            case 2:
                                consultar.consultarCliente();
                                break;
                            case 3:
                                consultar.consultarClienteEmpresa();
                                break;
                            case 4:
                                consultar.consultarClienteNatural();
                                break;
                            case 5:
                                consultar.consultarContrato();
                                break;
                            case 6:
                                consultar.consultarCorreoCliente();
                                break;
                            case 7:
                                consultar.consultarCorreoEmpleado();
                                break;
                            case 8:
                                consultar.consultarEmpleado();
                                break;
                            case 9:
                                consultar.consultarFactura();
                                break;
                            case 10:
                                consultar.consultarFacturaEmitida();
                                break;
                            case 11:
                                consultar.consultarFacturaRecibida();
                                break;
                            case 12:
                                consultar.consultarFacturaRecibidaServicio();
                                break;
                            case 13:
                                consultar.consultarMantenimientos();
                                break;
                            case 14:
                                consultar.consultarModificaciones();
                                break;
                            case 15:
                                consultar.consultarMultas();
                                break;
                            case 16:
                                consultar.consultarOrdenCompra();
                                break;
                            case 17:
                                consultar.consultarServicios();
                                break;
                            case 18:
                                consultar.consultarSucursal();
                                break;
                            case 19:
                                consultar.consultarTelefonoCliente();
                                break;
                            case 20:
                                consultar.consultarTelefonoEmpleado();
                                break;
                            case 21:
                                consultar.consultarVehiculos();
                                break;
                            default:
                                System.out.println("Opcion incorrecta");
                        }
                }while (subOpcion2 != 22);
        }
  
    }
}
