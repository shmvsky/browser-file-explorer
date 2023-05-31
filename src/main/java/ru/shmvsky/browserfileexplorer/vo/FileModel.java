package ru.shmvsky.browserfileexplorer.vo;

import ru.shmvsky.browserfileexplorer.util.ExplorerUtils;

import java.io.File;

public final class FileModel {
    private final String path;
    private final String name;
    private final boolean isFile;

    public FileModel(File file) {
        this.path = ExplorerUtils.normalizePath(file.getAbsolutePath());
        this.name = file.getName();
        this.isFile = file.isFile();
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public boolean isFile() {
        return isFile;
    }

}
