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

public class IngresoDatos {
    
    Scanner sc = new Scanner(System.in);
    Añadir a = new Añadir();
    
    public void ingresarCliente(){
        System.out.println("--Cliente-- ");
        System.out.println("Ingresar un id al cliente: ");
        String idCliente = sc.nextLine();
        
        a.añadirCliente(idCliente);
        
        int tipo = tipoCliente();
        
        switch(tipo){
            case 1:
                ingresarClienteNatural(idCliente);
                ingresarNumeroCliente(idCliente);
                ingresarCorreoCliente(idCliente);
                break;
            case 2:
                ingresarEmpresa(idCliente);
                ingresarNumeroCliente(idCliente);
                ingresarCorreoCliente(idCliente);
                break;
        } 
    }
    
    
    public int tipoCliente(){
        System.out.println("Eliga el tipo de cliente: ");
        System.out.println("1. Cliente Natural ");
        System.out.println("2. Empresa ");
        
        int tipo = sc.nextInt();
        sc.nextLine();
        
        return tipo;
    }
    
    
    public void ingresarClienteNatural(String idCliente){
        System.out.println("Ingresar cedula del cliente: ");
        String cedula = sc.nextLine();
        
        System.out.println("Ingresar nombre del cliente: ");
        String nomnbre = sc.nextLine();
        
        System.out.println("Ingresar apellido del cliente: ");
        String apellido = sc.nextLine();
        
        a.añadirClienteNatural(idCliente, cedula, nomnbre, apellido);
    }
    
    
    public void ingresarEmpresa(String idCliente){
        System.out.println("Ingresar RUC: ");
        String RUC = sc.nextLine();
        
        System.out.println("Ingresar nombre de la empresa: ");
        String nomnbreEmpresa = sc.nextLine();
        
        a.añadirClienteEmpresa(idCliente, RUC, nomnbreEmpresa);
    }
    
    
    public void ingresarNumeroCliente(String idCliente){
        System.out.println("Ingresar numero de contacto: ");
        String num = sc.nextLine();
        
        a.añadirTelefenosCliente(idCliente, num);
    }
    
    
    public void ingresarCorreoCliente(String idCliente){
        System.out.println("Ingresar email de contacto: ");
        String email = sc.nextLine();
        
        a.añadirCorreoCliente(idCliente, email);
    }
    
    
    public void ingresarSucursal(){
        System.out.println("--Sucursal-- ");        
        System.out.println("Ingresar id de la nueva sucursal: ");
        String idSucursal = sc.nextLine();
        
        System.out.println("Ingresar ciudad de la nueva sucursal: ");
        String ciudad = sc.nextLine();
        
        System.out.println("Ingresar direccion de la nueva sucursal: ");
        String direccion = sc.nextLine();
        
        a.añadirSucursal(idSucursal, ciudad, direccion);
    }
    
    
    public void ingresarEmpleado(){
        System.out.println("--Empleado-- ");        
        System.out.println("Ingresar cedula del empleado: ");
        String cedula = sc.nextLine();
        
        System.out.println("Ingresar nombre del empleado: ");
        String nombre = sc.nextLine();
        
        System.out.println("Ingresar apellido del empleado: ");
        String apellido = sc.nextLine();
        
        System.out.println("Ingresar cargo del empleado: ");
        String cargo = sc.nextLine();
        
        System.out.println("Ingresar id de la sucursal donde trabaja: ");
        String idSucursal = sc.nextLine();
        
        a.añadirEmpleados(cedula, nombre, apellido, cargo, idSucursal);
        ingresarNumeroEmpleado(cedula);
        ingresarCorreoEmpleado(cedula);
    }
    
    
    public void ingresarNumeroEmpleado(String cedula){
        System.out.println("Ingresar numero de contacto: ");
        String num = sc.nextLine();
        
        a.añadirTelefenosEmpleados(cedula, num);
    }
    
    
    public void ingresarCorreoEmpleado(String cedula){
        System.out.println("Ingresar email de contacto: ");
        String email = sc.nextLine();
        
        a.añadirCorreoEmpleado(cedula, email);
    }
    
    
    public void ingresarContrato(){
        System.out.println("--Contrato-- ");         
        System.out.println("Ingresar número de contrato: ");
        String noContrato = sc.nextLine();

        System.out.println("Ingresar ID de sucursal: ");
        String idSucursal = sc.nextLine();

        System.out.println("Ingresar ID de cliente: ");
        String idCliente = sc.nextLine();

        System.out.println("Ingresar tipo de contrato: ");
        String tipoContrato = sc.nextLine();

        System.out.println("Ingresar fecha de emisión (formato dd-mm-aaaaD): ");
        String fechaEmisionStr = sc.nextLine();
        java.sql.Date fechaEmision = java.sql.Date.valueOf(fechaEmisionStr);

        boolean seguro = seguro();

        boolean contratoActivo = contratoActivo();

        System.out.println("Ingresar kilómetros establecidos: ");
        String kmEstablecidos = sc.nextLine();

        System.out.println("Ingresar día de pago (formato dd-mm-aaaaD): ");
        String diaPagoStr = sc.nextLine();
        java.sql.Date diaPago = java.sql.Date.valueOf(diaPagoStr);
        
        a.añadirContratos(noContrato, idSucursal, idCliente, tipoContrato, fechaEmision, seguro, contratoActivo, kmEstablecidos, diaPago);
    }
    
    
    public boolean seguro(){
        System.out.println("¿El contrato incluye seguro? ");
        System.out.println("1. Si ");
        System.out.println("2. No ");
        
        int respuesta = sc.nextInt();
        sc.nextLine();

        return respuesta == 1;
    }
    
    
    public boolean contratoActivo(){
        System.out.println("¿El contrato esta activo? ");
        System.out.println("1. Si ");
        System.out.println("2. No ");
        
        int respuesta = sc.nextInt();
        sc.nextLine();

        return respuesta == 1;
    }
    
    
    public void ingresarOrdenCompra(){
        System.out.println("--Orden de compra-- ");
        System.out.println("Ingresar ID de orden de compra:");
        String idOrdenCompra = sc.nextLine();

        System.out.println("Ingresar ID de anexo:");
        String idAnexo = sc.nextLine();

        System.out.println("Ingresar fecha de emisión (formato dd-mm-aaaa):");
        String fechaEmisionStr = sc.nextLine();
        java.sql.Date fechaEmision = java.sql.Date.valueOf(fechaEmisionStr);

        System.out.println("Ingresar estado de la orden:");
        String estado = sc.nextLine();

        System.out.println("Ingresar fecha de entrega (formato dd-mm-aaaa):");
        String fechaEntregaStr = sc.nextLine();
        java.sql.Date fechaEntrega = java.sql.Date.valueOf(fechaEntregaStr);

        System.out.println("Ingresar monto de la orden:");
        double monto = sc.nextDouble();
        sc.nextLine();

        System.out.println("Ingresar nombre de la concesionaria:");
        String concesionaria = sc.nextLine();
        
        a.añadirOrdenCompra(idOrdenCompra, idAnexo, fechaEmision, estado, fechaEntrega, monto, concesionaria);
    }
    
    
    public void insertarAnexo(){
        System.out.println("--Anexo-- ");
        System.out.println("Ingresar ID del anexo:");
        String idAnexo = sc.nextLine();

        System.out.println("Ingresar número de contrato relacionado:");
        String noContrato = sc.nextLine();

        System.out.println("Ingresar fecha de inicio (formato dd-mm-aaaa):");
        String fechaInicioStr = sc.nextLine();
        java.sql.Date fechaInicio = java.sql.Date.valueOf(fechaInicioStr);

        System.out.println("Ingresar tipo de uso operativo:");
        String tipoUsoOperativo = sc.nextLine();

        System.out.println("Ingresar fecha de fin (formato dd-mm-aaaa):");
        String fechaFinStr = sc.nextLine();
        java.sql.Date fechaFin = java.sql.Date.valueOf(fechaFinStr);

        System.out.println("Ingresar costo del anexo:");
        double costo = sc.nextDouble();
        sc.nextLine(); 
        
        a.añadirAnexo(idAnexo, noContrato, fechaInicio, tipoUsoOperativo, fechaFin, costo);
    }
    
    public void ingresarServicio(){
        System.out.println("--Servicio-- ");
        System.out.println("Ingresar ID del servicio:");
        String idServicio = sc.nextLine();
        
        System.out.println("Ingresar placa del vehículo:");
        String placa = sc.nextLine();

        System.out.println("Ingresar fecha del servicio (formato dd-mm-aaaa):");
        String fechaStr = sc.nextLine();
        java.sql.Date fecha = java.sql.Date.valueOf(fechaStr);

        System.out.println("Ingresar costo del servicio:");
        double costo = sc.nextDouble();
        sc.nextLine();

        System.out.println("Ingresar lugar del servicio:");
        String lugar = sc.nextLine();
        
        a.añadirServicio(idServicio, fecha, costo, lugar);
        
        int tipoServicio = tipoServicio();
        
        switch(tipoServicio){
            case 1:
                ingresarMantemiento(idServicio);
                break;
            case 2:
                ingresarModificacion(idServicio);
                break;
        }
        
        a.añadirVehiculoServicio(placa, idServicio);
    }
    
    public int tipoServicio(){
        System.out.println("Eliga el tipo de servicio: ");
        System.out.println("1. Manteminiento ");
        System.out.println("2. Modificacion ");
        
        int tipo = sc.nextInt();
        sc.nextLine();
        
        return tipo;
    }
    
    public void ingresarModificacion(String idServicio){
        System.out.println("Ingresar tipo de modificación:");
        String tipoModificacion = sc.nextLine();
        
        a.añadirFacturaRecibida(idServicio, tipoModificacion);
    }
    
    public void ingresarMantemiento(String idServicio){
        System.out.println("Ingresar tipo de mantemiento:");
        String tipoMantenimiento = sc.nextLine();
        
        a.añadirFacturaRecibida(idServicio, tipoMantenimiento);
    }
    
    public void ingresarVehiculo(){
        System.out.println("--Vehiculo-- ");
        System.out.println("Ingresar placa del vehículo:");
        String placa = sc.nextLine();

        System.out.println("Ingresar ID de anexo (puede ser null, dejar vacío si no tiene):");
        String idAnexo = sc.nextLine();
        if (idAnexo.isEmpty()) idAnexo = null;

        System.out.println("Ingresar ID de orden de compra:");
        String idOrdenCompra = sc.nextLine();

        System.out.println("Ingresar modelo del vehículo:");
        String modelo = sc.nextLine();

        System.out.println("Ingresar marca del vehículo:");
        String marca = sc.nextLine();

        System.out.println("Ingresar número de chasis:");
        String chasis = sc.nextLine();

        System.out.println("Ingresar tipo de vehículo:");
        String tipoVehiculo = sc.nextLine();

        System.out.println("Ingresar kilometraje:");
        double kilometraje = sc.nextDouble();
        sc.nextLine(); 

        System.out.println("Ingresar año del vehículo (formato dd-mm-aaaa):");
        String añoStr = sc.nextLine();
        java.sql.Date año = java.sql.Date.valueOf(añoStr);

        System.out.println("Ingresar RAMV:");
        String ramv = sc.nextLine();

        System.out.println("Ingresar estado del vehículo:");
        String estado = sc.nextLine();

        System.out.println("Ingresar precio de venta público (PVP):");
        double pvp = sc.nextDouble();
        sc.nextLine(); 
        
        a.añadirVehiculo(placa, idAnexo, idOrdenCompra, modelo, marca, chasis, tipoVehiculo, kilometraje, año, ramv, estado, pvp);
    }
    
    public void ingresarFactura(){
        System.out.println("--Factura-- ");
        System.out.println("Ingresar número de factura:");
        String noFactura = sc.nextLine();

        System.out.println("Ingresar fecha de emisión (formato dd-mm-aaaaD):");
        String fechaEmisionStr = sc.nextLine();
        java.sql.Date fechaEmision = java.sql.Date.valueOf(fechaEmisionStr);

        System.out.println("Ingresar estado de pago:");
        String estadoPago = sc.nextLine();

        System.out.println("Ingresar fecha de pago (formato dd-mm-aaaa):");
        String fechaPagoStr = sc.nextLine();
        java.sql.Date fechaPago = java.sql.Date.valueOf(fechaPagoStr);

        System.out.println("Ingresar monto:");
        double monto = sc.nextDouble();
        sc.nextLine(); // limpiar buffer

        System.out.println("Ingresar método de pago:");
        String metodoPago = sc.nextLine();
        
        a.añadirFactura(noFactura, fechaEmision, estadoPago, fechaPago, monto, metodoPago);
        
        int tipoFactura = tipoFactura();
        
        switch(tipoFactura){
            case 1:
                ingresarFacturaEmitida(noFactura);
                break;
            case 2:
                ingresarFacturaRecibidaOrdenCompra(noFactura);
                break;
            case 3:
                ingresarFacturaRecibidaServicio(noFactura);
                break;    
        } 
        
    }
    
    public void ingresarMulta(){
        System.out.println("--Multa-- ");
        System.out.println("Ingresar ID de la multa:");
        String idMulta = sc.nextLine();

        System.out.println("Ingresar ID del cliente:");
        String idCliente = sc.nextLine();

        System.out.println("Ingresar fecha de la multa (formato dd-mm-aaaa):");
        String fechaStr = sc.nextLine();
        java.sql.Date fecha = java.sql.Date.valueOf(fechaStr);

        System.out.println("Ingresar causa de la multa:");
        String causa = sc.nextLine();

        System.out.println("Ingresar costo de la multa:");
        double costo = sc.nextDouble();
        sc.nextLine(); 
        
        a.añadirMulta(idMulta, idCliente, fecha, causa, costo);
    }
    
    public void ingresarFacturaEmitida(String noFactura){
        System.out.println("Ingresar ID del anexo: ");
        String idAnexo = sc.nextLine();

        System.out.println("¿Desea ingresar ID de multa? (puede ser null, dejar vacío si no tiene): ");
        String opcion = sc.nextLine();
        if (opcion.isEmpty()) opcion = null;
        
        a.añadirFacturaEmitida(noFactura, idAnexo, opcion);
    }
    
    public void ingresarFacturaRecibidaServicio(String noFactura){
        System.out.println("Ingresar ID del servicio relacionado:");
        String idServicio = sc.nextLine();
        
        a.añadirFacturaRecibidaServicio(noFactura, idServicio);
    
    }
    
    public void ingresarFacturaRecibidaOrdenCompra(String noFactura){
        System.out.println("Ingresar ID de la orden de compra:");
        String idOrdenCompra = sc.nextLine();
        
        a.añadirFacturaRecibida(noFactura, idOrdenCompra);

    }
    
    public int tipoFactura(){
        System.out.println("Eliga el tipo de factura: ");
        System.out.println("1. Emitida ");
        System.out.println("2. Recibida por orden de compra ");
        System.out.println("3. Recibida por servicio ");
        
        int respuesta = sc.nextInt();
        sc.nextLine();
        
        return respuesta;
    }
}
