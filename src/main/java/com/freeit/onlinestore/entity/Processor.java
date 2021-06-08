package com.freeit.onlinestore.entity;

import com.freeit.onlinestore.model.ProcessorProducer;
import com.freeit.onlinestore.model.Socket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="processor")
@EqualsAndHashCode(callSuper = true)
public class Processor extends AbstractEntity {

    @Column(name="cores_quantity")
    private Integer coresQuantity;

    @Column
    private Integer frequency;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Socket socket;

    @Column(name="processor_producer", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProcessorProducer producer;

    @Column
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 5, fraction = 2)
    private double price;

    @Column
    @Min(value = 0)
    private Integer remainder;
}
