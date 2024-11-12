import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class App {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/escuela";
    private static final String USR = "root";
    private static final String PSWD = "";

    public static void main(String[] args) throws Exception {

        Connection conexion = DriverManager.getConnection(URL, USR, PSWD);

        System.out.println("Realizada conexión a la base de datos.");

        String insertarSQL = "INSERT INTO profesores (nombre, apellido, materia) VALUES (?,?,?)";

        PreparedStatement ps = conexion.prepareStatement(insertarSQL);

        ps.setString(1, "Juan");
        ps.setString(2, "Pérez");
        ps.setString(3, "Matemáticas");
        ps.executeUpdate();

        ps.setString(1, "Ana");
        ps.setString(2, "García");
        ps.setString(3, "Historia");
        ps.executeUpdate();

        ps.setString(1, "Luis");
        ps.setString(2, "Martínez");
        ps.setString(3, "Ciencias");
        ps.executeUpdate();

        System.out.println("Registros insertados correctamente");

        String consultaSQL= "SELECT * FROM PROFESORES";

        ResultSet rs = ps.executeQuery(consultaSQL);

        System.out.println("Lista de profesores:");

        while (rs.next()){
            System.out.println("ID: " + rs.getInt("id") + 
            ", Nombre: " + rs.getString("nombre") + 
            ", Apellido: " + rs.getString("apellido") + 
            ", Materia: " + rs.getString("materia")); 
        }

        conexion.close();
        ps.close();
        rs.close();
    }
}
