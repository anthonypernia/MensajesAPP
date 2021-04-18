package com.mensajes_app;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MessageDAO {
    private static String tableName = "mensajes";
    public static void createMessageDB(Message message){
        ConnectionDB connectionDB = new ConnectionDB();
        try(Connection connection = connectionDB.getConnection() ) {
            PreparedStatement ps = null;
            try{
                String query= "INSERT INTO "+tableName+" (mensaje, autor_mensaje) VALUES(?,?)";
                ps=connection.prepareStatement(query);
                ps.setString(1, message.getMessage());
                ps.setString(2, message.getAuthor());
                ps.executeUpdate();
                System.out.println("mensaje creado");
            }catch (Exception e){
                System.out.println(e);
            }
        }catch (SQLException e){
            System.out.println(e);
        }

    }
    public static void readMessageDB(){

        ConnectionDB connectionDB = new ConnectionDB();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try(Connection connection = connectionDB.getConnection() ) {
            String query = "SELECT * FROM "+tableName;
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println("ID: "+rs.getInt("id_mensaje"));
                System.out.println("Mensaje: "+ rs.getString("mensaje"));
                System.out.println("Autor: "+rs.getString("autor_mensaje"));
                System.out.println("Fecha: "+rs.getString("fecha_mensaje") );
            }


        }catch (SQLException e){

        }

    }
    public static void deleteMessageDB(int idMessage){
        ConnectionDB connectionDB = new ConnectionDB();
        try(Connection connection = connectionDB.getConnection()){
            PreparedStatement ps = null;

            try {
                String query = "DELETE FROM "+tableName+" WHERE id_mensaje = ?";
                ps = connection.prepareStatement(query);
                ps.setInt(1,idMessage);
                ps.executeUpdate();
                System.out.println("Mensaje con ID = "+idMessage+ "Borrado");
            }catch (SQLException e){
                System.out.println(e);
            }

        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public static void updateMessageDB(Message message){
        ConnectionDB connectionDB = new ConnectionDB();
        try(Connection connection = connectionDB.getConnection()){
            PreparedStatement ps=null;
            try {
                String query = "UPDATE "+tableName+" set mensaje=? WHERE id_mensaje=?";
                ps = connection.prepareStatement(query);
                ps.setString(1, message.getMessage());
                ps.setInt(2,message.getIdMessage());
                ps.executeUpdate();
                System.out.println("Mensaje con ID= "+message.getIdMessage()+", se actualizo, correctamente");
            }catch (SQLException e){
                System.out.println(e);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
