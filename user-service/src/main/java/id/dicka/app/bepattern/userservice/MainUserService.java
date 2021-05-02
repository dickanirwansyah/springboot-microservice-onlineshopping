package id.dicka.app.bepattern.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MainUserService {

    public static void main(String[] args){
        SpringApplication.run(MainUserService.class);
    }

}
