package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="banner")
public class Banner {
    @Id
    private String id;
    @Column(name="picName")
    private String picName;
    @Column(name="picPath")
    private String picPath;
    private String description;
    private Integer status;

}
