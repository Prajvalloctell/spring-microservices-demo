package com.loctell.module;

import com.loctell.enums.Roles;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Roles roles;
}
