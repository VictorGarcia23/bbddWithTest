package baseDatos;

import usuario.Usuario;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        Aplicacion aplicacion = new Aplicacion();
        Usuario usuario = new Usuario("garcia", "pepe", "CONFIDENCIAL", "madrid", 01);
        aplicacion.ejecutar();



    }

}