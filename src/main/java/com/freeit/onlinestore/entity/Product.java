package com.freeit.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends AbstractEntity {

    @Column
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 5, fraction = 2)
    private double price;

    @Column
    @Min(value = 0)
    private int remainder;

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
}
