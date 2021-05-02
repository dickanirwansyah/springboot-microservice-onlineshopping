package id.dicka.app.bepattern.userservice.command;

import id.dicka.app.bepattern.commonservice.command.Command;
import id.dicka.app.bepattern.userservice.model.request.RequestUser;
import id.dicka.app.bepattern.userservice.model.response.ResponseUser;

public interface SaveUserCommand extends Command<ResponseUser, RequestUser> {
}
