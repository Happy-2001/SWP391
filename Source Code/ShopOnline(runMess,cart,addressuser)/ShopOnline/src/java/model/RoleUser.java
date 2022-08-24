/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nguye
 */
public class RoleUser {
    User user;
    UserAddress user_add;

    public RoleUser(){
        
    }
    public RoleUser(User user, UserAddress user_add) {
        this.user = user;
        this.user_add = user_add;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserAddress getUser_add() {
        return user_add;
    }

    public void setUser_add(UserAddress user_add) {
        this.user_add = user_add;
    }

    @Override
    public String toString() {
        return "RoleUser{" + "user=" + user + ", user_add=" + user_add + '}';
    }

   
    
}
