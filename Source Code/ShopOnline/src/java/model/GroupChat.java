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
public class GroupChat {
    private String id,groupID,messageID,name,content,time,creatorMessage;

    public GroupChat() {
    }

    public GroupChat(String id,String groupID,String messageID, String name, String content, String time,String creatorMessage) {
        this.id = id;
        this.groupID = groupID;
        this.messageID = messageID;
        this.name = name;
        this.content = content;
        this.time = time;
        this.creatorMessage = creatorMessage;
    }

    public String getCreatorMessage() {
        return creatorMessage;
    }

    public void setCreatorMessage(String creatorMessage) {
        this.creatorMessage = creatorMessage;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
}
