package com.csupreme19.studyjpa.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class PostTag {
    @EmbeddedId // 복합키
    private PostTagId postTagId;
}