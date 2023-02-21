package com.rbnico.productmicorservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class ListResponse<T> {

    private List<T> results = new ArrayList<>();
    private Integer pageSize = 0;
    private Integer page = 0;
    private String sortBy = "";

    public ListResponse (List results, Pageable paging) {
        this.results = results;
        this.page = paging.getPageNumber();
        this.pageSize = paging.getPageSize();
        this.sortBy = paging.getSort().toString();
    }

    public ListResponse (List results) {
        this.results = results;
    }

    public void add( T t ) {
        results.add( t );
    }
}
