package com.rexus.dft.converter;

import javax.persistence.AttributeConverter;

import com.rexus.dft.enums.TipoMetodologiaEnum;

public class TipoMetodologiaEnumConverter implements AttributeConverter<TipoMetodologiaEnum, Character> {

    @Override
    public Character convertToDatabaseColumn(TipoMetodologiaEnum tipo) {
        return tipo == null ? TipoMetodologiaEnum.TIPICA.getCodigo() : tipo.getCodigo();
    }

    @Override
    public TipoMetodologiaEnum convertToEntityAttribute(Character codigo) {
        return TipoMetodologiaEnum.of(codigo);
    }

}
