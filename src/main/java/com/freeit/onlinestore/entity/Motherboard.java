package com.freeit.onlinestore.entity;

import com.freeit.onlinestore.model.FormFactor;
import com.freeit.onlinestore.model.MemoryType;
import com.freeit.onlinestore.model.MotherboardProducer;
import com.freeit.onlinestore.model.Socket;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

@Data
@Entity
@Table(name="motherboard")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Motherboard extends AbstractEntity {

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="memory_slots")
    private Integer memorySlots;

    @Column
    @Enumerated(EnumType.STRING)
    private Socket socket;

    @Column(name="form_factor")
    @Enumerated(EnumType.STRING)
    private FormFactor formFactor;

    @Column(name="memory_type")
    @Enumerated(EnumType.STRING)
    private MemoryType memoryType;

    @Column(name="producer", nullable = false)
    @Enumerated(EnumType.STRING)
    private MotherboardProducer producer;

    @Column
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 5, fraction = 2)
    private double price;

    @Column
    @Min(value = 0)
    private Integer remainder;
}
