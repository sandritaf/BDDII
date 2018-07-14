package Logica;

import Conexion.Conexion;
import Modelo.M_Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class ControladorEstudiante {

    public ControladorEstudiante() {
    }
    
    public void ingresar(M_Estudiante alumno){
        try {
                Conexion conn = new Conexion();
                Connection con = conn.getConection();
                PreparedStatement ps = null;                
                
                ps = con.prepareCall("INSERT INTO estudiante (cedula, nombre, apellido, semestre, carrera)"
                        + " VALUES (?,?,?,?,?)");
                
                ps.setString(1, alumno.getCedula());
                ps.setString(2, alumno.getNombre());
                ps.setString(3, alumno.getApellido());
                ps.setString(4, alumno.getSemestre());
                ps.setString(5, alumno.getCarrera());

                int res = ps.executeUpdate(); //Ejecutar la consulta

                if (res > 0){
                    JOptionPane.showMessageDialog(null, "Persona guardada con éxito");
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo guardar");
                }
                //Cerrar las conexiones
                ps.close();
                conn.CerrarConexion();
                con.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error: "+e);
            }
    }
}
