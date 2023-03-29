package com.loctell.module;

import com.loctell.enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String price;
}