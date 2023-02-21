package com.rbnico.productmicorservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

import java.util.List;
@Getter
@Setter
public class ListResponse<T> {

    private List<T> results;
    private Integer pageSize = 0;
    private Integer page = 0;
    private String sortBy = "";

    public ListResponse (List<T> results, Pageable paging) {
        this.results = results;
        this.page = paging.getPageNumber();
        this.pageSize = paging.getPageSize();
        this.sortBy = paging.getSort().toString();
    }

    public ListResponse (List<T> results) {
        this.results = results;
    }

    public void add( T t ) {
        results.add( t );
    }
}
