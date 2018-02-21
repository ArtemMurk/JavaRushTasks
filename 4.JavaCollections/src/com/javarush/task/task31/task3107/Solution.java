package com.javarush.task.task31.task3107;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
    Path file;
    try {
        file = Paths.get(pathToFile);
        boolean hidden = Files.isHidden(file);
        boolean executable = Files.isExecutable(file);
        boolean directory = Files.isDirectory(file);
        boolean writable = Files.isWritable(file);
        fileData = new ConcreteFileData(hidden,executable,directory,writable);
        }
        catch (Exception e){
        fileData = new NullFileData(e);
        }

    }

    public FileData getFileData() {
        return fileData;
    }
}
