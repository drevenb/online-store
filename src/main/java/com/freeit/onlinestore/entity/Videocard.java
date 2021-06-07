package com.freeit.onlinestore.entity;

import com.freeit.onlinestore.model.VideoMemoryType;
import com.freeit.onlinestore.model.VideocardProducer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="videocard")
@EqualsAndHashCode(callSuper = true)
public class Videocard extends AbstractEntity {

    @Column(name="graphic_processor", nullable = false)
    private String graphicProcessor;

    @Column(name="memory_size", nullable = false)
    private Integer memorySize;

    @Column(name="memory_buswidth", nullable = false)
    private Integer memoryBuswidth;

    @Column(name="memory_frequency", nullable = false)
    private Integer memoryFrequency;

    @Column(name="processor_frequency", nullable = false)
    private Integer processorFrequency;

    @Column(name="video_memory_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private VideoMemoryType memoryType;

    @Column(name="producer", nullable = false)
    @Enumerated(EnumType.STRING)
    private VideocardProducer producer;
}
