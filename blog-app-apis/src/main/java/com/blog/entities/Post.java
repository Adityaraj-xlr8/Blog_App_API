package com.blog.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer postId;

    @Column(name="post_title",length = 50,nullable = false)
    private String title;

    @Column(length = 10000)
    private String content;

    private String imageName;

    private Date addedOn;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    private User user;

}
