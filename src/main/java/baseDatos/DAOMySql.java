package baseDatos;

import usuario.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.TimeZone;

public class DAOMySql implements DAO{
    public static Connection conexion;
    public DAOMySql(){
        try {

            String url = "jdbc:mysql://localhost:3306/mysql?serverTimezone=" + TimeZone.getDefault().getID();
            String usuario = "root";
            String clave = "admin";
            this.conexion = DriverManager.getConnection(url, usuario, clave);

        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.toString());
        }
    }

    @Override
    public List<Usuario> cargarUsuarios() throws SQLException {
        return null;
    }

    @Override
    public String meterUsuario(Usuario usuario) throws SQLException {
        return null;
    }

    @Override
    public String eliminarUsuario(int id) throws SQLException {
        return null;
    }
}
