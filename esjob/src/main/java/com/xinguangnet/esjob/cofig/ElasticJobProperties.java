package com.xinguangnet.esjob.cofig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: duozl
 * @Date: 2018/3/28 10:46
 */
@Configuration
@ConfigurationProperties(prefix = "elastic.job")
public class ElasticJobProperties {

    private String namespace;

    private String digest;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }
}
