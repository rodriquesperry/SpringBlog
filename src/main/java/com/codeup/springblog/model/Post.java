package com.codeup.springblog.model;

public class Post {

    private String title;
    private String body;

    public void Post() {

    }

    public void Post(String title) {
        this.title = title;
    }

    public void Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
