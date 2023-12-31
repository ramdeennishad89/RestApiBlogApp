package com.myblog.blogapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name="posts",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="title", nullable=false)
    private String title;

    @Column(name="description" ,nullable=false)
    private String description;

    @Column(name="content" ,nullable=false)
    private String content;


    @OneToMany(mappedBy = "post",cascade=CascadeType.ALL,orphanRemoval = true)
    Set<Comment> comments=new HashSet<>();




}
