package com.csupreme19.studyjpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category extends CommonEntity {
    @Id
    private Long id;
    private String categoryName;
    private Long parentId;
}
