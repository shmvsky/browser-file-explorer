package ru.shmvsky.browserfileexplorer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.shmvsky.browserfileexplorer.configuration.ExplorerConfiguration;

@SpringBootApplication
public class BrowserFileExplorerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrowserFileExplorerApplication.class, args);
    }

    @Bean
    CommandLineRunner initCommandLineRunner(ExplorerConfiguration configuration) {
        return (args) -> {
            System.out.println(configuration);
        };
    }

}
