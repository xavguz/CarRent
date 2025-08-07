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
public class IngresoDatosEliminar {
    Eliminar e = new Eliminar();
    Scanner sc = new Scanner(System.in);
    
    public void eliminarCliente(){
        System.out.println("Escriba el id del Cliente");
        String id = sc.nextLine();
        e.eliminarCliente(id);
    }
    
    public void eliminarVehiculo(){
        System.out.println("Escriba la placa del Vehiculo");
        String idVehiculo = sc.nextLine();
        e.eliminarVehiculo(idVehiculo);
    }
    
    public void eliminarAnexo(){
        System.out.println("Escriba el id del Anexo");
        String idAnexo = sc.nextLine();
        e.eliminarAnexo(idAnexo);
    }
    
    public void eliminarFactura(){
        System.out.println("Escriba el id de la Factura");
        String idFactura = sc.nextLine();
        e.eliminarFactura(idFactura);
    
    }
    
    public void eliminarSucursal(){
        System.out.println("Escriba el id de la Sucursal");
        String idSucursal = sc.nextLine();
        e.eliminarSucursal(idSucursal);
    }
    
    public void eliminarContrato(){
        System.out.println("Escriba el id del Contrato");
        String idContrato = sc.nextLine();
        e.eliminarContrato(idContrato);
    }
    
    public void eliminarOrdenDeCompra(){
        System.out.println("Escriba el id de la OrdenDeCompra");
        String idODC = sc.nextLine();
        e.eliminarOrdenDeCompra(idODC);
    }
    
    public void eliminarEmpleado(){
        System.out.println("Escriba el id del Empleado");
        String idEmpleado = sc.nextLine();
        e.eliminarEmpleado(idEmpleado);
    
    }
    
    public void eliminarMulta(){
        System.out.println("Escriba el id de la Multa");
        String idMulta = sc.nextLine();
        e.eliminarMulta(idMulta);
    }
    
    
    public void elimnarServicio(){
        System.out.println("Escriba el id del Servicio");
        String idServicio = sc.nextLine();
        e.eliminarServicio(idServicio);
    }
    
    public void eliminarModificacion(){
        System.out.println("Escriba el id de la Modificacion");
        String idModi = sc.nextLine();
        e.eliminarModificacion(idModi);
    }
    
    public void eliminarMantenimiento(){
        System.out.println("Escriba el id del Mantenimiento");
        String idMan = sc.nextLine();
        e.eliminarMantenimiento(idMan);
    }           
}
