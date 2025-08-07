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
    
    public void inicio(){
        
        int opcion;
        
        do {
            System.out.println("-----CarRent-----");
            System.out.println("1. Añadir");
            System.out.println("2. Consultar");
            System.out.println("3. Editar");
            System.out.println("4. Eliminar");  
            System.out.println("5. Salir");
            
            opcion = sc.nextInt();
            consultas(opcion);

        } while (opcion != 5);

    }
    
    public void consultas(int opcion){
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
        }
    }
    
    public void añadir(){
        int opcion = mostrarMenuAñadir();
        
        switch (opcion){
            case 1:
                iD.ingresarCliente();
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
                iD.ingresarServicio();
                break;    
            case 9:
                iD.ingresarFactura();
                break;
            case 10:
                iD.ingresarMulta();
                break;
        }
    }
    
    public void consultar(){}
    
    public void editar(){}
    
    public void eliminar(){}
    
    public int mostrarMenuAñadir() {
        System.out.println("===== MENÚ AÑADIR =====");
        System.out.println("Seleccione una opción: ");
        System.out.println("1. Ingresar cliente");
        System.out.println("2. Ingresar sucursal");
        System.out.println("3. Ingresar empleado");
        System.out.println("4. Ingresar contrato");
        System.out.println("5. Insertar anexo");
        System.out.println("6. Ingresar orden de compra");
        System.out.println("7. Ingresar vehículo");
        System.out.println("8. Ingresar servicio");
        System.out.println("9. Ingresar factura");
        System.out.println("10. Ingresar multa");

        int opcion = sc.nextInt();
        sc.nextLine(); 

        return opcion;
    }
}
