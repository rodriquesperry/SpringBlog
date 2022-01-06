package com.codeup.springblog.models;

import org.hibernate.annotations.Cascade;

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

    @ManyToOne
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Post() {}

//    public Post(int id) {
//        this.id = id;
//    }

    public Post(String title) {
//        this.id = id;
        this.title = title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
