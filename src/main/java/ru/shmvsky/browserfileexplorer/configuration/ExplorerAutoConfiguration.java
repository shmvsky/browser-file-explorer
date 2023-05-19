package ru.shmvsky.browserfileexplorer.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(ExplorerProperties.class)
public class ExplorerAutoConfiguration {

    @Bean
    public ExplorerConfiguration initConfiguration(ExplorerProperties properties) {
        ExplorerConfiguration configuration = new ExplorerConfiguration();

        if (!properties.getTitle().isBlank()) {
            configuration.setTitle(properties.getTitle());
        }

        if (!properties.getDescription().isBlank()) {
            configuration.setDescription(properties.getDescription());
        }

        if (!properties.getBaseDirPath().isBlank()) {
            configuration.setBaseDirPath(properties.getBaseDirPath());
        }

        return configuration;
    }

}
