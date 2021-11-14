package com.rexus.dft.enums;

import java.util.Arrays;

public enum TipoIndicadorEnum {

  DIAS('D'), HORAS('H'), QUANTIDADE('Q');

  private final char codigo;

  TipoIndicadorEnum(char codigo) {
    this.codigo = codigo;
  }

  public char getCodigo() {
    return codigo;
  }

  public static TipoIndicadorEnum criar(Character tipo) {
    if (tipo == null) {
      return null;
    }
    return Arrays.stream(values()).filter(t -> t.codigo == tipo).findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Tipo de indicador inválido: " + tipo));
  }

  @Override
  public String toString() {
    return this.name();
  }
}