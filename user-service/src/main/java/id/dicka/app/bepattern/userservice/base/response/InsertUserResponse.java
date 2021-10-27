package id.dicka.app.bepattern.userservice.base.response;

import id.dicka.app.bepattern.commonservice.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InsertUserResponse extends BaseResponse {

    private String userId;
    private String name;

}
