package edu.nit.librarymanage.base;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    long total;
    List<T> list;

    public static <T> PageResult<T> of(List<T> list, long total) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setList(list);
        pageResult.setTotal(total);
        return pageResult;
    }
}
