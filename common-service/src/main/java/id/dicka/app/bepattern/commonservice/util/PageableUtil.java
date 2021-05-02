package id.dicka.app.bepattern.commonservice.util;

import id.dicka.app.bepattern.commonservice.base.BasePaginationRequest;
import id.dicka.app.bepattern.commonservice.model.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static com.google.common.base.CaseFormat.LOWER_CAMEL;
import static com.google.common.base.CaseFormat.LOWER_UNDERSCORE;

public class PageableUtil {

    private static final String ASC_VALUE = "ASC";

    public static PageRequest createPageRequestNative(BasePaginationRequest request, Integer defaultPageSize, Integer defaultPageNumber, String defaultSortBy, String defaultSortType){

        if (request.getSortBy() != null && request.getSortBy().matches("([a-z]+[A-Z]+\\w+)+")){
            request.setSortBy(LOWER_CAMEL.to(LOWER_UNDERSCORE, request.getSortBy()));
        }

        if (defaultSortBy.matches("([a-z]+[A-Z]+\\w+)+")) {
            defaultSortBy = LOWER_CAMEL.to(LOWER_UNDERSCORE, defaultSortBy);
        }

        if (request.getPageSize() != null) {
            defaultPageSize = request.getPageSize();
        }

        if (request.getPageNumber() != null) {
            defaultPageNumber = request.getPageNumber();
        }

        if (request.getSortBy() != null) {
            defaultSortBy = request.getSortBy();
        }

        if (request.getSortType() != null) {
            defaultSortType = request.getSortType();
        }

        //paging in jpa starts from 0
        return PageRequest.of(defaultPageNumber - 1, defaultPageSize, ASC_VALUE.equalsIgnoreCase(defaultSortType) ? Sort.Direction.ASC : Sort.Direction.DESC, defaultSortBy);
    }

    public static PageRequest createPageRequest(BasePaginationRequest request, Integer defaultPageSize, Integer defaultPageNumber, String defaultSortBy, String defaultSortType){

        if (request.getSortBy() != null && request.getSortBy().contains("_")) {
            request.setSortBy(LOWER_UNDERSCORE.to(LOWER_CAMEL, request.getSortBy()));
        }

        if (defaultSortBy.contains("_")) {
            defaultSortBy = LOWER_UNDERSCORE.to(LOWER_CAMEL, defaultSortBy);
        }

        if (request.getPageSize() != null) {
            defaultPageSize = request.getPageSize();
        }

        if (request.getPageNumber() != null) {
            defaultPageNumber = request.getPageNumber();
        }

        if (request.getSortBy() != null) {
            defaultSortBy = request.getSortBy();
        }

        if (request.getSortType() != null) {
            defaultSortType = request.getSortType();
        }

        //paging in jpa starts from 0
        return PageRequest.of(defaultPageNumber - 1, defaultPageSize, ASC_VALUE.equalsIgnoreCase(defaultSortType) ? Sort.Direction.ASC : Sort.Direction.DESC, defaultSortBy);

    }

    public static <T> Pagination pageToPagination(Page<T> page){
        return Pagination.builder()
                .pageSize(page.getSize())
                .currentPage(page.getNumber() + 1)
                .totalPages(page.getTotalPages())
                .totalRecords(page.getTotalElements())
                .isFirstPage(page.isFirst())
                .isLastPage(page.isLast())
                .build();
    }
}
