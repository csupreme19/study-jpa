package com.csupreme19.studyjpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Post extends CommonEntity {
    @Id
    private Long id;
    private String categoryId;
    private String title;
    private String content;
    private Boolean enabled;
    private Long viewCount;
    private String createdId;
    private String modifiedId;
}
