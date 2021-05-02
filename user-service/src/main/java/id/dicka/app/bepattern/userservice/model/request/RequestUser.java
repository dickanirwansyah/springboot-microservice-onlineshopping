package id.dicka.app.bepattern.userservice.model.request;

import id.dicka.app.bepattern.commonservice.command.service.ServiceRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestUser implements ServiceRequest {

    private String userId;
    private String name;

}
