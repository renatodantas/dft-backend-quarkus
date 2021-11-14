package com.rexus.dft.dominio.categoriaservico;

import com.rexus.dft.dominio.categoriaservico.dto.CategoriaServicoDto;
import org.mapstruct.Mapper;

import com.rexus.dft.util.BaseMapper;

@Mapper(componentModel = "cdi")
interface CategoriaServicoMapper extends BaseMapper<CategoriaServico, CategoriaServicoDto> {

}