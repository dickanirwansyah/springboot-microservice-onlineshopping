package id.dicka.app.bepattern.userservice.base.request;

import id.dicka.app.bepattern.commonservice.base.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InsertUserRequest extends BaseRequest {

    private String userId;
    private String name;

}
