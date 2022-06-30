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
public class Message {
    private String id,fromID,toID,content,createDate,parentMessageID,isread;

    public Message() {
    }

    public Message(String id, String fromID, String toID, String content, String createDate, String isread) {
        this.id = id;
        this.fromID = fromID;
        this.toID = toID;
        this.content = content;
        this.createDate = createDate;
        this.isread = isread;
    }
    public Message(String id, String fromID, String toID, String content, String createDate, String parentMessageID, String isread) {
        this.id = id;
        this.fromID = fromID;
        this.toID = toID;
        this.content = content;
        this.createDate = createDate;
        this.parentMessageID = parentMessageID;
        this.isread = isread;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromID() {
        return fromID;
    }

    public void setFromID(String fromID) {
        this.fromID = fromID;
    }

    public String getToID() {
        return toID;
    }

    public void setToID(String toID) {
        this.toID = toID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getParentMessageID() {
        return parentMessageID;
    }

    public void setParentMessageID(String parentMessageID) {
        this.parentMessageID = parentMessageID;
    }

    public String getIsread() {
        return isread;
    }

    public void setIsread(String isread) {
        this.isread = isread;
    }

    

    
    
    
}
