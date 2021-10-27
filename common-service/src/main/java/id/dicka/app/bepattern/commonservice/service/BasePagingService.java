package id.dicka.app.bepattern.commonservice.service;

import id.dicka.app.bepattern.commonservice.base.BasePaginationRequest;
import id.dicka.app.bepattern.commonservice.base.BasePaginationResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BasePagingService <REQUEST extends BasePaginationRequest, RESPONSE extends BasePaginationResponse>
    implements BaseService<REQUEST, RESPONSE>{

    @Value("${pageable.page.size}")
    private Integer pageSize;

    @Value("${pageable.page.number}")
    private Integer pageNumber;

    @Value("${pageable.page.sortBy}")
    private String sortBy;

    @Value("${pageable.page.sortType}")
    private String sortType;

}
