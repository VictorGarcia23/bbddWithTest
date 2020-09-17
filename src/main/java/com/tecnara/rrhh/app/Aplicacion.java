package com.tecnara.rrhh.app;


import com.tecnara.rrhh.menu.MenuHelper;

import java.sql.SQLException;
import java.util.Scanner;

public class Aplicacion {

    MenuHelper menuHelper = new MenuHelper();

    Scanner input = new Scanner(System.in);

    public void ejecutar() throws SQLException {

        int seleccion = 0;
        while (seleccion != 4) {
            seleccion = mostrarMenu();
            switch (seleccion) {
                case 1:
                    menuHelper.mostrarUsuarios();
                    break;
                case 2:
                    menuHelper.meterUsuario();
                    break;
                case 3:
                    menuHelper.eliminarUsuario();
                    break;

            }

        }
        System.out.println("Ha salido usted de la aplicación Empresa.");


    }


    public int mostrarMenu() {
        int opcion;

        StringBuilder sb = new StringBuilder();
        System.out.println("Bienvenido a su base de datos");
        System.out.println();
        sb.append("Pulse 1 si desea listar los usuarios \n" +
                "Pulse 2 si desea añadir usuarios \n" +
                "Pulse 3 si desea eliminar usuarios \n" +
                "Pulse 4 si desea salir de la aplicacion");
        System.out.println(sb);

        opcion = input.nextInt();

        return opcion;


    }


}