package com.csupreme19.studyjpa.domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@ToString
public class Tag extends CommonEntity {
    @Id
    private Long id;
    private String tagName;

    @ManyToMany
    @JoinTable(name = "post_tag"
            , joinColumns = {@JoinColumn(name = "tagId")}
    , inverseJoinColumns = {@JoinColumn(name = "postId")})
    private List<Post> posts = new ArrayList<>();
}