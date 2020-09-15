package baseDatos;

import sun.swing.MenuItemLayoutHelper;
import usuario.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public static Connection conexion;
    int id;
    Usuario usuario;
    Aplicacion aplicacion;
    public DAO()throws SQLException {
        try {

            String url = "jdbc:postgresql://192.168.56.2/Empresa";
            String usuario = "Gerente";
            String clave = "abc";
            this.conexion = DriverManager.getConnection(url, usuario, clave);

        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.toString());
        }
    }
    public List<Usuario> cargarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String selectTableSQL = "SELECT * FROM usuarios";
        Statement statement = this.conexion.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        System.out.println(rs);

        while(rs.next()){
            Usuario u = new Usuario(rs.getString("apellidos"),
                    rs.getString("nombre"),
                    rs.getString("departamento"),
                    rs.getString("sede"),
                    rs.getInt("id"));
            usuarios.add(u);

        }
        statement.close();
        return usuarios;

    }
    public String meterUsuario(Usuario usuario) throws SQLException {
        String m = usuario.getApellidos() +
                usuario.getNombre() + usuario.getDepartamento() + usuario.getSede();
        String selectTableSQL = "INSERT INTO usuarios(apellidos, nombre, departamento, sede) VALUES ('" + m + "' )";
        Statement statement = this.conexion.createStatement();
        ResultSet rs = statement.executeQuery(selectTableSQL);
        String aviso = "el usuario ha sido registrado correctamente";
        statement.close();
        return aviso;

    }
    public String eliminarUsuario(int id) throws SQLException {
        Statement statement = this.conexion.prepareStatement("DELETE FROM usuarios(id) VALUES ('" + usuario.getId() + "')");
        int x = statement.executeUpdate("");
        statement.close();
        this.id = id;
        return " Usuario eliminado ";
    }

}
