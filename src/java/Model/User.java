/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Carlos Correa
 */
public class User {

    private int userId;
    private String mail;
    private String password;
    private int roleID;

    public User(int userId, String mail, String password, int roleID) {
        this.userId = userId;
        this.mail = mail;
        this.password = password;
        this.roleID = roleID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    @Override
    public String toString() {
        return "Usuario{" + "userId=" + userId + ", mail=" + mail + ", password=" + password + ", roleID=" + roleID + '}';
    }
    
}
