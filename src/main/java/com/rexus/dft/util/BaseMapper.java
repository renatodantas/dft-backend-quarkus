package com.rexus.dft.util;

import java.util.Collection;
import java.util.List;

public interface BaseMapper<E, T> {

    E toEntity(T dto);
    T toDto(E entidade);
    List<E> toEntities(Collection<T> dtos);
    List<T> toDtos(Collection<E> entidades);
}