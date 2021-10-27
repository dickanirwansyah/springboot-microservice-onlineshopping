package id.dicka.app.bepattern.commonservice.config;

import io.lettuce.core.RedisClient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

@Data
@Slf4j
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "redis")
public class RedisConfig {

    private String hosts;
    private Integer port;
    private String password;
    private Integer dbIndex;

    @Bean(name = "redisClient")
    public RedisClient getRedisClient(){
        StringBuilder sbBuilder = new StringBuilder();
        sbBuilder.append("redis://");
        sbBuilder.append(ObjectUtils.isEmpty(this.getPassword()) ? "" : this.getPassword());
        sbBuilder.append("@");
        sbBuilder.append(this.getHosts());
        sbBuilder.append(":");
        sbBuilder.append(this.getPort());
        sbBuilder.append("/");
        sbBuilder.append(ObjectUtils.isEmpty(this.getDbIndex()) ? 0 : this.getDbIndex());
        log.info("connect to redis : {}", sbBuilder.toString());
        return RedisClient.create(sbBuilder.toString());
    }
}
