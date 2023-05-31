package ru.shmvsky.browserfileexplorer.util;

import java.nio.file.Paths;

public class ExplorerUtils {

    public static String normalizePath(String path) {
        return Paths.get(path).toAbsolutePath().toString().replace("\\", "/");
    }

}
