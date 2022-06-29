package com.csupreme19.studyjpa.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

@Embeddable // 다른 엔티티에 포함될 수 있다.
@EqualsAndHashCode
public class PostTagId implements Serializable {

    @Serial
    private static final long serialVersionUID = 5185466074761784155L;

    private String postId;
    private String tagId;
}
