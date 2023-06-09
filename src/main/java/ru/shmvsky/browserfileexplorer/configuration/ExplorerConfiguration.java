package ru.shmvsky.browserfileexplorer.configuration;

public class ExplorerConfiguration {
    private String title;
    private String description;
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

    @Override
    public String toString() {
        return "ExplorerConfiguration{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", baseDirPath='" + baseDirPath + '\'' +
                '}';
    }

}
