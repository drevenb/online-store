package com.freeit.onlinestore.mapper;

import com.freeit.onlinestore.dto.AbstractDto;
import com.freeit.onlinestore.entity.AbstractEntity;

import java.util.Collection;
import java.util.List;

public interface Mapper <E extends AbstractEntity, D extends AbstractDto>{

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(Collection<D> dtos);

    List<D> toDto(Collection<E> entities);
}
