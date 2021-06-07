package com.freeit.onlinestore.entity;

import com.freeit.onlinestore.model.MemoryType;
import com.freeit.onlinestore.model.RamProducer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="ram")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Ram extends AbstractEntity {

    @Column(name="memory_size", nullable = false)
    private Integer memorySize;

    @Column(name="memory_frequency", nullable = false)
    private Integer memoryFrequency;

    @Column(nullable = false)
    private String latency;

    @Column(name="memory_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private MemoryType memoryType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RamProducer producer;
}
