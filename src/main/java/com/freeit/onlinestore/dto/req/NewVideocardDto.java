package com.freeit.onlinestore.dto.req;

import com.freeit.onlinestore.dto.AbstractProductDto;
import com.freeit.onlinestore.model.VideoMemoryType;
import com.freeit.onlinestore.model.VideocardProducer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NewVideocardDto extends AbstractProductDto {
    private Integer memorySize;
    private Integer memoryBuswidth;
    private Integer memoryFrequency;
    private Integer processorFrequency;
    private VideoMemoryType memoryType;
    private VideocardProducer producer;
}