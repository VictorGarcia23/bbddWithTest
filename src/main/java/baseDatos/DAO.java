package baseDatos;

import sun.swing.MenuItemLayoutHelper;
import usuario.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public static Connection conexion;

    public DAO() {
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


        while(rs.next()){
            Usuario u = new Usuario(rs.getString("apellido"),
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
        String selectTableSQL = "INSERT INTO usuarios(apellido, nombre, departamento, sede) " +
                "VALUES (  ?,?,?,? )";
        PreparedStatement statement = this.conexion.prepareStatement(selectTableSQL);
        statement.setString(1,usuario.getApellidos());
        statement.setString(2,usuario.getNombre());
        statement.setString(3,usuario.getDepartamento());
        statement.setString(4,usuario.getSede());
        int result = statement.executeUpdate();
        statement.close();
        if(result == 1){
            return "El usuario ha sido registrado correctamente";
        }   else{
                return "No se ha podido inserta usuario.";
        }


    }
    public String eliminarUsuario(int id) throws SQLException {

        int resultado = this.conexion.createStatement().executeUpdate("DELETE FROM usuarios WHERE id = " + id + ";");
        if(resultado == 1){
            return "El usuario ha sido eliminado correctamente";
        }   else{
                return "No se ha podido eliminar usuario.";
        }

    }

}
