package com.freeit.onlinestore.entity;

import com.freeit.onlinestore.model.ProcessorProducer;
import com.freeit.onlinestore.model.Socket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
