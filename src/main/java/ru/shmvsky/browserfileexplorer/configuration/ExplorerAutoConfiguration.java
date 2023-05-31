package ru.shmvsky.browserfileexplorer.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.shmvsky.browserfileexplorer.util.ExplorerUtils;

@Configuration
@EnableConfigurationProperties(ExplorerProperties.class)
public class ExplorerAutoConfiguration {

    @Bean
    public ExplorerConfiguration initExplorerConfiguration(ExplorerProperties explorerProperties) {
        ExplorerConfiguration explorerConfiguration = new ExplorerConfiguration();
        explorerConfiguration.setTitle(explorerProperties.getTitle());
        explorerConfiguration.setDescription(explorerProperties.getDescription());
        explorerConfiguration.setBaseDirPath(ExplorerUtils.normalizePath(explorerProperties.getBaseDirPath()));
        return explorerConfiguration;
    }

}
