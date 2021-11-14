package com.rexus.dft.dominio.categoriaservico;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoriaServicoRepository implements PanacheRepository<CategoriaServico> {
}