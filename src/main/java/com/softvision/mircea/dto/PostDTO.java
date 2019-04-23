package com.softvision.mircea.dto;

import com.softvision.mircea.model.User;

import java.util.Date;

public class PostDTO {


    public static String getText;
    private static long id;
    private static User user;
    private String text;
    private static Date dateCreated;

    public PostDTO() {
    }


    public PostDTO(long id, User user, String text, Date dateCreated) {
        this.id = id;
        this.user = user;
        this.text = text;
        this.dateCreated = dateCreated;
    }


    public static long getId() {
        return id;
    }

    public static void setId(long id) {
        PostDTO.id = id;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        PostDTO.user = user;
    }

    public String getText() {
        return text;
    }

    public static void setText(String text) {
        this.text = text;
    }

    public static Date getDateCreated() {
        return dateCreated;
    }

    public static void setDateCreated(Date dateCreated) {
        PostDTO.dateCreated = dateCreated;
    }
}









