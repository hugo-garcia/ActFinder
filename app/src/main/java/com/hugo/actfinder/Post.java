package com.hugo.actfinder;


import java.io.Serializable;


/**
 * Created by Hugo on 10/22/16.
 */

public class Post implements Serializable {
    private Post post;
    private String title;
    private String description;
    private String user;
    private String category;

    public Post(String user, String title, String description, String category) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.category = category;
    }

    public Post getPost() {return post;}

    public void setPost(Post post) {
        this.post = post;
    }

    public String getUser(){return user;}

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle(){return title;};

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {return description;}

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {return category;}

    public void set(String category) {
        this.category = category;
    }



}



