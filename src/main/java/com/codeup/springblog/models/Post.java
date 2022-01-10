package com.codeup.springblog.models;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;


    @Column(nullable = false, length = 5000)
    private String body;

//    @Column(length = 500)
//    @Value("${file-upload-path}")
//    private String images;

    @ManyToOne
    private User user;

    public Post() {}

    public Post(String title) {this.title = title;}

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

//    public String getImages() {return images;}

    public User getUser() {
        return user;
    }

    public long getId() {return id;}

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

//    public void setImages(String image) {this.images = images;}

    public void setId(int id) {this.id = id;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(long id) {
        this.id = id;
    }
}
