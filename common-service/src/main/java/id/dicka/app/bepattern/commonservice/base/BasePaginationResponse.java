package id.dicka.app.bepattern.commonservice.base;

import id.dicka.app.bepattern.commonservice.model.Pagination;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasePaginationResponse extends BaseResponse {

    private Pagination pagination;

}
