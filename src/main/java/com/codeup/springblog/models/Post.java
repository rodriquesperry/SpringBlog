package com.codeup.springblog.models;

public class Post {
    private long id;
    private String title;
    private String body;

    public Post() {}

//    public Post(int id) {
//        this.id = id;
//    }

    public Post(String title) {
//        this.id = id;
        this.title = title;
    }

    public Post(String title, String body) {
//        this.id = id;
        this.title = title;
        this.body = body;
    }


    public long getId() {return id;}

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setId(int id) {this.id = id;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
