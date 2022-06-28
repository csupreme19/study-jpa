package com.csupreme19.studyjpa.domain;

import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class PostTagId implements Serializable {

    @Serial
    private static final long serialVersionUID = 5185466074761784155L;

    private String postId;
    private String tagId;
}
