package com.tecnara.rrhh.dao;

import com.tecnara.rrhh.dominio.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class DAOMySql implements DAO{
    public static Connection conexion;
    public DAOMySql(){
        try {

            String url = "jdbc:mysql://localhost:3306/mysql?serverTimezone=" + TimeZone.getDefault().getID();
            String usuario = "root";
            String clave = "admin";
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection(url, usuario, clave);

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error SQL: " + e.toString());
        }
    }

    @Override
    public List<Usuario> cargarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String selectTableSQL = "SELECT * FROM usuario";
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


    @Override
    public String meterUsuario(Usuario usuario) throws SQLException {
        String selectTableSQL = "INSERT INTO usuario(apellido, nombre, departamento, sede) " +
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
    @Override
    public String eliminarUsuario(int id) throws SQLException {

        int resultado = this.conexion.createStatement().executeUpdate("DELETE FROM usuario WHERE id = " + id + ";");
        if(resultado == 1){
            return "El usuario ha sido eliminado correctamente";
        }   else{
            return "No se ha podido eliminar usuario.";
        }

    }
}
