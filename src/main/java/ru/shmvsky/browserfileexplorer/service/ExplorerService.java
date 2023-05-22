package ru.shmvsky.browserfileexplorer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shmvsky.browserfileexplorer.configuration.ExplorerConfiguration;
import ru.shmvsky.browserfileexplorer.exception.ExplorerRuntimeException;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
public class ExplorerService {

    @Autowired
    private ExplorerConfiguration explorerConfiguration;

    private String processPathToDir(String pathStr) {

        try {
            Paths.get(pathStr);
        } catch (InvalidPathException ex) {
            throw new ExplorerRuntimeException(ex.getCause());
        }

        String linuxLikePathStr = pathStr.replaceAll("(\\w:/)", "/");

        boolean isAbsolute = linuxLikePathStr.startsWith(explorerConfiguration.getBaseDirPath());

        return isAbsolute ? linuxLikePathStr : explorerConfiguration.getBaseDirPath() + linuxLikePathStr;
    }

    public List<File> buildContent(String pathToDir) throws ExplorerRuntimeException {

        File f = new File(processPathToDir(pathToDir));

        return Arrays.asList(f.listFiles());



//        File baseDir = new File(explorerConfiguration.getBaseDirPath());
//        String[] fileNameStrings = pathToDir.split("/");
//        File[] pathFiles = new File[fileNameStrings.length];
//        for (int i = 0; i < fileNameStrings.length; i++) {
//            pathFiles[i] = new File(pathFiles);
//        }

//        if (pathToDirObj.isAbsolute()) {
//            childFiles = pathToDirObj.toFile().listFiles();
//        } else {
////            Path pathToDirRel = pathToDirObj.resolve(explorerConfiguration.getBaseDirPath());
//            Path pathToDirRel = Paths.get(explorerConfiguration.getBaseDirPath()).resolve(pathToDirObj);
//            System.out.println(pathToDirObj + " " + pathToDirRel);
//            childFiles = pathToDirRel.toFile().listFiles();
//        }

//        return Arrays.asList(childFiles != null ? childFiles : new File[0]);
    }

}
