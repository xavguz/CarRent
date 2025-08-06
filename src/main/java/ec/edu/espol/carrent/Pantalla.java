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
    
    Scanner sc = new Scanner(System.in);
    
    public void mostrarReportes(){
        
        int opcion;
        
        do {
            System.out.println("-----Reportes-----");
            System.out.println("1. Mostrar Vehiculos Disponibles");
            System.out.println("2. Mostrar Ingresos");
            System.out.println("3. Eliminar Registros");
            System.out.println("4. Salir");
            
            opcion = sc.nextInt();
            
            consultas(opcion);
        
        } while (opcion != 4);
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
                        System.out.println("13. Salir");
                        
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
                break;
        }
    }
}
