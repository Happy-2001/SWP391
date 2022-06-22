/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrator
 */
public class Group {
    private String groupID,groupName;

    public Group() {
    }

    public Group(String groupID, String groupName, String lastMessage) {
        this.groupID = groupID;
        this.groupName = groupName;
      
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

   

    
    
}
