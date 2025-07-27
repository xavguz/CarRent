/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.carrent;

/**
 *
 * @author Nueva
 */
public class CarRent {

    public static void main(String[] args) {
        try {
            DBconnection db = DBconnection.getInstance();
            if (db.getConnection() != null) {
                System.out.println("¡Conexión exitosa a la base de datos!");
            }
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
