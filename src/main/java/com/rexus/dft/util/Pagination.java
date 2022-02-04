package com.rexus.dft.util;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

import java.util.Optional;

import static io.quarkus.panache.common.Sort.Direction.Ascending;
import static io.quarkus.panache.common.Sort.Direction.Descending;

public class Pagination {

    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int DEFAULT_PAGE_SIZE = 100;
    private static final Sort.Direction DEFAULT_SORT_ORDER = Ascending;

    /** Atributo para ordenação */
    public String sort;
    /** Direção da ordenação (ascendente | descendente) */
    public String order;
    /** Número da página (zero-based index) */
    public Integer page;
    /** Tamanho da página */
    public Integer size;

    public Sort toSort() {
        if (sort == null) {
            return null;
        }

        return Sort.by(sort, getDirection());
    }

    private Sort.Direction getDirection() {
        if (order == null) {
            return DEFAULT_SORT_ORDER;
        }
        return order.equals("asc") ?
                Ascending :
                Descending;
    }

    public Page toPage() {
        var _page = Optional.ofNullable(page).orElse(DEFAULT_PAGE_NUMBER);
        var _size = Optional.ofNullable(size).orElse(DEFAULT_PAGE_SIZE);
        return Page.of(_page, _size);
    }
}