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
                    }while (subOpcion != 12);
                break;
                case 5:
                    int subOpcion3;
                    do {
                        System.out.println("-----Seleccione el registro a editar-----");
                        System.out.println("1. Editar Anexo");
                        System.out.println("2. Editar Cliente");
                        System.out.println("3. Editar Cliente Empresa");
                        System.out.println("4. Editar Cliente Natural");
                        System.out.println("5. Editar Contrato");
                        System.out.println("6. Editar Correo Cliente");
                        System.out.println("7. Editar Correo Empleado");
                        System.out.println("8. Editar Empleado");
                        System.out.println("9. Editar Factura");
                        System.out.println("10. Editar Factura Emitida");
                        System.out.println("11. Editar Mantenimiento");
                        System.out.println("12. Editar Modificacion");
                        System.out.println("13. Editar Multa");
                        System.out.println("14. Editar Orden de Compra");
                        System.out.println("15. Editar Servicio");
                        System.out.println("16. Editar Sucursal");
                        System.out.println("17. Editar Telefono Cliente");
                        System.out.println("18. Editar Telefono Empleado");
                        System.out.println("19. Editar Vehiculo");
                        System.out.println("20. SALIR");
                        
                        subOpcion3 = sc.nextInt();
                        sc.nextLine();
                        
                        switch (subOpcion3) {
                            case 1: // Editar Anexo
                                editarAnexoSelectivo();
                                break;
                            case 2: // Editar Cliente
                                editarClienteSelectivo();
                                break;
                            case 3: // Editar Cliente Empresa
                                editarClienteEmpresaSelectivo();
                                break;
                            case 4: // Editar Cliente Natural
                                editarClienteNaturalSelectivo();
                                break;
                            case 5: // Editar Contrato
                                editarContratoSelectivo();
                                break;
                            case 6: // Editar Correo Cliente
                                editarCorreoClienteSelectivo();
                                break;
                            case 7: // Editar Correo Empleado
                                editarCorreoEmpleadoSelectivo();
                                break;
                            case 8: // Editar Empleado
                                editarEmpleadoSelectivo();
                                break;
                            case 9: // Editar Factura
                                editarFacturaSelectivo();
                                break;
                            case 10: // Editar Factura Emitida
                                editarFacturaEmitidaSelectivo();
                                break;
                            case 11: // Editar Mantenimiento
                                editarMantenimientoSelectivo();
                                break;
                            case 12: // Editar Modificacion
                                editarModificacionSelectivo();
                                break;
                            case 13: // Editar Multa
                                editarMultaSelectivo();
                                break;
                            case 14: // Editar Orden de Compra
                                editarOrdenCompraSelectivo();
                                break;
                            case 15: // Editar Servicio
                                editarServicioSelectivo();
                                break;
                            case 16: // Editar Sucursal
                                editarSucursalSelectivo();
                                break;
                            case 17: // Editar Telefono Cliente
                                editarTelefonoClienteSelectivo();
                                break;
                            case 18: // Editar Telefono Empleado
                                editarTelefonoEmpleadoSelectivo();
                                break;
                            case 19: // Editar Vehiculo
                                editarVehiculoSelectivo();
                                break;
                            default:
                                System.out.println("Opcion incorrecta");
                        }
                    } while (subOpcion3 != 20);
                    break;
                
                // AGREGAR estos métodos nuevos a la clase:
                
                private void editarAnexoSelectivo() {
                    System.out.println("Escriba el id del Anexo:");
                    String idAnexo = sc.nextLine();
                    
                    // Mostrar valores actuales
                    mostrarAnexoActual(idAnexo);
                    
                    System.out.println("¿Cambiar numero de Contrato? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo numero de Contrato:");
                        String noContrato = sc.nextLine();
                        editar.editarCampo("Anexo", "id_anexo", idAnexo, "noContrato", noContrato);
                    }
                    
                    System.out.println("¿Cambiar fecha de inicio? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nueva fecha de inicio (YYYY-MM-DD):");
                        String fechaStr = sc.nextLine();
                        Date fecha = Date.valueOf(fechaStr);
                        editar.editarCampo("Anexo", "id_anexo", idAnexo, "fecha_inicio", fecha);
                    }
                    
                    System.out.println("¿Cambiar tipo de uso operativo? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo tipo de uso operativo:");
                        String tipoUso = sc.nextLine();
                        editar.editarCampo("Anexo", "id_anexo", idAnexo, "tipo_uso_operativo", tipoUso);
                    }
                    
                    System.out.println("¿Cambiar fecha de fin? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nueva fecha de fin (YYYY-MM-DD):");
                        String fechaFinStr = sc.nextLine();
                        Date fechaFin = Date.valueOf(fechaFinStr);
                        editar.editarCampo("Anexo", "id_anexo", idAnexo, "fecha_fin", fechaFin);
                    }
                    
                    System.out.println("¿Cambiar costo? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo costo:");
                        BigDecimal costo = sc.nextBigDecimal();
                        sc.nextLine();
                        editar.editarCampo("Anexo", "id_anexo", idAnexo, "costo", costo);
                    }
                }
                
                private void editarClienteSelectivo() {
                    System.out.println("Escriba el id del Cliente:");
                    String idCliente = sc.nextLine();
                    
                    mostrarClienteActual(idCliente);
                    
                    System.out.println("¿Cambiar estado de aprobación? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("¿Está aprobado? (true/false):");
                        boolean aprobado = sc.nextBoolean();
                        sc.nextLine();
                        editar.editarCampo("Cliente", "id_cliente", idCliente, "aprobado", aprobado);
                    }
                }
                
                private void editarClienteEmpresaSelectivo() {
                    System.out.println("Escriba el id del Cliente Empresa:");
                    String idCliente = sc.nextLine();
                    
                    mostrarClienteEmpresaActual(idCliente);
                    
                    System.out.println("¿Cambiar RUC? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo RUC:");
                        String ruc = sc.nextLine();
                        editar.editarCampo("cliente_empresa", "id_cliente", idCliente, "RUC", ruc);
                    }
                    
                    System.out.println("¿Cambiar nombre de la empresa? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo nombre:");
                        String nombre = sc.nextLine();
                        editar.editarCampo("cliente_empresa", "id_cliente", idCliente, "nombre", nombre);
                    }
                }
                
                private void editarClienteNaturalSelectivo() {
                    System.out.println("Escriba el id del Cliente Natural:");
                    String idCliente = sc.nextLine();
                    
                    mostrarClienteNaturalActual(idCliente);
                    
                    System.out.println("¿Cambiar cedula? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nueva cedula:");
                        String cedula = sc.nextLine();
                        editar.editarCampo("cliente_natural", "id_cliente", idCliente, "cedula", cedula);
                    }
                    
                    System.out.println("¿Cambiar nombre? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo nombre:");
                        String nombre = sc.nextLine();
                        editar.editarCampo("cliente_natural", "id_cliente", idCliente, "nombre", nombre);
                    }
                    
                    System.out.println("¿Cambiar apellido? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo apellido:");
                        String apellido = sc.nextLine();
                        editar.editarCampo("cliente_natural", "id_cliente", idCliente, "apellido", apellido);
                    }
                }
                
                private void editarContratoSelectivo() {
                    System.out.println("Escriba el numero de Contrato:");
                    String noContrato = sc.nextLine();
                    
                    mostrarContratoActual(noContrato);
                    
                    System.out.println("¿Cambiar id de Sucursal? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo id de Sucursal:");
                        String idSucursal = sc.nextLine();
                        editar.editarCampo("Contrato", "noContrato", noContrato, "id_sucursal", idSucursal);
                    }
                    
                    System.out.println("¿Cambiar id de Cliente? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo id de Cliente:");
                        String idCliente = sc.nextLine();
                        editar.editarCampo("Contrato", "noContrato", noContrato, "id_cliente", idCliente);
                    }
                    
                    System.out.println("¿Cambiar tipo de contrato? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo tipo de contrato:");
                        String tipoContrato = sc.nextLine();
                        editar.editarCampo("Contrato", "noContrato", noContrato, "tipo_contrato", tipoContrato);
                    }
                    
                    System.out.println("¿Cambiar fecha de emision? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nueva fecha de emision (YYYY-MM-DD):");
                        String fechaStr = sc.nextLine();
                        Date fecha = Date.valueOf(fechaStr);
                        editar.editarCampo("Contrato", "noContrato", noContrato, "fecha_emision", fecha);
                    }
                    
                    System.out.println("¿Cambiar seguro? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("¿Tiene seguro? (true/false):");
                        boolean seguro = sc.nextBoolean();
                        sc.nextLine();
                        editar.editarCampo("Contrato", "noContrato", noContrato, "seguro", seguro);
                    }
                    
                    System.out.println("¿Cambiar estado? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("¿Está activo? (true/false):");
                        boolean estado = sc.nextBoolean();
                        sc.nextLine();
                        editar.editarCampo("Contrato", "noContrato", noContrato, "estado", estado);
                    }
                    
                    System.out.println("¿Cambiar kilometros establecidos? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevos kilometros establecidos:");
                        String km = sc.nextLine();
                        editar.editarCampo("Contrato", "noContrato", noContrato, "km_establecidos", km);
                    }
                    
                    System.out.println("¿Cambiar dia de pago? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo dia de pago (YYYY-MM-DD):");
                        String fechaStr = sc.nextLine();
                        Date fecha = Date.valueOf(fechaStr);
                        editar.editarCampo("Contrato", "noContrato", noContrato, "dia_pago", fecha);
                    }
                }
                
                private void editarCorreoClienteSelectivo() {
                    System.out.println("Escriba el id del Cliente:");
                    String idCliente = sc.nextLine();
                    System.out.println("Escriba el correo actual:");
                    String correoActual = sc.nextLine();
                    System.out.println("Escriba el nuevo correo:");
                    String correoNuevo = sc.nextLine();
                    editar.editarCorreoCliente(idCliente, correoActual, correoNuevo);
                }
                
                private void editarCorreoEmpleadoSelectivo() {
                    System.out.println("Escriba la cedula del Empleado:");
                    String cedula = sc.nextLine();
                    System.out.println("Escriba el correo actual:");
                    String correoActual = sc.nextLine();
                    System.out.println("Escriba el nuevo correo:");
                    String correoNuevo = sc.nextLine();
                    editar.editarCorreoEmpleado(cedula, correoActual, correoNuevo);
                }
                
                private void editarEmpleadoSelectivo() {
                    System.out.println("Escriba la cedula del Empleado:");
                    String cedula = sc.nextLine();
                    
                    mostrarEmpleadoActual(cedula);
                    
                    System.out.println("¿Cambiar nombre? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo nombre:");
                        String nombre = sc.nextLine();
                        editar.editarCampo("Empleados", "cedula", cedula, "nombre", nombre);
                    }
                    
                    System.out.println("¿Cambiar apellido? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo apellido:");
                        String apellido = sc.nextLine();
                        editar.editarCampo("Empleados", "cedula", cedula, "apellido", apellido);
                    }
                    
                    System.out.println("¿Cambiar cargo? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo cargo:");
                        String cargo = sc.nextLine();
                        editar.editarCampo("Empleados", "cedula", cedula, "cargo", cargo);
                    }
                    
                    System.out.println("¿Cambiar id de Sucursal? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo id de Sucursal:");
                        String idSucursal = sc.nextLine();
                        editar.editarCampo("Empleados", "cedula", cedula, "id_sucursal", idSucursal);
                    }
                }
                
                private void editarFacturaSelectivo() {
                    System.out.println("Escriba el numero de Factura:");
                    String noFactura = sc.nextLine();
                    
                    mostrarFacturaActual(noFactura);
                    
                    System.out.println("¿Cambiar fecha de emision? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nueva fecha de emision (YYYY-MM-DD):");
                        String fechaStr = sc.nextLine();
                        Date fecha = Date.valueOf(fechaStr);
                        editar.editarCampo("Factura", "noFactura", noFactura, "fecha_emision", fecha);
                    }
                    
                    System.out.println("¿Cambiar estado de pago? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo estado de pago:");
                        String estado = sc.nextLine();
                        editar.editarCampo("Factura", "noFactura", noFactura, "estado_pago", estado);
                    }
                    
                    System.out.println("¿Cambiar fecha de pago? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nueva fecha de pago (YYYY-MM-DD):");
                        String fechaStr = sc.nextLine();
                        Date fecha = Date.valueOf(fechaStr);
                        editar.editarCampo("Factura", "noFactura", noFactura, "fecha_pago", fecha);
                    }
                    
                    System.out.println("¿Cambiar monto? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo monto:");
                        BigDecimal monto = sc.nextBigDecimal();
                        sc.nextLine();
                        editar.editarCampo("Factura", "noFactura", noFactura, "monto", monto);
                    }
                    
                    System.out.println("¿Cambiar metodo de pago? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo metodo de pago:");
                        String metodo = sc.nextLine();
                        editar.editarCampo("Factura", "noFactura", noFactura, "metodo_pago", metodo);
                    }
                }
                
                private void editarFacturaEmitidaSelectivo() {
                    System.out.println("Escriba el numero de Factura:");
                    String noFactura = sc.nextLine();
                    System.out.println("Escriba el id del Anexo:");
                    String idAnexo = sc.nextLine();
                    System.out.println("Escriba el id de la Multa:");
                    String idMulta = sc.nextLine();
                    editar.editarFacturaEmitida(noFactura, idAnexo, idMulta);
                }
                
                private void editarMantenimientoSelectivo() {
                    System.out.println("Escriba el id del servicio de mantenimiento:");
                    String idServicio = sc.nextLine();
                    
                    mostrarMantenimientoActual(idServicio);
                    
                    System.out.println("¿Cambiar causa? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nueva causa:");
                        String causa = sc.nextLine();
                        editar.editarCampo("Mantenimientos", "id_servicio_mantemiento", idServicio, "causa", causa);
                    }
                }
                
                private void editarModificacionSelectivo() {
                    System.out.println("Escriba el id del servicio de modificacion:");
                    String idServicio = sc.nextLine();
                    
                    mostrarModificacionActual(idServicio);
                    
                    System.out.println("¿Cambiar tipo de modificacion? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo tipo de modificacion:");
                        String tipo = sc.nextLine();
                        editar.editarCampo("Modificaciones", "id_servicio_modificacion", idServicio, "tipo_modificacion", tipo);
                    }
                }
                
                private void editarMultaSelectivo() {
                    System.out.println("Escriba el id de la Multa:");
                    String idMulta = sc.nextLine();
                    
                    mostrarMultaActual(idMulta);
                    
                    System.out.println("¿Cambiar id del Cliente? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo id del Cliente:");
                        String idCliente = sc.nextLine();
                        editar.editarCampo("Multa", "id_multa", idMulta, "id_cliente", idCliente);
                    }
                    
                    System.out.println("¿Cambiar fecha? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nueva fecha (YYYY-MM-DD):");
                        String fechaStr = sc.nextLine();
                        Date fecha = Date.valueOf(fechaStr);
                        editar.editarCampo("Multa", "id_multa", idMulta, "fecha", fecha);
                    }
                    
                    System.out.println("¿Cambiar causa? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nueva causa:");
                        String causa = sc.nextLine();
                        editar.editarCampo("Multa", "id_multa", idMulta, "causa", causa);
                    }
                    
                    System.out.println("¿Cambiar costo? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo costo:");
                        BigDecimal costo = sc.nextBigDecimal();
                        sc.nextLine();
                        editar.editarCampo("Multa", "id_multa", idMulta, "costo", costo);
                    }
                }
                
                private void editarOrdenCompraSelectivo() {
                    System.out.println("Escriba el id de la Orden de Compra:");
                    String idOrden = sc.nextLine();
                    
                    mostrarOrdenCompraActual(idOrden);
                    
                    System.out.println("¿Cambiar id del Anexo? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo id del Anexo:");
                        String idAnexo = sc.nextLine();
                        editar.editarCampo("Orden_Compra", "id_orden_compra", idOrden, "id_anexo", idAnexo);
                    }
                    
                    System.out.println("¿Cambiar fecha de emision? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nueva fecha de emision (YYYY-MM-DD):");
                        String fechaStr = sc.nextLine();
                        Date fecha = Date.valueOf(fechaStr);
                        editar.editarCampo("Orden_Compra", "id_orden_compra", idOrden, "fecha_emision", fecha);
                    }
                    
                    System.out.println("¿Cambiar estado? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo estado:");
                        String estado = sc.nextLine();
                        editar.editarCampo("Orden_Compra", "id_orden_compra", idOrden, "estado", estado);
                    }
                    
                    System.out.println("¿Cambiar fecha de entrega? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nueva fecha de entrega (YYYY-MM-DD):");
                        String fechaStr = sc.nextLine();
                        Date fecha = Date.valueOf(fechaStr);
                        editar.editarCampo("Orden_Compra", "id_orden_compra", idOrden, "fecha_entrega", fecha);
                    }
                    
                    System.out.println("¿Cambiar monto? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo monto:");
                        BigDecimal monto = sc.nextBigDecimal();
                        sc.nextLine();
                        editar.editarCampo("Orden_Compra", "id_orden_compra", idOrden, "monto", monto);
                    }
                    
                    System.out.println("¿Cambiar concesionaria? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nueva concesionaria:");
                        String concesionaria = sc.nextLine();
                        editar.editarCampo("Orden_Compra", "id_orden_compra", idOrden, "concecionaria", concesionaria);
                    }
                }
                
                private void editarServicioSelectivo() {
                    System.out.println("Escriba el id del Servicio:");
                    String idServicio = sc.nextLine();
                    
                    mostrarServicioActual(idServicio);
                    
                    System.out.println("¿Cambiar fecha? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nueva fecha (YYYY-MM-DD):");
                        String fechaStr = sc.nextLine();
                        Date fecha = Date.valueOf(fechaStr);
                        editar.editarCampo("Servicios", "id_servicio", idServicio, "fecha", fecha);
                    }
                    
                    System.out.println("¿Cambiar costo? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo costo:");
                        BigDecimal costo = sc.nextBigDecimal();
                        sc.nextLine();
                        editar.editarCampo("Servicios", "id_servicio", idServicio, "costo", costo);
                    }
                    
                    System.out.println("¿Cambiar lugar? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo lugar:");
                        String lugar = sc.nextLine();
                        editar.editarCampo("Servicios", "id_servicio", idServicio, "lugar", lugar);
                    }
                }
                
                private void editarSucursalSelectivo() {
                    System.out.println("Escriba el id de la Sucursal:");
                    String idSucursal = sc.nextLine();
                    
                    mostrarSucursalActual(idSucursal);
                    
                    System.out.println("¿Cambiar ciudad? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nueva ciudad:");
                        String ciudad = sc.nextLine();
                        editar.editarCampo("Sucursal", "id_sucursal", idSucursal, "ciudad", ciudad);
                    }
                    
                    System.out.println("¿Cambiar direccion? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nueva direccion:");
                        String direccion = sc.nextLine();
                        editar.editarCampo("Sucursal", "id_sucursal", idSucursal, "direccion", direccion);
                    }
                }
                
                private void editarTelefonoClienteSelectivo() {
                    System.out.println("Escriba el id del Cliente:");
                    String idCliente = sc.nextLine();
                    System.out.println("Escriba el telefono actual:");
                    String telefonoActual = sc.nextLine();
                    System.out.println("Escriba el nuevo telefono:");
                    String telefonoNuevo = sc.nextLine();
                    editar.editarTelefonoCliente(idCliente, telefonoActual, telefonoNuevo);
                }
                
                private void editarTelefonoEmpleadoSelectivo() {
                    System.out.println("Escriba la cedula del Empleado:");
                    String cedula = sc.nextLine();
                    System.out.println("Escriba el telefono actual:");
                    String telefonoActual = sc.nextLine();
                    System.out.println("Escriba el nuevo telefono:");
                    String telefonoNuevo = sc.nextLine();
                    editar.editarTelefonoEmpleado(cedula, telefonoActual, telefonoNuevo);
                }
                
                private void editarVehiculoSelectivo() {
                    System.out.println("Escriba la placa del Vehiculo:");
                    String placa = sc.nextLine();
                    
                    mostrarVehiculoActual(placa);
                    
                    System.out.println("¿Cambiar id del Anexo? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo id del Anexo:");
                        String idAnexo = sc.nextLine();
                        editar.editarCampo("Vehiculos", "placa", placa, "id_anexo", idAnexo);
                    }
                    
                    System.out.println("¿Cambiar id de Orden de Compra? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo id de Orden de Compra:");
                        String idOrden = sc.nextLine();
                        editar.editarCampo("Vehiculos", "placa", placa, "id_orden_compra", idOrden);
                    }
                    
                    System.out.println("¿Cambiar modelo? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo modelo:");
                        String modelo = sc.nextLine();
                        editar.editarCampo("Vehiculos", "placa", placa, "modelo", modelo);
                    }
                    
                    System.out.println("¿Cambiar marca? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nueva marca:");
                        String marca = sc.nextLine();
                        editar.editarCampo("Vehiculos", "placa", placa, "marca", marca);
                    }
                    
                    System.out.println("¿Cambiar chasis? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo chasis:");
                        String chasis = sc.nextLine();
                        editar.editarCampo("Vehiculos", "placa", placa, "chasis", chasis);
                    }
                    
                    System.out.println("¿Cambiar tipo de vehiculo? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo tipo de vehiculo:");
                        String tipo = sc.nextLine();
                        editar.editarCampo("Vehiculos", "placa", placa, "tipo_vehiculo", tipo);
                    }
                    
                    System.out.println("¿Cambiar kilometraje? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo kilometraje:");
                        BigDecimal km = sc.nextBigDecimal();
                        sc.nextLine();
                        editar.editarCampo("Vehiculos", "placa", placa, "kilometraje", km);
                    }
                    
                    System.out.println("¿Cambiar año? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo año (YYYY-MM-DD):");
                        String fechaStr = sc.nextLine();
                        Date año = Date.valueOf(fechaStr);
                        editar.editarCampo("Vehiculos", "placa", placa, "año", año);
                    }
                    
                    System.out.println("¿Cambiar RAMV? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo RAMV:");
                        String ramv = sc.nextLine();
                        editar.editarCampo("Vehiculos", "placa", placa, "ramv", ramv);
                    }
                    
                    System.out.println("¿Cambiar estado? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo estado:");
                        String estado = sc.nextLine();
                        editar.editarCampo("Vehiculos", "placa", placa, "estado", estado);
                    }
                    
                    System.out.println("¿Cambiar PVP? (s/n):");
                    if (sc.nextLine().equalsIgnoreCase("s")) {
                        System.out.println("Nuevo PVP:");
                        BigDecimal pvp = sc.nextBigDecimal();
                        sc.nextLine();
                        editar.editarCampo("Vehiculos", "placa", placa, "pvp", pvp);
                    }
                }
                
                // MÉTODOS PARA MOSTRAR VALORES ACTUALES - Agregar estos métodos:
                
                private void mostrarAnexoActual(String idAnexo) {
                    try {
                        Connection conn = DBconnection.getInstance().getConnection();
                        String sql = "SELECT * FROM Anexo WHERE id_anexo = ?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, idAnexo);
                        ResultSet rs = ps.executeQuery();
                        
                        if (rs.next()) {
                            System.out.println("=== VALORES ACTUALES ===");
                            System.out.println("ID Anexo: " + rs.getString("id_anexo"));
                            System.out.println("No. Contrato: " + rs.getString("noContrato"));
                            System.out.println("Fecha Inicio: " + rs.getDate("fecha_inicio"));
                            System.out.println("Tipo Uso Operativo: " + rs.getString("tipo_uso_operativo"));
                            System.out.println("Fecha Fin: " + rs.getDate("fecha_fin"));
                            System.out.println("Costo: " + rs.getBigDecimal("costo"));
                            System.out.println("========================");
                        } else {
                            System.out.println("No se encontró el anexo con ID: " + idAnexo);
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al consultar anexo: " + e.getMessage());
                    }
                }
                
                private void mostrarClienteActual(String idCliente) {
                    try {
                        Connection conn = DBconnection.getInstance().getConnection();
                        String sql = "SELECT * FROM Cliente WHERE id_cliente = ?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, idCliente);
                        ResultSet rs = ps.executeQuery();
                        
                        if (rs.next()) {
                            System.out.println("=== VALORES ACTUALES ===");
                            System.out.println("ID Cliente: " + rs.getString("id_cliente"));
                            System.out.println("Aprobado: " + rs.getBoolean("aprobado"));
                            System.out.println("========================");
                        } else {
                            System.out.println("No se encontró el cliente con ID: " + idCliente);
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al consultar cliente: " + e.getMessage());
                    }
                }
                
                private void mostrarClienteEmpresaActual(String idCliente) {
                    try {
                        Connection conn = DBconnection.getInstance().getConnection();
                        String sql = "SELECT * FROM cliente_empresa WHERE id_cliente = ?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, idCliente);
                        ResultSet rs = ps.executeQuery();
                        
                        if (rs.next()) {
                            System.out.println("=== VALORES ACTUALES ===");
                            System.out.println("ID Cliente: " + rs.getString("id_cliente"));
                            System.out.println("RUC: " + rs.getString("RUC"));
                            System.out.println("Nombre: " + rs.getString("nombre"));
                            System.out.println("========================");
                        } else {
                            System.out.println("No se encontró el cliente empresa con ID: " + idCliente);
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al consultar cliente empresa: " + e.getMessage());
                    }
                }
                
                private void mostrarClienteNaturalActual(String idCliente) {
                    try {
                        Connection conn = DBconnection.getInstance().getConnection();
                        String sql = "SELECT * FROM cliente_natural WHERE id_cliente = ?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, idCliente);
                        ResultSet rs = ps.executeQuery();
                        
                        if (rs.next()) {
                            System.out.println("=== VALORES ACTUALES ===");
                            System.out.println("ID Cliente: " + rs.getString("id_cliente"));
                            System.out.println("Cedula: " + rs.getString("cedula"));
                            System.out.println("Nombre: " + rs.getString("nombre"));
                            System.out.println("Apellido: " + rs.getString("apellido"));
                            System.out.println("========================");
                        } else {
                            System.out.println("No se encontró el cliente natural con ID: " + idCliente);
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al consultar cliente natural: " + e.getMessage());
                    }
                }
                
                private void mostrarContratoActual(String noContrato) {
                    try {
                        Connection conn = DBconnection.getInstance().getConnection();
                        String sql = "SELECT * FROM Contrato WHERE noContrato = ?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, noContrato);
                        ResultSet rs = ps.executeQuery();
                        
                        if (rs.next()) {
                            System.out.println("=== VALORES ACTUALES ===");
                            System.out.println("No. Contrato: " + rs.getString("noContrato"));
                            System.out.println("ID Sucursal: " + rs.getString("id_sucursal"));
                            System.out.println("ID Cliente: " + rs.getString("id_cliente"));
                            System.out.println("Tipo Contrato: " + rs.getString("tipo_contrato"));
                            System.out.println("Fecha Emision: " + rs.getDate("fecha_emision"));
                            System.out.println("Seguro: " + rs.getBoolean("seguro"));
                            System.out.println("Estado: " + rs.getBoolean("estado"));
                            System.out.println("KM Establecidos: " + rs.getString("km_establecidos"));
                            System.out.println("Dia Pago: " + rs.getDate("dia_pago"));
                            System.out.println("========================");
                        } else {
                            System.out.println("No se encontró el contrato No: " + noContrato);
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al consultar contrato: " + e.getMessage());
                    }
                }
                
                private void mostrarEmpleadoActual(String cedula) {
                    try {
                        Connection conn = DBconnection.getInstance().getConnection();
                        String sql = "SELECT * FROM Empleados WHERE cedula = ?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, cedula);
                        ResultSet rs = ps.executeQuery();
                        
                        if (rs.next()) {
                            System.out.println("=== VALORES ACTUALES ===");
                            System.out.println("Cedula: " + rs.getString("cedula"));
                            System.out.println("Nombre: " + rs.getString("nombre"));
                            System.out.println("Apellido: " + rs.getString("apellido"));
                            System.out.println("Cargo: " + rs.getString("cargo"));
                            System.out.println("ID Sucursal: " + rs.getString("id_sucursal"));
                            System.out.println("========================");
                        } else {
                            System.out.println("No se encontró el empleado con cedula: " + cedula);
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al consultar empleado: " + e.getMessage());
                    }
                }
                
                private void mostrarFacturaActual(String noFactura) {
                    try {
                        Connection conn = DBconnection.getInstance().getConnection();
                        String sql = "SELECT * FROM Factura WHERE noFactura = ?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, noFactura);
                        ResultSet rs = ps.executeQuery();
                        
                        if (rs.next()) {
                            System.out.println("=== VALORES ACTUALES ===");
                            System.out.println("No. Factura: " + rs.getString("noFactura"));
                            System.out.println("Fecha Emision: " + rs.getDate("fecha_emision"));
                            System.out.println("Estado Pago: " + rs.getString("estado_pago"));
                            System.out.println("Fecha Pago: " + rs.getDate("fecha_pago"));
                            System.out.println("Monto: " + rs.getBigDecimal("monto"));
                            System.out.println("Metodo Pago: " + rs.getString("metodo_pago"));
                            System.out.println("========================");
                        } else {
                            System.out.println("No se encontró la factura No: " + noFactura);
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al consultar factura: " + e.getMessage());
                    }
                }
                
                private void mostrarMantenimientoActual(String idServicio) {
                    try {
                        Connection conn = DBconnection.getInstance().getConnection();
                        String sql = "SELECT * FROM Mantenimientos WHERE id_servicio_mantemiento = ?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, idServicio);
                        ResultSet rs = ps.executeQuery();
                        
                        if (rs.next()) {
                            System.out.println("=== VALORES ACTUALES ===");
                            System.out.println("ID Servicio Mantenimiento: " + rs.getString("id_servicio_mantemiento"));
                            System.out.println("Causa: " + rs.getString("causa"));
                            System.out.println("========================");
                        } else {
                            System.out.println("No se encontró el mantenimiento con ID: " + idServicio);
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al consultar mantenimiento: " + e.getMessage());
                    }
                }
                
                private void mostrarModificacionActual(String idServicio) {
                    try {
                        Connection conn = DBconnection.getInstance().getConnection();
                        String sql = "SELECT * FROM Modificaciones WHERE id_servicio_modificacion = ?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, idServicio);
                        ResultSet rs = ps.executeQuery();
                        
                        if (rs.next()) {
                            System.out.println("=== VALORES ACTUALES ===");
                            System.out.println("ID Servicio Modificacion: " + rs.getString("id_servicio_modificacion"));
                            System.out.println("Tipo Modificacion: " + rs.getString("tipo_modificacion"));
                            System.out.println("========================");
                        } else {
                            System.out.println("No se encontró la modificacion con ID: " + idServicio);
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al consultar modificacion: " + e.getMessage());
                    }
                }
                
                private void mostrarMultaActual(String idMulta) {
                    try {
                        Connection conn = DBconnection.getInstance().getConnection();
                        String sql = "SELECT * FROM Multa WHERE id_multa = ?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, idMulta);
                        ResultSet rs = ps.executeQuery();
                        
                        if (rs.next()) {
                            System.out.println("=== VALORES ACTUALES ===");
                            System.out.println("ID Multa: " + rs.getString("id_multa"));
                            System.out.println("ID Cliente: " + rs.getString("id_cliente"));
                            System.out.println("Fecha: " + rs.getDate("fecha"));
                            System.out.println("Causa: " + rs.getString("causa"));
                            System.out.println("Costo: " + rs.getBigDecimal("costo"));
                            System.out.println("========================");
                        } else {
                            System.out.println("No se encontró la multa con ID: " + idMulta);
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al consultar multa: " + e.getMessage());
                    }
                }
                
                private void mostrarOrdenCompraActual(String idOrden) {
                    try {
                        Connection conn = DBconnection.getInstance().getConnection();
                        String sql = "SELECT * FROM Orden_Compra WHERE id_orden_compra = ?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, idOrden);
                        ResultSet rs = ps.executeQuery();
                        
                        if (rs.next()) {
                            System.out.println("=== VALORES ACTUALES ===");
                            System.out.println("ID Orden Compra: " + rs.getString("id_orden_compra"));
                            System.out.println("ID Anexo: " + rs.getString("id_anexo"));
                            System.out.println("Fecha Emision: " + rs.getDate("fecha_emision"));
                            System.out.println("Estado: " + rs.getString("estado"));
                            System.out.println("Fecha Entrega: " + rs.getDate("fecha_entrega"));
                            System.out.println("Monto: " + rs.getBigDecimal("monto"));
                            System.out.println("Concesionaria: " + rs.getString("concecionaria"));
                            System.out.println("========================");
                        } else {
                            System.out.println("No se encontró la orden de compra con ID: " + idOrden);
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al consultar orden de compra: " + e.getMessage());
                    }
                }
                
                private void mostrarServicioActual(String idServicio) {
                    try {
                        Connection conn = DBconnection.getInstance().getConnection();
                        String sql = "SELECT * FROM Servicios WHERE id_servicio = ?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, idServicio);
                        ResultSet rs = ps.executeQuery();
                        
                        if (rs.next()) {
                            System.out.println("=== VALORES ACTUALES ===");
                            System.out.println("ID Servicio: " + rs.getString("id_servicio"));
                            System.out.println("Fecha: " + rs.getDate("fecha"));
                            System.out.println("Costo: " + rs.getBigDecimal("costo"));
                            System.out.println("Lugar: " + rs.getString("lugar"));
                            System.out.println("========================");
                        } else {
                            System.out.println("No se encontró el servicio con ID: " + idServicio);
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al consultar servicio: " + e.getMessage());
                    }
                }
                
                private void mostrarSucursalActual(String idSucursal) {
                    try {
                        Connection conn = DBconnection.getInstance().getConnection();
                        String sql = "SELECT * FROM Sucursal WHERE id_sucursal = ?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, idSucursal);
                        ResultSet rs = ps.executeQuery();
                        
                        if (rs.next()) {
                            System.out.println("=== VALORES ACTUALES ===");
                            System.out.println("ID Sucursal: " + rs.getString("id_sucursal"));
                            System.out.println("Ciudad: " + rs.getString("ciudad"));
                            System.out.println("Direccion: " + rs.getString("direccion"));
                            System.out.println("========================");
                        } else {
                            System.out.println("No se encontró la sucursal con ID: " + idSucursal);
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al consultar sucursal: " + e.getMessage());
                    }
                }
                
                private void mostrarVehiculoActual(String placa) {
                    try {
                        Connection conn = DBconnection.getInstance().getConnection();
                        String sql = "SELECT * FROM Vehiculos WHERE placa = ?";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, placa);
                        ResultSet rs = ps.executeQuery();
                        
                        if (rs.next()) {
                            System.out.println("=== VALORES ACTUALES ===");
                            System.out.println("Placa: " + rs.getString("placa"));
                            System.out.println("ID Anexo: " + rs.getString("id_anexo"));
                            System.out.println("ID Orden Compra: " + rs.getString("id_orden_compra"));
                            System.out.println("Modelo: " + rs.getString("modelo"));
                            System.out.println("Marca: " + rs.getString("marca"));
                            System.out.println("Chasis: " + rs.getString("chasis"));
                            System.out.println("Tipo Vehiculo: " + rs.getString("tipo_vehiculo"));
                            System.out.println("Kilometraje: " + rs.getBigDecimal("kilometraje"));
                            System.out.println("Año: " + rs.getDate("año"));
                            System.out.println("RAMV: " + rs.getString("ramv"));
                            System.out.println("Estado: " + rs.getString("estado"));
                            System.out.println("PVP: " + rs.getBigDecimal("pvp"));
                            System.out.println("========================");
                        } else {
                            System.out.println("No se encontró el vehiculo con placa: " + placa);
                        }
                    } catch (SQLException e) {
                        System.out.println("Error al consultar vehiculo: " + e.getMessage());
        }
    }
}
