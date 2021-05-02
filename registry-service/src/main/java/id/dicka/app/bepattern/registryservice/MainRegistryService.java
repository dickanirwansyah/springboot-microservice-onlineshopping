package id.dicka.app.bepattern.registryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MainRegistryService {

    public static void main(String[] args){
        SpringApplication.run(MainRegistryService.class);
    }
}
