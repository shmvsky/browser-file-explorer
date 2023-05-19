package ru.shmvsky.browserfileexplorer.configuration;

public class ExplorerConfiguration {
    private String title = "File Explorer";
    private String description = "Browser File Explorer in your Web Browser!";
    private String baseDirPath = "";

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
