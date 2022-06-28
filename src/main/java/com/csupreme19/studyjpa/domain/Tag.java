package com.csupreme19.studyjpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tag extends CommonEntity {
    @Id
    private Long id;
    private String tagName;
}