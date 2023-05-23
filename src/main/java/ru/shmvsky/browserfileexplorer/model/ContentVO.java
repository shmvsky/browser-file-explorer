package ru.shmvsky.browserfileexplorer.model;

import java.util.List;

public class ContentVO {

    private final FileVO baseDirectory;
    private final FileVO parentDirectory;
    private final List<FileVO> breadCrumb;
    private final List<FileVO> files;

    public ContentVO(FileVO baseDirectory, FileVO parentDirectory, List<FileVO> breadCrumb,
                     List<FileVO> files) {
        this.baseDirectory = baseDirectory;
        this.parentDirectory = parentDirectory;
        this.breadCrumb = breadCrumb;
        this.files = files;
    }

    public FileVO getBaseDirectory() {
        return baseDirectory;
    }

    public FileVO getParentDirectory() {
        return parentDirectory;
    }

    public List<FileVO> getBreadCrumb() {
        return breadCrumb;
    }

    public List<FileVO> getFiles() {
        return files;
    }

}
