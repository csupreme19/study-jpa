package com.csupreme19.studyjpa.domain;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class PostTag {
    @EmbeddedId
    private PostTagId postTagId;
}

@Embeddable
class PostTagId implements Serializable {
    private String postId;
    private String tagId;
}

