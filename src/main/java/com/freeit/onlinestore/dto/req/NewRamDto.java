package com.freeit.onlinestore.dto.req;

import com.freeit.onlinestore.dto.AbstractProductDto;
import com.freeit.onlinestore.model.MemoryType;
import com.freeit.onlinestore.model.RamProducer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NewRamDto extends AbstractProductDto {
    private Integer memorySize;
    private Integer memoryFrequency;
    private String latency;
    private MemoryType memoryType;
    private RamProducer producer;
}
