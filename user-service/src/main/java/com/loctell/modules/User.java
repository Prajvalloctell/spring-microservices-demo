package com.loctell.modules;

import com.loctell.enums.Roles;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Roles roles;
}
