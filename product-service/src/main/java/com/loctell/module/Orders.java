package com.loctell.module;

import com.loctell.enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Products product;

    @SuppressWarnings("JpaAttributeTypeInspection")
    @Enumerated(EnumType.STRING)
    private OrderStatus ordersStatus;
}