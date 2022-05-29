package com.blog.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="categories")
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(name = "title",nullable = false,length = 50)
    private String categoryTitle;

    @Column(name = "description")
    private String categoryDescription;

    @OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Post> data = new LinkedHashSet<>();

}
