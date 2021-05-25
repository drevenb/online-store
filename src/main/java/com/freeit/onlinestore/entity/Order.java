package com.freeit.onlinestore.entity;

import com.freeit.onlinestore.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ordering")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Order extends AbstractEntity {

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @Column(name = "total_sum")
    private double totalSum;

    @Column(name = "status")
    private OrderStatus status = OrderStatus.PROCESSING;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
