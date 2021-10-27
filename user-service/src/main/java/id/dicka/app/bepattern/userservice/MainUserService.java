package id.dicka.app.bepattern.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({
        "id.dicka.app.bepattern.*",
        "id.dicka.app.bepattern.commonservice.config"
})
public class MainUserService {

    public static void main(String[] args){
        SpringApplication.run(MainUserService.class);
    }

}


