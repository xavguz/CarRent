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
    
    public void ingresarClienteNatural(){
        System.out.println("===== ClIENTE ===== ");
        
        System.out.println("Asignar id: ");
        String idCliente = sc.nextLine();
        
        System.out.println("Ingresar cedula: ");
        String cedula = sc.nextLine();
        
        System.out.println("Ingresar nombre: ");
        String nombre = sc.nextLine();
        
        System.out.println("Ingresar apellido: ");
        String apellido = sc.nextLine();
        
        System.out.println("Ingresar correo: ");
        String correo = sc.nextLine();
        
        System.out.println("Ingresar numero de telefono: ");
        String telefono = sc.nextLine();
        
        a.añadirClienteNatural(idCliente, cedula, nombre, apellido, correo, telefono);
    }
    
    public void ingresarClienteEmpresa(){
        System.out.println("===== ClIENTE ===== ");
        System.out.println("Asignar id: ");
        String idCliente = sc.nextLine();
        
        System.out.println("Ingresar RUC: ");
        String RUC = sc.nextLine();
        
        System.out.println("Ingresar nombre de la empresa: ");
        String nomnbreEmpresa = sc.nextLine();
        
        System.out.println("Ingresar correo: ");
        String correo = sc.nextLine();
        
        System.out.println("Ingresar numero de telefono: ");
        String telefono = sc.nextLine();
        
        a.añadirClienteEmpresa(idCliente, RUC, nomnbreEmpresa, correo, telefono);
    }
    
    public void ingresarSucursal(){
        System.out.println("===== SUCURSAL ===== ");
        
        System.out.println("Ingresar id de la nueva sucursal: ");
        String idSucursal = sc.nextLine();
        
        System.out.println("Ingresar ciudad: ");
        String ciudad = sc.nextLine();
        
        System.out.println("Ingresar direccion: ");
        String direccion = sc.nextLine();
        
        a.añadirSucursal(idSucursal, ciudad, direccion);
    }
    
    public void ingresarEmpleado(){
        System.out.println("===== EMPLEADO ===== ");
        
        System.out.println("Ingresar id de la sucursal donde trabaja: ");
        String idSucursal = sc.nextLine();
        
        System.out.println("Ingresar cedula: ");
        String cedula = sc.nextLine();
        
        System.out.println("Ingresar nombre: ");
        String nombre = sc.nextLine();
        
        System.out.println("Ingresar apellido: ");
        String apellido = sc.nextLine();
        
        System.out.println("Ingresar cargo: ");
        String cargo = sc.nextLine();
        
        System.out.println("Ingresar correo: ");
        String correo = sc.nextLine();
        
        System.out.println("Ingresar numero de telefono: ");
        String telefono = sc.nextLine();
        
        a.añadirEmpleado(idSucursal, cedula, nombre, apellido, cargo, correo, telefono);
    }
    
    public void ingresarContrato(){
        System.out.println("===== CONTRATO ===== ");
        
        System.out.println("--Contrato-- ");         
        System.out.println("Ingresar numero de contrato: ");
        String noContrato = sc.nextLine();

        System.out.println("Ingresar ID de sucursal: ");
        String idSucursal = sc.nextLine();

        System.out.println("Ingresar ID de cliente: ");
        String idCliente = sc.nextLine();

        System.out.println("Ingresar tipo de contrato: ");
        String tipoContrato = sc.nextLine();

        System.out.println("Ingresar fecha de emision (formato dd-mm-aaaaD): ");
        String fechaEmisionStr = sc.nextLine();
        java.sql.Date fechaEmision = java.sql.Date.valueOf(fechaEmisionStr);

        boolean seguro = seguro();

        boolean contratoActivo = contratoActivo();

        System.out.println("Ingresar kilometros establecidos: ");
        String kmEstablecidos = sc.nextLine();

        System.out.println("Ingresar dia de pago (formato dd-mm-aaaaD): ");
        String diaPagoStr = sc.nextLine();
        java.sql.Date diaPago = java.sql.Date.valueOf(diaPagoStr);
        
        a.añadirContrato(noContrato, idSucursal, idCliente, tipoContrato, fechaEmision, seguro, contratoActivo, kmEstablecidos, diaPago);
    }
    
    public void insertarAnexo(){
        System.out.println("===== ANEXO ===== ");
        System.out.println("Ingresar ID del anexo:");
        String idAnexo = sc.nextLine();

        System.out.println("Ingresar numero de contrato relacionado:");
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
    
    public void ingresarOrdenCompra(){
        System.out.println("===== ORDEN COMPRA ===== ");
        System.out.println("Ingresar ID de orden de compra:");
        String idOrdenCompra = sc.nextLine();

        System.out.println("Ingresar ID de anexo:");
        String idAnexo = sc.nextLine();

        System.out.println("Ingresar fecha de emision (formato dd-mm-aaaa):");
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
    
    public void ingresarVehiculo(){
        System.out.println("===== VEHICULO ===== ");
        
        System.out.println("Ingresar placa del vehiculo:");
        String placa = sc.nextLine();

        System.out.println("Ingresar ID de anexo (puede ser null, dejar vacio si no tiene):");
        String idAnexo = sc.nextLine();
        if (idAnexo.isEmpty()) idAnexo = null;

        System.out.println("Ingresar ID de orden de compra:");
        String idOrdenCompra = sc.nextLine();

        System.out.println("Ingresar modelo del vehiculo:");
        String modelo = sc.nextLine();

        System.out.println("Ingresar marca del vehiculo:");
        String marca = sc.nextLine();

        System.out.println("Ingresar numero de chasis:");
        String chasis = sc.nextLine();

        System.out.println("Ingresar tipo de vehiculo:");
        String tipoVehiculo = sc.nextLine();

        System.out.println("Ingresar kilometraje:");
        double kilometraje = sc.nextDouble();
        sc.nextLine(); 

        System.out.println("Ingresar año del vehiculo (formato dd-mm-aaaa):");
        String añoStr = sc.nextLine();
        java.sql.Date año = java.sql.Date.valueOf(añoStr);

        System.out.println("Ingresar RAMV:");
        String ramv = sc.nextLine();

        System.out.println("Ingresar estado del vehiculo:");
        String estado = sc.nextLine();

        System.out.println("Ingresar precio de venta publico (PVP):");
        double pvp = sc.nextDouble();
        sc.nextLine(); 
        
        a.añadirVehiculo(placa, idAnexo, idOrdenCompra, modelo, marca, chasis, tipoVehiculo, kilometraje, año, ramv, estado, pvp);
    }
    
    public void ingresarMulta(){
        System.out.println("===== MULTA ===== ");
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
    
    public void ingresarMantenimiento(){
        System.out.println("===== MANTENIMIENTO ===== ");
        System.out.println("Ingresar ID del servicio:");
        String idServicio = sc.nextLine();
        
        System.out.println("Ingresar placa del vehiculo:");
        String placa = sc.nextLine();

        System.out.println("Ingresar fecha del servicio (formato dd-mm-aaaa):");
        String fechaStr = sc.nextLine();
        java.sql.Date fecha = java.sql.Date.valueOf(fechaStr);

        System.out.println("Ingresar costo del servicio:");
        double costo = sc.nextDouble();
        sc.nextLine();

        System.out.println("Ingresar lugar del servicio:");
        String lugar = sc.nextLine();
        
        System.out.println("Ingresar el tipo de mantenimiento dado al vehiculo:");
        String tipo = sc.nextLine();
        
        a.añadirMantenimiento(placa, idServicio, fecha, costo, lugar, tipo);
    }
    
    public void ingresarModificacion(){
        System.out.println("===== MODIFICACION ===== ");
        System.out.println("Ingresar ID del servicio:");
        String idServicio = sc.nextLine();
        
        System.out.println("Ingresar placa del vehiculo:");
        String placa = sc.nextLine();

        System.out.println("Ingresar fecha del servicio (formato dd-mm-aaaa):");
        String fechaStr = sc.nextLine();
        java.sql.Date fecha = java.sql.Date.valueOf(fechaStr);

        System.out.println("Ingresar costo del servicio:");
        double costo = sc.nextDouble();
        sc.nextLine();

        System.out.println("Ingresar lugar del servicio:");
        String lugar = sc.nextLine();
        
        System.out.println("Ingresar el tipo de modificacion dado al vehiculo:");
        String tipo = sc.nextLine();
        
        a.añadirModificacion(placa, idServicio, fecha, costo, lugar, tipo);
    }
    
    public void ingresarFacturaEmitida(){
        System.out.println("===== FACTURRA EMITIDA ===== ");
        System.out.println("Ingresar numero de factura:");
        String noFactura = sc.nextLine();

        System.out.println("Ingresar fecha de emision (formato dd-mm-aaaaD):");
        String fechaEmisionStr = sc.nextLine();
        java.sql.Date fechaEmision = java.sql.Date.valueOf(fechaEmisionStr);

        System.out.println("Ingresar estado de pago:");
        String estadoPago = sc.nextLine();

        System.out.println("Ingresar fecha de pago (formato dd-mm-aaaa):");
        String fechaPagoStr = sc.nextLine();
        java.sql.Date fechaPago = java.sql.Date.valueOf(fechaPagoStr);

        System.out.println("Ingresar monto:");
        double monto = sc.nextDouble();
        sc.nextLine(); 

        System.out.println("Ingresar metodo de pago:");
        String metodoPago = sc.nextLine();
        
        System.out.println("Ingresar ID del anexo: ");
        String idAnexo = sc.nextLine();

        System.out.println("¿Desea ingresar ID de multa? (puede ser null, dejar vacío si no tiene): ");
        String opcion = sc.nextLine();
        if (opcion.isEmpty()) opcion = null;
        
        a.añadirFacturaEmitida(noFactura, fechaEmision, estadoPago, fechaPago, monto, metodoPago, idAnexo, opcion);
    }
    
    public void ingresarFacturaOrdenCompra(){
        System.out.println("===== FACTURRA ORDEN COMPRA ===== ");
        System.out.println("Ingresar numero de factura:");
        String noFactura = sc.nextLine();

        System.out.println("Ingresar fecha de emision (formato dd-mm-aaaaD):");
        String fechaEmisionStr = sc.nextLine();
        java.sql.Date fechaEmision = java.sql.Date.valueOf(fechaEmisionStr);

        System.out.println("Ingresar estado de pago:");
        String estadoPago = sc.nextLine();

        System.out.println("Ingresar fecha de pago (formato dd-mm-aaaa):");
        String fechaPagoStr = sc.nextLine();
        java.sql.Date fechaPago = java.sql.Date.valueOf(fechaPagoStr);

        System.out.println("Ingresar monto:");
        double monto = sc.nextDouble();
        sc.nextLine(); 

        System.out.println("Ingresar metodo de pago:");
        String metodoPago = sc.nextLine();
        
        System.out.println("Ingresar ID de la orden de compra:");
        String idOrdenCompra = sc.nextLine();
        
        a.añadirFacturaOrdenCompra(noFactura, fechaEmision, estadoPago, fechaPago, monto, metodoPago, idOrdenCompra);
    }
    
    public void ingresarFacturaServicio(){
        System.out.println("===== FACTURRA SERVICIO ===== ");
        System.out.println("Ingresar numero de factura:");
        String noFactura = sc.nextLine();

        System.out.println("Ingresar fecha de emision (formato dd-mm-aaaaD):");
        String fechaEmisionStr = sc.nextLine();
        java.sql.Date fechaEmision = java.sql.Date.valueOf(fechaEmisionStr);

        System.out.println("Ingresar estado de pago:");
        String estadoPago = sc.nextLine();

        System.out.println("Ingresar fecha de pago (formato dd-mm-aaaa):");
        String fechaPagoStr = sc.nextLine();
        java.sql.Date fechaPago = java.sql.Date.valueOf(fechaPagoStr);

        System.out.println("Ingresar monto:");
        double monto = sc.nextDouble();
        sc.nextLine(); 

        System.out.println("Ingresar metodo de pago:");
        String metodoPago = sc.nextLine();
        
        System.out.println("Ingresar ID del servicio relacionado:");
        String idServicio = sc.nextLine();
        
        a.añadirFacturaServicio(noFactura, fechaEmision, estadoPago, fechaPago, monto, metodoPago, idServicio);
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
}
