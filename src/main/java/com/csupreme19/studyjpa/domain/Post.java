package com.csupreme19.studyjpa.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Post extends CommonEntity {
    @Id
    private Long id;
    private String categoryId;
    private String title;
    private String content;
    private Boolean enabled;
    private Long viewCount;

    @ManyToMany(mappedBy = "posts")
    private List<Tag> tags;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "createdId")
    private Account author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modifiedId")
    private Account modifier;
}
