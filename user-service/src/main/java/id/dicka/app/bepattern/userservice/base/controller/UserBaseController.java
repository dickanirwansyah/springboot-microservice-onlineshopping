package id.dicka.app.bepattern.userservice.base.controller;

import id.dicka.app.bepattern.userservice.base.InsertBaseUser;
import id.dicka.app.bepattern.userservice.base.ListBaseUser;
import id.dicka.app.bepattern.userservice.base.request.InsertUserRequest;
import id.dicka.app.bepattern.userservice.base.request.ListUserRequest;
import id.dicka.app.bepattern.userservice.base.response.InsertUserResponse;
import id.dicka.app.bepattern.userservice.base.response.ListUserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/base/")
public class UserBaseController {

    private InsertBaseUser insertBaseUser;
    private ListBaseUser listBaseUser;
    public UserBaseController(InsertBaseUser insertBaseUser, ListBaseUser listBaseUser){
        this.insertBaseUser = insertBaseUser;
        this.listBaseUser = listBaseUser;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<InsertUserResponse> save(@RequestBody InsertUserRequest insertUserRequest){
        InsertUserResponse insertUserResponse = insertBaseUser.execute(insertUserRequest);
        return new ResponseEntity<>(insertUserResponse, HttpStatus.OK);
    }

    /** default page uri
     *
     *  -> no request http://localhost:8881/api/base/list
     *  -> with request http://localhost:8881/api/base/list?pageNumber=1&pageSize=1
     *  -> with multiple request http://localhost:8881/api/base/list?userId=xxx&name=dicka_nirwansyah&pageNumber=1&pageSize=2
     *
     * **/

    @GetMapping(value = "/list")
    public ResponseEntity<ListUserResponse> list(ListUserRequest request){
        ListUserResponse listUserResponse = listBaseUser.execute(request);
        return new ResponseEntity<>(listUserResponse, HttpStatus.OK);
    }
}
