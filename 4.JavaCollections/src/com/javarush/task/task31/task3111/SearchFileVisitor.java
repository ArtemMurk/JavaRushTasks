package com.javarush.task.task31.task3111;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int maxSize = -1;
    private int minSize = -1;

    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        int criterion;
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        if (maxSize > -1 && !(Files.size(file)<maxSize) ) { return super.visitFile(file, attrs);}
        if (minSize > -1 && !(Files.size(file)>minSize) ) { return super.visitFile(file, attrs);}
//        if (partOfContent!=null && !(Files.lines(file).anyMatch(s -> s.matches((".*" + partOfContent + ".*"))))){ return super.visitFile(file, attrs);}
        if (partOfContent!=null) if (!(new String(content).contains(partOfContent))){ return super.visitFile(file, attrs);}

        if (partOfName!=null)if (!file.getFileName().toString().contains(partOfName)){return super.visitFile(file, attrs);}

        foundFiles.add(file);
        return super.visitFile(file, attrs);
    }

    public void setPartOfName (String partOfName){
        this.partOfName = partOfName;
    }

    public String getPartOfName() {
        return partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public List<Path> getFoundFiles(){
        return foundFiles;
    }
}
