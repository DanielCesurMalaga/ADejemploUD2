package accesoBD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBD {
    
    private final String URL;
    private final String USR;
    private final String PSWD;
    private Connection conexion;
    private Statement statement;

    public AccesoBD(String url, String usr, String pswd) {
        URL = url;
        USR = usr;
        PSWD = pswd;

        conexion = null;
        statement = null;
    }

    public boolean crearConexion(){
        try {
            conexion = DriverManager.getConnection(URL, USR, PSWD);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean cerrarConexion(){
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean crearStatement(){

        try {
            statement = conexion.createStatement();
        } catch (SQLException e) {
            return false;
        }
        return true;

    }

    public boolean cerrarStatement(){
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                return false;
            }
            return true;
        } else {
            return false;
        }

    }

    

}
