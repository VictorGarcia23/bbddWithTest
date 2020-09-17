package com.tecnara.rrhh.menu;

import com.tecnara.rrhh.constantes.Constantes;
import com.tecnara.rrhh.dao.DAO;
import com.tecnara.rrhh.dao.DAOPostgres;
import com.tecnara.rrhh.dao.FactoriaDAO;
import com.tecnara.rrhh.dominio.Usuario;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;


public class MenuHelper {
    DAO dao;

    Properties properties;
    public MenuHelper(){
        try {
            this.properties = new Properties();
            properties.load(getClass().getResourceAsStream(Constantes.PROPERTIES_PATH));
            this.dao = FactoriaDAO.crearDB(Constantes.DAOS.valueOf(properties.getProperty("dao")));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void mostrarUsuarios() throws SQLException {

        List<Usuario> listaUsuarios = this.dao.cargarUsuarios();
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
        String mensaje = this.dao.meterUsuario(usuario);
        System.out.println(mensaje);
    }

    public void eliminarUsuario() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Que id de usuario desdea eliminar?");
        int usuarioEliminado = input.nextInt();
        String mensaje = this.dao.eliminarUsuario(usuarioEliminado);
        System.out.println(mensaje);

    }
}
