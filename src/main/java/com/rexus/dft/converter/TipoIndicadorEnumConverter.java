package com.rexus.dft.converter;

import com.rexus.dft.enums.TipoIndicadorEnum;

import javax.persistence.AttributeConverter;

public class TipoIndicadorEnumConverter implements AttributeConverter<TipoIndicadorEnum, Character> {

    @Override
    public Character convertToDatabaseColumn(TipoIndicadorEnum tipo) {
        return (tipo == null) ? null : tipo.getCodigo();
    }

    @Override
    public TipoIndicadorEnum convertToEntityAttribute(Character codigo) {
        return TipoIndicadorEnum.criar(codigo);
    }

}