package com.freeit.onlinestore.dto.req;

import com.freeit.onlinestore.dto.AbstractDto;
import com.freeit.onlinestore.model.FormFactor;
import com.freeit.onlinestore.model.MemoryType;
import com.freeit.onlinestore.model.MotherboardProducer;
import com.freeit.onlinestore.model.Socket;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
public class NewMotherboardDto extends AbstractDto {
    private String name;
    private Integer memorySlots;
    private FormFactor formFactor;
    private MemoryType memoryType;
    private MotherboardProducer producer;
    private Socket socket;
    private double price;
    private Integer remainder;
}
