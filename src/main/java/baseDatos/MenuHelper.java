package baseDatos;

import java.sql.SQLException;

public class MenuHelper {

    DAO dao;
    public void listasDeUsuarios() throws SQLException {
        dao.cargarUsuarios();
    }
    public void meterUsuario() throws SQLException {
        dao.meterUsuario(dao.usuario);
    }
    public void eliminarUsuario() throws SQLException {
        dao.eliminarUsuario(dao.id);


    }
}
