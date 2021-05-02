package id.dicka.app.bepattern.userservice.controller;

import id.dicka.app.bepattern.userservice.command.SaveUserCommand;
import id.dicka.app.bepattern.userservice.model.request.RequestUser;
import id.dicka.app.bepattern.userservice.model.response.ResponseUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    private SaveUserCommand saveUserCommand;
    public UserController (SaveUserCommand saveUserCommand){
        this.saveUserCommand = saveUserCommand;
    }

    @PostMapping(value = "/save-user")
    public ResponseEntity<ResponseUser> saveUser(@RequestBody RequestUser requestUser){
        ResponseUser responseUser = saveUserCommand.execute(requestUser);
        return new ResponseEntity<>(responseUser, HttpStatus.OK);
    }
}
