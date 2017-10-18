/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Part;
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
public class DAOPart {

    private Connection conexion;

    public DAOPart() {
        conexion = DBUtil.getConexion();
    }

    public List<Part> getAllParts() throws SQLException {
        List<Part> userPart = new LinkedList<>();

        Statement stmt = conexion.createStatement();
        String sql = "SELECT * "
                + " FROM PART ";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int partId = rs.getInt("PARTID");
            String name = rs.getString("NAME");
            int weightSupported = rs.getInt("WEIGHTSUPPORTED");
            int batteryCells = rs.getInt("BATTERYCELLS");
            String esc = rs.getString("ESC");
            String propeller = rs.getString("PROPELLER");
            int status = rs.getInt("STATUS");

            Part p = new Part(partId, name, weightSupported, batteryCells, esc, propeller, status);

            userPart.add(p);
        }

        return userPart;
    }

    public void delete(int partId) throws SQLException {
        String sql = "DELETE FROM PART WHERE PARTID='" + partId + "'";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.executeUpdate();
    }

    public void save(String name , int weightSupported , int batteryCells , String esc , String propeller) throws SQLException {
        String sql = "INSERT INTO PART (PARTID , NAME , WEIGHTSUPPORTED , BATTERYCELLS , ESC , PROPELLER , STATUS)"
                + "VALUES(PART_SEQUENCE.NEXTVAL,'" + name + "','"+ weightSupported +"' , '"+ batteryCells +"'  ,'" + esc + "','" + propeller + "',1)";
        //  "VALUES('Bill Gates','123','Masculino',2,1,1,0)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.executeUpdate();
        System.out.println("Part ");
    }

}
