package com.mensajes_app;

public class Message {
    private Integer idMessage;
    private String message;
    private String author;
    private String dateMessage;

    public Message(){

    }

    public Message(Integer idMessage, String message, String author, String dateMessage) {
        this.idMessage = idMessage;
        this.message = message;
        this.author = author;
        this.dateMessage = dateMessage;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(String dateMessage) {
        this.dateMessage = dateMessage;
    }
}
