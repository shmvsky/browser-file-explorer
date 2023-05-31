package ru.shmvsky.browserfileexplorer.service;

import org.springframework.stereotype.Service;
import ru.shmvsky.browserfileexplorer.configuration.ExplorerConfiguration;
import ru.shmvsky.browserfileexplorer.exception.ExplorerRuntimeException;
import ru.shmvsky.browserfileexplorer.util.ExplorerUtils;
import ru.shmvsky.browserfileexplorer.vo.FileModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExplorerService {

    private final ExplorerConfiguration explorerConfiguration;

    public ExplorerService(ExplorerConfiguration explorerConfiguration) {
        this.explorerConfiguration = explorerConfiguration;
    }

    private File getDirectory(String dirPath) {

        Path dirPathObj;
        try {
            dirPathObj = Paths.get(dirPath).normalize();
        } catch (InvalidPathException ex) {
            throw new ExplorerRuntimeException("Incorrect path");
        }

        Path realDirPath;
        try {
            realDirPath = dirPathObj.toRealPath();
        } catch (IOException | SecurityException ex) {
            throw new ExplorerRuntimeException("Folder does not exist");
        }

        Path baseDirPath = Paths.get(explorerConfiguration.getBaseDirPath());
        if (realDirPath.compareTo(baseDirPath) < 0) {
            throw new ExplorerRuntimeException("No access");
        }

        return realDirPath.toFile();
    }

    private String getParentDirPath(File dir, File baseDir) {
        File parentDir = dir.getParentFile();
        if (parentDir != null && !parentDir.equals(baseDir) && parentDir.compareTo(baseDir) > 0) {
            return ExplorerUtils.normalizePath(parentDir.getAbsolutePath());
        }
        return ExplorerUtils.normalizePath(baseDir.getAbsolutePath());
    }

    private List<FileModel> makeBreadCrumb(File dir, File baseDir) {
        List<FileModel> breadCrumb = new ArrayList<>();
        while (!dir.equals(baseDir)) {
            breadCrumb.add(new FileModel(dir));
            dir = dir.getParentFile();
        }
        Collections.reverse(breadCrumb);
        return breadCrumb;
    }

    public List<FileModel> getFiles(File dir) {
        if (dir.isFile()) {
            throw new ExplorerRuntimeException("Cannot read files");
        }
        return Arrays.stream(dir.listFiles())
                .map(FileModel::new)
                .collect(Collectors.toList());
    }

    public Map<String, String> buildMeta() {
        Map<String, String> meta = new HashMap<>();
        meta.put("title", explorerConfiguration.getTitle());
        meta.put("description", explorerConfiguration.getDescription());
        return meta;
    }

    public Map<String, Object> buildContent(String dirPath) {
        File dir = getDirectory(dirPath);
        File baseDir = getDirectory(explorerConfiguration.getBaseDirPath());

        Map<String, Object> content = new HashMap<>();

        content.put("baseDirPath", explorerConfiguration.getBaseDirPath());
        content.put("parentDirPath", getParentDirPath(dir, baseDir));
        content.put("breadCrumb", makeBreadCrumb(dir, baseDir));
        content.put("files", getFiles(dir));

        return content;
    }

}
