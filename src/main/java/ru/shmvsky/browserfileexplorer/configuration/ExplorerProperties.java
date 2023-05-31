package ru.shmvsky.browserfileexplorer.configuration;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;
import ru.shmvsky.browserfileexplorer.validation.RealPath;

@ConfigurationProperties(prefix = "file-explorer")
@Validated
public class ExplorerProperties {
    private String title = "File Explorer";

    private String description = "File Explorer in your Web Browser!";

    @RealPath
    @NotBlank
    private String baseDirPath;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBaseDirPath() {
        return baseDirPath;
    }

    public void setBaseDirPath(String baseDirPath) {
        this.baseDirPath = baseDirPath;
    }
}
