package id.dicka.app.bepattern.userservice.command.impl;

import id.dicka.app.bepattern.commonservice.command.abstracts.AbstractsCommand;
import id.dicka.app.bepattern.userservice.command.SaveUserCommand;
import id.dicka.app.bepattern.userservice.model.entity.MstUser;
import id.dicka.app.bepattern.userservice.model.request.RequestUser;
import id.dicka.app.bepattern.userservice.model.response.ResponseUser;
import id.dicka.app.bepattern.userservice.repository.MstUserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SaveUserCommandImpl extends AbstractsCommand<ResponseUser, RequestUser>
    implements SaveUserCommand {

    private MstUserRepository mstUserRepository;
    public SaveUserCommandImpl(MstUserRepository mstUserRepository){
        this.mstUserRepository = mstUserRepository;
    }

    @Override
    public ResponseUser doExecute(RequestUser request) {
        Optional<MstUser> findUser = mstUserRepository.findById(request.getUserId());
        MstUser mstUser = null;
        if (findUser.isPresent()){
            findUser.get().setName(request.getName());
            mstUser = mstUserRepository.save(findUser.get());
        }
        mstUser = mstUserRepository.save(new MstUser(request.getUserId(), request.getName()));
        return new ResponseUser(mstUser.getUserId(), mstUser.getName());
    }
}
