package com.csupreme19.studyjpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Category {
    @Id
    private Long id;
    private String categoryName;
    private Long parentId;
    private LocalDateTime createdAt;
    private String createdIp;
    private LocalDateTime modifiedAt;
    private String modifiedIp;
}
