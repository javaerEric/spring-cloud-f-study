package com.xinguangnet.configclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * @Author: duozl
 * @Date: 2018/3/30 9:55
 */
@Configuration
@ConfigurationProperties(prefix = "info")
public class Info implements Serializable {

    private String profile;

    private String from;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "Info{" +
                "profile='" + profile + '\'' +
                ", from='" + from + '\'' +
                '}';
    }
}
