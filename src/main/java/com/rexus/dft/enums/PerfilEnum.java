package com.rexus.dft.enums;

import java.util.Arrays;

public enum PerfilEnum {

    GESTOR_GERAL(1),
    GESTOR_DE_ORGAO(2),
    GESTOR_DE_UNIDADE(3),
    USUARIO(4),
    NAO_ENCONTRADO(0);

    private final int codigo;

    PerfilEnum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static PerfilEnum criar(int codigo) {
        return Arrays.stream(PerfilEnum.values()).filter(p -> p.getCodigo() == codigo).findFirst()
                .orElse(PerfilEnum.NAO_ENCONTRADO);
    }
}
