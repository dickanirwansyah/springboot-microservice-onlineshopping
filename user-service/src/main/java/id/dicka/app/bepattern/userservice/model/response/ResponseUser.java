package id.dicka.app.bepattern.userservice.model.response;

import id.dicka.app.bepattern.commonservice.command.service.ServiceRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUser implements ServiceRequest {

    private String userId;
    private String name;

}
