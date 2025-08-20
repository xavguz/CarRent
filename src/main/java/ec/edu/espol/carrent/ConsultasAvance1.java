/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.carrent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nueva
 */
public class ConsultasAvance1 {
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
}
