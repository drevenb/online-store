package com.freeit.onlinestore.dto.req;

import com.freeit.onlinestore.dto.AbstractProductDto;
import com.freeit.onlinestore.model.ProcessorProducer;
import com.freeit.onlinestore.model.Socket;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NewProcessorDto extends AbstractProductDto {
    private Integer coresQuantity;
    private Integer frequency;
    private Socket socket;
    private ProcessorProducer producer;
}
