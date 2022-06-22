package com.csupreme19.studyjpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Post {
    @Id
    private Long id;
    private String categoryId;
    private String title;
    private String content;
    private Boolean enabled;
    private Long viewCount;
    private LocalDateTime createdAt;
    private String createdId;
    private String createdIp;
    private LocalDateTime modifiedAt;
    private String modifiedId;
    private String modifiedIp;
}
