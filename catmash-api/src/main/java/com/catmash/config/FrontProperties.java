package com.catmash.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "catmash", ignoreUnknownFields = false)
public class FrontProperties {

    @Getter
    private final Front front = new Front();

    @Getter
    @Setter
    public static class Front {
        @Getter
        @Setter
        private String host;
    }
}
