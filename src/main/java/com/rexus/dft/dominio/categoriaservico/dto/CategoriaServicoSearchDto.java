package com.rexus.dft.dominio.categoriaservico.dto;

import com.rexus.dft.enums.TipoMetodologiaEnum;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import javax.ws.rs.QueryParam;

public class CategoriaServicoSearchDto {

    @QueryParam("filtro")
    @Parameter(description = "Texto para filtro da descrição das categorias")
    public String filtro;

    @QueryParam("tipoMetodologia")
    @Parameter(description = "Tipo de metodologia para filtro das categorias")
    public TipoMetodologiaEnum metodologia;

    @Override
    public String toString() {
        return "CategoriaServicoSearchDto{" +
                "filtro='" + filtro + '\'' +
                ", tipoMetodologia=" + metodologia +
                '}';
    }
}