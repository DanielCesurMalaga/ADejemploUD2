import java.sql.SQLException;

import accesoBD.AccesoBD;

public class App {

    public static void main(String[] args) throws SQLException {
        
        // borrar de la bd escuela todos los profesores.
        AccesoBD miAcceso = new AccesoBD(
            "jdbc:mysql://localhost:3306/escuela",
             "root", 
             "");

        miAcceso.crearConexion();
        miAcceso.crearStatement();

        miAcceso.ejecutarUpdate("DELETE FROM PROFESORES");

        miAcceso.getConexion().setAutoCommit(false);

        int exitoso=0;
        exitoso = exitoso + miAcceso.ejecutarUpdate("INSERT INTO PROFESORES (nombre, apellido, materia)"+ 
            "VALUES ('Daniel','Fernández', 'DAM')");
        exitoso = exitoso + miAcceso.ejecutarUpdate("INSERT INTO PROFESORES (nombre, apellido, materia)" +
            "VALUES ('Santiago','David', 'CONTESTON')");
        exitoso = exitoso + miAcceso.ejecutarUpdate("INSERT INTO PROFESORES (nombre, apellido, materia)" +
            "VALUES ('Adrian','Ungureanu', 'SEGUNDA FILA')");

        if (exitoso == 2) {
            miAcceso.getConexion().commit();
        } else {
            miAcceso.getConexion().rollback();
        }

        

        miAcceso.cerrarStatement();
        miAcceso.cerrarConexion();

    }

    }

