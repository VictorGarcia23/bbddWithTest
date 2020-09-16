package baseDatos;

import usuario.Usuario;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuHelper {

    DAO dao = new DAO();

    public void mostrarUsuarios() throws SQLException {

        List<Usuario> listaUsuarios = dao.cargarUsuarios();
        for (Usuario usuario : listaUsuarios) {
            System.out.println(usuario.toString());

        }


    }

    public void meterUsuario() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("dame el nombre");
        String nombre = input.nextLine();
        System.out.println("dame los apellidos");
        String apellidos = input.nextLine();
        System.out.println("dame el departamento");
        String departamento = input.nextLine();
        System.out.println("dame la sede");
        String sede = input.nextLine();
        Usuario usuario = new Usuario(apellidos, nombre, departamento, sede, 0);
        String mensaje = dao.meterUsuario(usuario);
        System.out.println(mensaje);
    }

    public void eliminarUsuario() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Que id de usuario desdea eliminar?");
        int usuarioEliminado = input.nextInt();
        String mensaje = dao.eliminarUsuario(usuarioEliminado);
        System.out.println(mensaje);

    }
}
