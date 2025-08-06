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
    
    public void mostrarReportes(){
        
        int opcion;
        
        do {
            System.out.println("-----Reportes-----");
            System.out.println("1. Mostrar Vehiculos Disponibles");
            System.out.println("2. Mostrar Ingresos");
            System.out.println("3. Salir");
            
            opcion = sc.nextInt();;
            
            consultas(opcion);
        
        } while (opcion != 3);
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
        }
    }
    
    public void opciones(){
        
        int opcion;
        
        do {
            System.out.println("-----CarRent-----");
            System.out.println("1. Añadir");
            System.out.println("2. Consultar");
            System.out.println("3. Editar");
            System.out.println("4. Eliminar");
            System.out.println("5. Salir");
            
            opcion = sc.nextInt();;
            
            consultas(opcion);
        
        } while (opcion != 3);
    }
}
