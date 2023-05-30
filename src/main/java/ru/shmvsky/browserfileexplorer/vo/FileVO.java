package ru.shmvsky.browserfileexplorer.vo;

import java.io.File;

public final class FileVO {
    private final String path;
    private final String name;

    private final boolean isFile;

    public FileVO(String path, String name, boolean isFile) {
        this.path = path.replace("\\", "/");
        this.name = name;
        this.isFile = isFile;
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

    public static FileVO fromFile(File file) {
        return new FileVO(file.getAbsolutePath(), file.getName(), file.isFile());
    }

}
