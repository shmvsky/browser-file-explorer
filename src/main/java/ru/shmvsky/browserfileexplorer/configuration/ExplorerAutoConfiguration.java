package ru.shmvsky.browserfileexplorer.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Paths;

@Configuration
@EnableConfigurationProperties(ExplorerProperties.class)
public class ExplorerAutoConfiguration {

    @Bean
    public ExplorerConfiguration initExplorerConfiguration(ExplorerProperties explorerProperties) {
        ExplorerConfiguration explorerConfiguration = new ExplorerConfiguration();
        explorerConfiguration.setTitle(explorerProperties.getTitle());
        explorerConfiguration.setDescription(explorerProperties.getDescription());
        explorerConfiguration.setBaseDirPath(Paths.get(explorerProperties.getBaseDirPath()).toAbsolutePath().toString());
        return explorerConfiguration;
    }

}
