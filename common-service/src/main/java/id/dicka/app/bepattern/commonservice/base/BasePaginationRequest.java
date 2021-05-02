package id.dicka.app.bepattern.commonservice.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BasePaginationRequest extends BaseRequest{

    private Integer pageSize;
    private Integer pageNumber;
    private String sortBy;
    private String sortType;

}
