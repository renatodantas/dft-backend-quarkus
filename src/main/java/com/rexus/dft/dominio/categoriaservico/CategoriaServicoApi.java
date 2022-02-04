package com.rexus.dft.dominio.categoriaservico;

import com.rexus.dft.dominio.categoriaservico.dto.CategoriaServicoDto;
import com.rexus.dft.dominio.categoriaservico.dto.CategoriaServicoSearchDto;
import com.rexus.dft.util.Pagination;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import java.util.List;
import java.util.Optional;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Classe responsável pelas invocações da API de categorias de serviço.
 */
// Link para como declarar as APIs no OpenAPI:
// https://download.eclipse.org/microprofile/microprofile-open-api-1.0/microprofile-openapi-spec.html
@Path("/api/categorias")
public class CategoriaServicoApi {

    private final CategoriaServicoService service;
    private final Logger log = LoggerFactory.getLogger(CategoriaServicoApi.class);

    public CategoriaServicoApi(CategoriaServicoService service) {
        this.service = service;
    }

    @GET
    @Produces(APPLICATION_JSON)
    @Operation(summary = "Lista as categorias por tipo de metodologia e descrição")
    @APIResponse(
            description = "As categorias paginadas",
            content = @Content(
                    mediaType = APPLICATION_JSON,
                    schema = @Schema(implementation = List.class)))
    public List<CategoriaServicoDto> listar(
            @BeanParam final CategoriaServicoSearchDto params,
            @BeanParam final Pagination pagination) {

        log.info("Pesquisando categorias de serviço: " + params);
        return service.listar(params, pagination);
    }

    @GET
    @Path("/{id}")
    @Operation(description = "Lista as categorias de serviço por ID")
    public Optional<CategoriaServicoDto> listarPorId(@PathParam("id") Long id) {
        return service.listar(id);
    }

    @POST
    public void criar(CategoriaServicoDto categoria) {
        service.salvar(categoria);
    }

    @PUT
    @Path("/{id}")
    public void atualizar(@PathParam("id") Long id, CategoriaServicoDto categoria) {
        if (service.listar(id).isEmpty()) {
            throw new NotFoundException("ID inexistente");
        }
        categoria.setId(id);
        service.salvar(categoria);
    }

    @DELETE
    @Path("/{id}")
    public void excluir(@PathParam("id") Long id) {
        service.excluir(id);
    }
}