/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import utility.DBUtil;

/**
 *
 * @author Carlos Correa
 */
public class DAOUser {

    private Connection conexion;

    public DAOUser() {
        conexion = DBUtil.getConexion();
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new LinkedList<>();

        Statement stmt = conexion.createStatement();
        String sql = "SELECT * "
                + " FROM USERAPP ";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int userId = rs.getInt("USERID");
            String mail = rs.getString("MAIL");
            String password = rs.getString("PASSWORD");
            int roleId = rs.getInt("ROLEID");

            User u = new User(userId, mail, password, roleId);
            userList.add(u);
        }

        return userList;
    }

    public void delete(int userId) throws SQLException {
        String sql = "DELETE FROM USERAPP WHERE USERID='"+userId+"'";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.executeUpdate();
    }

    public void save(String mail,String password) throws SQLException {
        String sql = "INSERT INTO USERAPP ( USERID , MAIL, PASSWORD, ROLEID)" +
            "VALUES(USER_SEQUENCE.NEXTVAL,'"+mail+"','"+password+"',1)";
        //  "VALUES('Bill Gates','123','Masculino',2,1,1,0)";
        PreparedStatement ps = conexion.prepareStatement(sql);        
        
        ps.executeUpdate();
        System.out.println("usuario ");
    }
}
