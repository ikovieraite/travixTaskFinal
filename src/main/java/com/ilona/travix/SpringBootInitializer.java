package com.ilona.travix;

import com.ilona.travix.configuration.SpringCoreConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by ilonaK on 17/02/2017.
 */
public class SpringBootInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringCoreConfiguration.class);
    }
}
