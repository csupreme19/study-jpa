package com.csupreme19.studyjpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Tag {
    @Id
    private Long id;
    private String tagName;
    private LocalDateTime createdAt;
    private String createdIp;
    private LocalDateTime modifiedAt;
    private String modifiedIp;
}