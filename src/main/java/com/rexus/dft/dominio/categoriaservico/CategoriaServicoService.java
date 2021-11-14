package com.rexus.dft.dominio.categoriaservico;

import com.rexus.dft.dominio.categoriaservico.dto.CategoriaServicoDto;
import com.rexus.dft.dominio.categoriaservico.dto.CategoriaServicoSearchDto;
import com.rexus.dft.util.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.ConstraintViolationException;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CategoriaServicoService {

    private final CategoriaServicoRepository repository;
    private final CategoriaServicoMapper mapper;

    public CategoriaServicoService(
            CategoriaServicoRepository repository,
            CategoriaServicoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Realiza a busca de categorias de serviço por um tipo específico.
     * 
     * @param params      o valor para filtrar os registros
     * @param pagination  informações de paginação
     * @return as {@link CategoriaServico}s cadastradas
     */
    public List<CategoriaServicoDto> listar(CategoriaServicoSearchDto params, Pagination pagination) {
        if (StringUtils.isEmpty(params.filtro)) {
            return repository
                    .findAll(pagination.toSort())
                    .page(pagination.toPage())
                    .stream()
                    .map(mapper::toDto)
                    .toList();
        }
        return Collections.emptyList();

//        Page<CategoriaServico> paginados = repository.findAll(pagination.toPageable());
//        PanacheQuery<CategoriaServico> query = repository.find("", "");
//        List<CategoriaServicoDto> dtosPaginados = paginados.stream().map(mapper::toDto).collect(toList());
//        return pagination.toPage(paginados, dtosPaginados);
    }

    public Optional<CategoriaServicoDto> listar(long id) {
        return repository.findByIdOptional(id).map(mapper::toDto);
    }

    public void salvar(CategoriaServicoDto categoria) {
        CategoriaServico entity = mapper.toEntity(categoria);
        if (categoria.getId() != null) {
            CategoriaServicoDto dto = listar(categoria.getId())
        	    .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
            entity = mapper.toEntity(dto);
        }

        entity.setDescricao(categoria.getDescricao());
        entity.setTipo(categoria.getTipo());
        repository.persist(entity);
    }

    public void excluir(Long id) {
        CategoriaServico categoria = repository
                .findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Categoria inexistente"));
        try {
            repository.delete(categoria);
        } catch (Exception e) {
            if (e.getCause() instanceof ConstraintViolationException) {
                throw new InternalServerErrorException("Categoria em uso e não pode ser excluída");
            }
            throw e;
        }
    }
}