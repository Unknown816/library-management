package edu.nit.librarymanage.base;

import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
public class PageRequest {
    Integer pageSize = 10;
    Integer pageIndex = 1;

    public Pageable toPageable() {
        return org.springframework.data.domain.PageRequest.of(pageIndex-1, pageSize, Sort.unsorted());
    }
}
