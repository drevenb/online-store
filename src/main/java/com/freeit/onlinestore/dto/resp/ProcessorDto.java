package com.freeit.onlinestore.dto.resp;

import com.freeit.onlinestore.dto.AbstractProductDto;
import com.freeit.onlinestore.model.ProcessorProducer;
import com.freeit.onlinestore.model.Socket;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProcessorDto extends AbstractProductDto {
    private UUID id;
    private Integer coresQuantity;
    private Integer frequency;
    private Socket socket;
    private ProcessorProducer producer;
}
