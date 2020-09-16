package baseDatos;

import usuario.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface DAO {

    public List<Usuario> cargarUsuarios()throws SQLException;
    public String meterUsuario(Usuario usuario)throws SQLException;
    public String eliminarUsuario(int id)throws SQLException;

}
