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
                meterUsuarioMenu();
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
    private String nombre;
    private String apellidos;
    private String departamento;
    private String sede;
    public void meterUsuarioMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("dame el nombre");
        String nombre = input.nextLine();
        System.out.println("dame los apellidos");
        String apellidos = input.nextLine();
        System.out.println("dame el departamento");
        String departamento = input.nextLine();
        System.out.println("dame la sede");
        String sede = input.nextLine();
        nombre = this.nombre;
        apellidos = this.apellidos;
        departamento = this.departamento;
        sede = this.sede;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getSede() {
        return sede;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }
}