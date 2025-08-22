/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.carrent;

import java.util.Scanner;

/**
 *
 * @author Nueva
 */
public class Interfaz {
    Scanner sc = new Scanner(System.in);
    IngresoDatos iD = new IngresoDatos();
    IngresoDatosEliminar iDE = new IngresoDatosEliminar();
    Consultar c = new Consultar();
    
    public void inicio(){
        
        int opcion;
        
        do {
            System.out.println("-----CarRent-----");
            System.out.println("1. Añadir");
            System.out.println("2. Consultar");
            System.out.println("3. Editar");
            System.out.println("4. Eliminar");  
            System.out.println("5. SALIR");
            
            opcion = sc.nextInt();
            opciones(opcion);

        } while (opcion != 5);

    }
    
    public void opciones(int opcion){
        switch (opcion){
            case 1:
                añadir();
                break;
            case 2:
                consultar();
                break;
            case 3:
                editar();
                break;
            case 4:
                eliminar();
                break;
            default:
                System.out.println("Opcion incorrecta");  
                inicio();
        }
    }
    
    public void añadir(){
        int opcion = mostrarMenuAñadir();
        
        switch (opcion){
            case 1:
                eligirTipoCliente();
                break;
            case 2:
                iD.ingresarSucursal();
                break;
            case 3:
                iD.ingresarEmpleado();
                break;
            case 4:
                iD.ingresarContrato();
                break;
            case 5:
                iD.insertarAnexo();
                break;
            case 6:
                iD.ingresarOrdenCompra();
                break;
            case 7:
                iD.ingresarVehiculo();
                break;
            case 8:
                eligirTipoServicio();
                break;    
            case 9:
                elegirTipoFactura();
                break;
            case 10:
                iD.ingresarMulta();
                break;
                
        }
    }
    
    public void eliminar(){
        int opcion = mostrarMenuEliminar();

        switch (opcion){
            case 1:
                iDE.eliminarCliente();
                break;
            case 2:
                iDE.eliminarVehiculo();
                break;
            case 3:
                iDE.eliminarAnexo();
                break;
            case 4:
                iDE.eliminarFactura();
                break;
            case 5:
                iDE.eliminarSucursal();
                break;
            case 6:
                iDE.eliminarContrato();
                break;
            case 7:
                iDE.eliminarOrdenDeCompra();
                break;
            case 8:
                iDE.eliminarEmpleado();
                break;    
            case 9:
                iDE.eliminarMulta();
                break;
            case 10:
                iDE.elimnarServicio();
                break;
            case 11:
                iDE.eliminarModificacion();
                break;    
            case 12:
                iDE.eliminarMantenimiento();
                break;    
        }
    }
    
    public int mostrarMenuEditar() {
        System.out.println("===== MENÚ EDITAR =====");
        System.out.println("Seleccione qué desea editar:");
        System.out.println("1. Cliente");
        System.out.println("2. Cliente Natural");
        System.out.println("3. Cliente Empresa");
        System.out.println("4. Vehículo");
        System.out.println("5. Empleado");
        System.out.println("6. Contrato");
        System.out.println("7. Sucursal");
        System.out.println("8. Factura");
        System.out.println("9. Multa");
        System.out.println("10. SALIR");
    
        int opcion = sc.nextInt();
        sc.nextLine(); // limpiar buffer
    
        return opcion;
    }

    Editar Editar = new Editar();

    public void editar(){
        int opcion = mostrarMenuEditar();
    
    switch (opcion){
        case 1:
            Editar.editarCliente();
            break;
        case 2:
            Editar.editarClienteNatural();
            break;
        case 3:
            Editar.editarClienteEmpresa();
            break;
        case 4:
            Editar.editarVehiculo();
            break;
        case 5:
            Editar.editarEmpleado();
            break;
        case 6:
            Editar.editarContrato();
            break;
        case 7:
            Editar.editarSucursal();
            break;
        case 8:
            Editar.editarFactura();
            break;
        case 9:
            Editar.editarMulta();
            break;
        default:
            if (opcion != 10){
                System.out.println("Opción incorrecta");
            }else{
                break;
            }
        }
    }
    
    public void consultar(){
        int opcion = mostrarMenuConsultar();
        
        switch (opcion) {
            case 1:
                c.consultarAnexo();
                break;
            case 2:
                c.consultarCliente();
                break;
            case 3:
                c.consultarClienteEmpresa();
               break;
            case 4:
                c.consultarClienteNatural();
                break;
            case 5:
                c.consultarContrato();
                break;
            case 6:
                c.consultarCorreoCliente();
                break;
            case 7:
                c.consultarCorreoEmpleado();
                break;
            case 8:
                c.consultarEmpleado();
                break;
            case 9:
                c.consultarFactura();
                break;
            case 10:
                c.consultarFacturaEmitida();
                break;
            case 11:
                c.consultarFacturaRecibida();
                break;
            case 12:
                c.consultarFacturaRecibidaServicio();
                break;
            case 13:
                c.consultarMantenimientos();
                break;
            case 14:
                c.consultarModificaciones();
                break;
            case 15:
                c.consultarMultas();
                break;
            case 16:
                c.consultarOrdenCompra();
                break;
            case 17:
                c.consultarServicios();
                break;
            case 18:
                c.consultarSucursal();
                break;
            case 19:
                c.consultarTelefonoCliente();
                break;
            case 20:
                c.consultarTelefonoEmpleado();
                break;
            case 21:
                c.consultarVehiculos();
                break;
            
        }
    }    
    
    public int mostrarMenuAñadir() {
        System.out.println("===== MENU AÑADIR =====");
        System.out.println("Seleccione una opción: ");
        System.out.println("1. Ingresar cliente");
        System.out.println("2. Ingresar sucursal");
        System.out.println("3. Ingresar empleado");
        System.out.println("4. Ingresar contrato");
        System.out.println("5. Insertar anexo");
        System.out.println("6. Ingresar orden de compra");
        System.out.println("7. Ingresar vehiculo");
        System.out.println("8. Ingresar servicio");
        System.out.println("9. Ingresar factura");
        System.out.println("10. Ingresar multa");
        System.out.println("11. SALIR");

        int opcion = sc.nextInt();
        sc.nextLine(); 

        return opcion;
    }
    
    public int mostrarMenuConsultar() {
        System.out.println("===== MENU CONSULTAS =====");
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

        int opcion = sc.nextInt();
        sc.nextLine(); 

        return opcion;
    }
    
    public int mostrarMenuEliminar() {
        System.out.println("===== MENU ELIMINAR =====");
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

        int opcion = sc.nextInt();
        sc.nextLine(); 

        return opcion;
    }
    
    public int mostrarTipoCliente() {
        System.out.println("===== ElIGIR TIPO CLIENTE =====");
        System.out.println("Seleccione una opcion: ");
        System.out.println("1. Cliente Natural");
        System.out.println("2. Empresa");
        System.out.println("3. Salir");

        int opcion = sc.nextInt();
        sc.nextLine(); 

        return opcion;
    }
    
    public int mostrarTipoSerivicio() {
        System.out.println("===== ElIGIR TIPO SERVICIO =====");
        System.out.println("Seleccione una opcion: ");
        System.out.println("1. Mantenimiento");
        System.out.println("2. Modificacion");
        System.out.println("3. Salir");

        int opcion = sc.nextInt();
        sc.nextLine(); 

        return opcion;
    }
    
    public int mostrarTipoFactura() {
        System.out.println("===== ElIGIR TIPO FACTURA =====");
        System.out.println("Seleccione una opcion: ");
        System.out.println("1. Emitida");
        System.out.println("2. Factura por orden de compra");
        System.out.println("3. Factura por servicio");
        System.out.println("4. Salir");

        int opcion = sc.nextInt();
        sc.nextLine(); 

        return opcion;
    }
    
    public void eligirTipoCliente(){
        int opcion = mostrarTipoSerivicio();
                
        switch (opcion){
            case 1:
                iD.ingresarClienteNatural();
                break;
            case 2:
                iD.ingresarClienteEmpresa();
                break;        
        }        
    }
    
    public void eligirTipoServicio(){
        int opcion = mostrarTipoSerivicio();
                
        switch (opcion){
            case 1:
                iD.ingresarMantenimiento();
                break;
            case 2:
                iD.ingresarModificacion();
                break;        
        }        
    }
    
    public void elegirTipoFactura(){
        int opcion = mostrarTipoSerivicio();
                
        switch (opcion){
            case 1:
                iD.ingresarFacturaEmitida();
                break;
            case 2:
                iD.ingresarFacturaOrdenCompra();
                break;  
            case 3:
                iD.ingresarFacturaServicio();
                break;      
        } 
    }
  
}
