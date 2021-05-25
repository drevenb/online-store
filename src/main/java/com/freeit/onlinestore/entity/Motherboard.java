package com.freeit.onlinestore.entity;

import com.freeit.onlinestore.model.FormFactor;
import com.freeit.onlinestore.model.MemoryType;
import com.freeit.onlinestore.model.MotherboardProducer;
import com.freeit.onlinestore.model.Socket;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="motherboard")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Motherboard extends AbstractEntity {

    @Column(name="memory_slots")
    private Integer memorySlots;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Socket socket;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FormFactor formFactor;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MemoryType memoryType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MotherboardProducer motherboardProducer;
}
