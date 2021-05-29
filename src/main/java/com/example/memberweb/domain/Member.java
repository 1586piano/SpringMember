package com.example.memberweb.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Member {

    //Primary Key
    @Id
    private Long id;
    private String name;
    private String pw;

}
