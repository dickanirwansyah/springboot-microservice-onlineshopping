package id.dicka.app.bepattern.userservice.base.request;

import id.dicka.app.bepattern.commonservice.base.BasePaginationRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListUserRequest extends BasePaginationRequest {

    private String userId;
    private String name;

}
