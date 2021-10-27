package id.dicka.app.bepattern.userservice.base.controller;

import com.alibaba.fastjson.JSON;
import id.dicka.app.bepattern.commonservice.util.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/api/users/v1")
public class UsersController {

    @Autowired
    private CacheUtil cacheUtil;

    @GetMapping(value = "/session")
    public String saveSession(){
        cacheUtil.set("SESSION_ID", "dickanirwansyah", JSON.toJSONString(Arrays.asList("admin", "staff")), 100);
        return cacheUtil.get("SESSION_ID", "dickanirwansyah");
    }
}
