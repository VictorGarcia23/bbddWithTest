package baseDatos;


import usuario.Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public class Aplicacion {
    private int opcion;
    MenuHelper menuHelper;
    Usuario usuario;
    DAO dao;
    Scanner input = new Scanner(System.in);

    public void ejecutar() throws SQLException {

        mostrarMenu(opcion);
        switch (mostrarMenu(opcion)) {
            case 1:
                menuHelper.listasDeUsuarios();
                break;
            case 2:
                menuHelper.meterUsuario();
                break;
            case 3:
                menuHelper.eliminarUsuario();
                break;
            case 4:
                dao.conexion.close();
                System.out.println("Usted ha salido de la aplicación ");
                break;
        }


    }

    public int mostrarMenu(int opcion) {
        do {
            StringBuilder sb = new StringBuilder();
            System.out.println("Bienvenido a su base de datos");
            System.out.println();
            sb.append("Pulse 1 si desea listar los usuarios " +
                    "Pulse 2 si desea añadir usuarios " +
                    "Pulse 3 si desea eliminar usuarios " +
                    "Pulse 4 si desea salir de la aplicacion");
            System.out.println(sb);
            this.opcion = input.nextInt();
            this.opcion = opcion;
            return opcion;

        } while (opcion < 5);




    }
}