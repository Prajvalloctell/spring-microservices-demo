package com.loctell.modules;

import com.loctell.enums.OrderStatus;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Products product;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
