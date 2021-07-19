package com.jmletona.ga610.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FileSearch {

    public static List<String> getGallery(String path){
        List<File> files = new ArrayList<>();
        List<String> fileNames = new ArrayList<>();
        File f = new File(path);
        if (f.isDirectory()) {
                //fileNames = new ArrayList<>(Arrays.asList(Objects.requireNonNull(f.list()))); //Just the file names
                files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(f.listFiles())));
        }

        for (File file : files){
            fileNames.add(file.getPath());
        }

        return fileNames;
    }

}
