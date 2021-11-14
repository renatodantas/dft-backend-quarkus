package com.rexus.dft.enums;

public interface IBaseMensagem {

  /**
   * @return a sigla do módulo
   */
  String getModulo();

  /**
   * @return o código negocial do erro
   */
  int getCodigo();

  /**
   * @return a mensagem negocial do erro
   */
  String getMensagem();

  /**
   * Retorna o código negocial da mensagem junto com a sigla do módulo.
   * 
   * @return Exemplo de retorno:
   *         -Módulo ARQ e Mensagem 1234: (ARQ-1234) -Módulo PJE e Mensagem 54: (PJE-54)
   */
  default String getCodigoCompleto() {
    return getModulo() + '-' + String.format("%03d", getCodigo());
  }
}