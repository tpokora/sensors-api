package org.tpokora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.tpokora.sheets.config.SheetsConfiguration;

@SpringBootApplication
@ComponentScan(basePackages = { "org.tpokora" })
@EnableConfigurationProperties({SheetsConfiguration.class})
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }
}