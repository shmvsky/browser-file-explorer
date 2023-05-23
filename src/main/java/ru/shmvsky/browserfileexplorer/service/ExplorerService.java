package ru.shmvsky.browserfileexplorer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shmvsky.browserfileexplorer.configuration.ExplorerConfiguration;
import ru.shmvsky.browserfileexplorer.exception.ExplorerRuntimeException;
import ru.shmvsky.browserfileexplorer.model.ContentVO;
import ru.shmvsky.browserfileexplorer.model.FileVO;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExplorerService {

    @Autowired
    private ExplorerConfiguration explorerConfiguration;

    private File getDirectory(String dirPath) throws ExplorerRuntimeException {

        Path dirPathObj;
        try {
            dirPathObj = Paths.get(dirPath).normalize();
        } catch (InvalidPathException ex) {
            throw new ExplorerRuntimeException("Incorrect path");
        }

        Path baseDirPath = Paths.get(explorerConfiguration.getBaseDirPath());

        Path dirPathResolved = baseDirPath.resolve(dirPathObj);

        Path realDirPath;
        try {
            realDirPath = dirPathResolved.toRealPath();
        } catch (IOException | SecurityException ex) {
            throw new ExplorerRuntimeException("Folder does not exist");
        }

        if (realDirPath.compareTo(baseDirPath) < 0) {
            throw new ExplorerRuntimeException("No access");
        }

        return realDirPath.toFile();
    }

    private File getParentDir(File dir, File baseDir) {
        File parentDir = dir.getParentFile();
        if (!parentDir.equals(baseDir) && dir.getParentFile() != null && parentDir.compareTo(baseDir) > 0) {
            return parentDir;
        }
        return baseDir;
    }

    private Deque<File> makeBreadCrumb(File dir, File baseDir) {
        Deque<File> breadCrumb = new ArrayDeque<>();

        while (!dir.equals(baseDir)) {
            breadCrumb.addFirst(dir);
            dir = dir.getParentFile();
        }

        return breadCrumb;
    }

    public List<File> getFiles(File dir) {
        return Arrays.asList(dir.listFiles());
    }

    public Map<String, String> buildMeta() {
        Map<String, String> meta = new HashMap<>();
        meta.put("title", explorerConfiguration.getTitle());
        meta.put("description", explorerConfiguration.getDescription());
        return meta;
    }

    public ContentVO buildContent(String dirPath) throws ExplorerRuntimeException {
        File dir = getDirectory(dirPath);
        File baseDir = new File(explorerConfiguration.getBaseDirPath());
        File parentDir = getParentDir(dir, baseDir);
        Deque<File> breadCrumb = makeBreadCrumb(dir, baseDir);
        List<File> files = getFiles(dir);

        return new ContentVO(
                FileVO.fromFile(baseDir),
                FileVO.fromFile(parentDir),
                breadCrumb.stream().map(FileVO::fromFile).collect(Collectors.toList()),
                files.stream().map(FileVO::fromFile).collect(Collectors.toList())
        );
    }

}
