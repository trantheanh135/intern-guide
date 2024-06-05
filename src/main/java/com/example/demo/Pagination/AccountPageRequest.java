package com.example.demo.Pagination;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;

@Data
@Getter
@Setter
public class AccountPageRequest implements Pageable {

    private Integer limit;
    private Integer offset;
    private final Sort sort;

    public AccountPageRequest(Integer limit, Integer offset, Sort sort) {
        this.limit = limit;
        this.offset = offset;
        this.sort = sort;
    }

    public AccountPageRequest(Integer limit, Integer offset) {
        this(limit, offset, Sort.unsorted());
    }

    @Override
    public int getNumberOfPages() {
        return offset / limit;
    }

    @Override
    public PageFormat getPageFormat(int pageIndex) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Printable getPrintable(int pageIndex) throws IndexOutOfBoundsException {
        return null;
    }

    public Pageable next(){
        return new AccountPageRequest(getLimit(), getOffset() + getLimit());
    }

    public Pageable previous(){
        return hasPreviours() ?
                new AccountPageRequest(getLimit(), getOffset() - getLimit()) : this;
    }

    public Pageable first(){
        return new AccountPageRequest(getLimit(),0);
    }

    public Pageable previousOrFirst(){
        return hasPreviours() ? previous() : first();
    }

    public Pageable withPage(int pageNumber){
        return new AccountPageRequest(getLimit(),pageNumber * getLimit());
    }

    private boolean hasPreviours(){
        return offset > limit;
    }

}
