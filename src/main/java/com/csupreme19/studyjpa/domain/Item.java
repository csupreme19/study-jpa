package com.csupreme19.studyjpa.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Access(AccessType.PROPERTY)
@ToString
public class Item extends CommonEntity {
    private Long id;
    private String itemName;
    private String itemNumber;

    @Transient              // 프로퍼티 접근자 방식이므로 해당 Transient는 적용되지 않음
    private Long itemPrice;
    private Boolean enabled;

    @Id                     // Id가 선언된 위치에 따라 접근자 방식이 바뀐다.
    public Long getId(){
        return this.id;
    }

    @Transient
    public String getItemNumber() {
        return this.itemNumber;
    }

}