package com.rexus.dft.converter;

import com.rexus.dft.enums.TipoUnidadeEnum;

import javax.persistence.AttributeConverter;

public class TipoUnidadeEnumConverter implements AttributeConverter<TipoUnidadeEnum, Character> {

    @Override
    public Character convertToDatabaseColumn(TipoUnidadeEnum tipo) {
        return (tipo == null) ? null : tipo.getCodigo();
    }

    @Override
    public TipoUnidadeEnum convertToEntityAttribute(Character codigo) {
        return TipoUnidadeEnum.criar(codigo);
    }

}
