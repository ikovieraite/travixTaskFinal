package com.ilona.travix.configuration;

import com.ilona.travix.responses.CrazyAirResponse;
import com.ilona.travix.responses.ToughJetResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by ilonaK on 17/02/2017.
 */

@Configuration
@EnableScheduling
public class SpringCoreConfiguration {

    @Bean
    public CrazyAirResponse CrazyAirResponse() {return new CrazyAirResponse();}

    @Bean
    public ToughJetResponse ToughJetResponse() {return new ToughJetResponse();}



}
