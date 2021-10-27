package id.dicka.app.bepattern.userservice.base.response;

import id.dicka.app.bepattern.commonservice.base.BasePaginationResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListUserResponse extends BasePaginationResponse {

    private List<ContentUser> content;

}
