package com.freeit.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends AbstractEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "motherboard_id")
    private Motherboard motherboard;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "processor_id")
    private Processor processor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "videocard_id")
    private Videocard videocard;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ram_id")
    private Ram ram;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ordering_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "ordering_id"))
    private List<Order> orders;
}
