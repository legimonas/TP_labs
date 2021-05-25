package com.program.tech.task2.source;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Ordered {
    @Id
    private Long id;
    private String lastname;
    private String address;
    private Integer price;
    private String delivery;

}
