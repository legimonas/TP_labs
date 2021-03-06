package com.program.tech.task2.source;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {
    @Id
    private Long id;
    private String login;
    private String password;
    private String role;
}
