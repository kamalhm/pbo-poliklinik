/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author doki
 */
public class Admin {
    private String user;
    private String password;

    public Admin(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
    
    
}
