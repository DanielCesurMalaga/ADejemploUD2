package accesoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

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

    public boolean crearConexion() {
        try {
            conexion = DriverManager.getConnection(URL, USR, PSWD);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean cerrarConexion() {
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

    public boolean crearStatement() {

        try {
            statement = conexion.createStatement();
        } catch (SQLException e) {
            return false;
        }
        return true;

    }

    public boolean cerrarStatement() {
        if (statement != null) {
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

    public ResultSet ejecutarQuery(String query) throws SQLException {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            return null;
        } finally {
            if (resultSet != null)
                resultSet.close();
        }
    }

    public int ejecutarUpdate(String update) {
        try {
            return statement.executeUpdate(update);
        } catch (SQLException e) {
            return -1;
        }
    }

    public String getURL() {
        return URL;
    }

    public String getUSR() {
        return USR;
    }

    public String getPSWD() {
        return PSWD;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

}
