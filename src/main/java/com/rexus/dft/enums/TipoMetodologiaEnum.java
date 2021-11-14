package com.rexus.dft.enums;

import java.util.Arrays;

public enum TipoMetodologiaEnum {

    TIPICA('T'),
    ATIPICA('A'),
    OUTRA('O');

    private final char codigo;

    TipoMetodologiaEnum(char codigo) {
        this.codigo = codigo;
    }

    public char getCodigo() {
        return codigo;
    }

    public static TipoMetodologiaEnum of(Character tipoUnidade) {
        if (tipoUnidade == null) {
            return null;
        }
        return Arrays.stream(TipoMetodologiaEnum.values())
                .filter(p -> p.getCodigo() == tipoUnidade)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Tipo não encontrado"));
    }
}
