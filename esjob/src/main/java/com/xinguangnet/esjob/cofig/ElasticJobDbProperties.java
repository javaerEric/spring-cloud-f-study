package com.xinguangnet.esjob.cofig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: duozl
 * @Date: 2018/3/28 10:45
 */
@Configuration
@ConfigurationProperties(prefix = "elastic.job.db")
public class ElasticJobDbProperties {

    private String connectString;

    private String username;

    private String password;

    public String getConnectString() {
        return connectString;
    }

    public void setConnectString(String connectString) {
        this.connectString = connectString;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
