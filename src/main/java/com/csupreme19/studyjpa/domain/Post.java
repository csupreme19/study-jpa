package com.csupreme19.studyjpa.domain;

import lombok.Getter;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "createdId")
    private Account author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modifiedId")
    private Account modifier;
}
