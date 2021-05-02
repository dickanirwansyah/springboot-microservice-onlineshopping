package id.dicka.app.bepattern.userservice.base;

import id.dicka.app.bepattern.commonservice.service.BaseService;
import id.dicka.app.bepattern.userservice.base.request.InsertUserRequest;
import id.dicka.app.bepattern.userservice.base.response.InsertUserResponse;
import id.dicka.app.bepattern.userservice.model.entity.MstUser;
import id.dicka.app.bepattern.userservice.repository.MstUserRepository;
import org.springframework.stereotype.Service;

@Service
public class InsertBaseUser implements BaseService<InsertUserRequest, InsertUserResponse> {

    private MstUserRepository mstUserRepository;
    public InsertBaseUser(MstUserRepository mstUserRepository){
        this.mstUserRepository = mstUserRepository;
    }

    @Override
    public InsertUserResponse execute(InsertUserRequest request) {
        InsertUserResponse insertUserResponse = new InsertUserResponse();
        MstUser mstUser = mstUserRepository.save(new MstUser(request.getUserId(), request.getName()));
        insertUserResponse.setName(mstUser.getName());
        insertUserResponse.setUserId(mstUser.getUserId());
        return insertUserResponse;
    }
}
