package ru.shmvsky.browserfileexplorer.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
@EnableConfigurationProperties(ExplorerProperties.class)
public class ExplorerAutoConfiguration {

    @Bean
    public ExplorerConfiguration initExplorerConfiguration(ExplorerProperties properties)
            throws SecurityException, IOException {
        ExplorerConfiguration configuration = new ExplorerConfiguration();

        if (properties.getTitle() != null && !properties.getTitle().isBlank()) {
            configuration.setTitle(properties.getTitle());
        }

        if (properties.getDescription() != null && !properties.getDescription().isBlank()) {
            configuration.setDescription(properties.getDescription());
        }

        if (properties.getBaseDirPath() != null) {
            Path baseDirRealPath = Paths.get(properties.getBaseDirPath()).toRealPath();
            configuration.setBaseDirPath(baseDirRealPath.toString());
        }

        return configuration;
    }

}
