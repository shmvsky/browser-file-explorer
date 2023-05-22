package ru.shmvsky.browserfileexplorer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.shmvsky.browserfileexplorer.configuration.ExplorerConfiguration;
import ru.shmvsky.browserfileexplorer.service.ExplorerService;

import java.nio.file.Paths;

@SpringBootApplication
public class BrowserFileExplorerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrowserFileExplorerApplication.class, args);
    }

    @Bean
    CommandLineRunner initCommandLineRunner(ExplorerConfiguration configuration) {
        return (args) -> {
            System.out.println(configuration);


//            System.out.println(Paths.get("C:\\Documents\\Newsletters\\Summer2018.pdf"));
//            System.out.println(Paths.get("\\Program Files\\Custom Utilities\\StringFinder.exe"));
//            System.out.println(Paths.get("2018\\January.xlsx"));
//            System.out.println(Paths.get("..\\Publications\\TravelBrochure.pdf"));
//            System.out.println(Paths.get("C:\\Projects\\apilibrary\\apilibrary.sln"));
            Paths.get("/users");
            Paths.get("\\Users");
            Paths.get("C:\\Users"); // C:/
            Paths.get("C:/Users"); // C:/




        };
    }

}
