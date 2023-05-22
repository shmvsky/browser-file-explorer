package ru.shmvsky.browserfileexplorer.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InvalidPropertiesFormatException;

@Configuration
@EnableConfigurationProperties(ExplorerProperties.class)
public class ExplorerAutoConfiguration {

    @Bean
    public ExplorerConfiguration initExplorerConfiguration(ExplorerProperties properties)
            throws InvalidPathException, SecurityException {
        ExplorerConfiguration configuration = new ExplorerConfiguration();

        if (properties.getTitle() != null && !properties.getTitle().isBlank()) {
            configuration.setTitle(properties.getTitle());
        }

        if (properties.getDescription() != null && !properties.getDescription().isBlank()) {
            configuration.setDescription(properties.getDescription());
        }

        if (properties.getBaseDirPath() != null) {
            Path baseDirPathObj = Paths.get(properties.getBaseDirPath()).normalize();
            File baseDir = baseDirPathObj.toFile();
            if (!properties.getBaseDirPath().isBlank() && baseDir.exists() && baseDir.isDirectory()) {
                String linuxLikePath = baseDirPathObj.toString().replaceAll("((\\w:\\\\)|(\\\\))", "/");
                configuration.setBaseDirPath(linuxLikePath);
            }
        }

        return configuration;
    }

}
