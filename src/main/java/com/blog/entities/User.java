package com.blog.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="user_name",nullable = false,length =100)
    private String name;
    private String email;
    private String password;
    private String about;

    @OneToMany(mappedBy="category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Post> data = new LinkedHashSet<>();

}
