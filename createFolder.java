package com.uum.haha.gitfiles;

import java.io.File;

public class createFolder {

    static boolean successful = false;

    public File create(String str, String absoluteFilePath) {
        String url = str;
        int slash = url.lastIndexOf('/');
        String substring = url.substring(slash + 1, slash + 7);
        File create = new File(absoluteFilePath + "STIW3054-A171");
        create.mkdir();
        File dir = new File(absoluteFilePath + "STIW3054-A171" + File.separator + substring);
        System.out.println("GitHub Link : " + url);
        System.out.println("Directory : " + dir.toString());
         File outputFile = new File(absoluteFilePath + "STIW3054-Result" + File.separator + "Output");
         outputFile.mkdir();
       
        if (dir.mkdir()) {
            successful = true;
            return dir;
        } else {
            successful = false;
            return null;
        }
    }

}
