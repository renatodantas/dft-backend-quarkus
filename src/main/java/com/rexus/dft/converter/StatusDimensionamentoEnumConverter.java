package com.rexus.dft.converter;

import com.rexus.dft.enums.StatusDimensionamentoEnum;

import javax.persistence.AttributeConverter;

public class StatusDimensionamentoEnumConverter implements AttributeConverter<StatusDimensionamentoEnum, Character> {

    @Override
    public Character convertToDatabaseColumn(StatusDimensionamentoEnum tipo) {
        return (tipo == null) ? null : tipo.getCodigo();
    }

    @Override
    public StatusDimensionamentoEnum convertToEntityAttribute(Character codigo) {
        return StatusDimensionamentoEnum.criar(codigo);
    }

}
