package com.uum.haha.gitfiles;

import java.io.File;
import java.util.LinkedList;

public class ListFiles extends Repo5{
    private LinkedList<String> list = new LinkedList();
    
    public ListFiles listFiles(String PATH) {
        File folder = new File(PATH);
        File[] files = folder.listFiles();
            
        for (File file : files) {
            if (file.isFile() && (file.getName().endsWith(".java"))) { 
                list.add(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                listFiles(file.getAbsolutePath());
            }
        } 
        return this;
    }

    public String[] getList() {
        String arrayOfFileName[] = new String[list.size()];
        for (int i=0; i<list.size(); i++) {
            arrayOfFileName[i] = list.get(i);
        }
        return arrayOfFileName;
    }
    
}

