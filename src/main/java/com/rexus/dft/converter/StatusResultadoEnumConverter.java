package com.rexus.dft.converter;

import com.rexus.dft.enums.StatusResultadoEnum;

import javax.persistence.AttributeConverter;

public class StatusResultadoEnumConverter implements AttributeConverter<StatusResultadoEnum, Character> {

    @Override
    public Character convertToDatabaseColumn(StatusResultadoEnum tipo) {
        return (tipo == null) ? null : tipo.getCodigo();
    }

    @Override
    public StatusResultadoEnum convertToEntityAttribute(Character codigo) {
        return StatusResultadoEnum.criar(codigo);
    }

}
