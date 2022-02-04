package com.rexus.dft.dominio.categoriaservico;

import com.rexus.dft.converter.TipoMetodologiaEnumConverter;
import com.rexus.dft.enums.TipoMetodologiaEnum;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_categoria_servico")
public class CategoriaServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria_servico", nullable = false)
    public Long id;

    @Column(name = "ds_categoria_servico", nullable = false)
    public String descricao;

    @Column(name = "tp_metodologia", nullable = false, length = 1)
    @Convert(converter = TipoMetodologiaEnumConverter.class)
    public TipoMetodologiaEnum tipo;

    public CategoriaServico() {}

    public CategoriaServico(String descricao, TipoMetodologiaEnum tipo) {
        this.descricao = descricao;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
	return descricao;
    }

    @Override
    public int hashCode() {
	return Objects.hash(id);
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CategoriaServico that = (CategoriaServico) o;
        return Objects.equals(id, that.id);
    }
}