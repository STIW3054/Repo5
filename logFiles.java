package com.uum.haha.gitfiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class logFiles {
    
    static String directory, subdirectory, folderpath, fileName;
    
    public static String createLog(String folderpath, long startTime, long endTime){
        directory = folderpath + File.separator + "/STIW3054-Result";  //create directory      
        File file = new File(directory);
        file.mkdir(); 
        
        subdirectory = directory + File.separator + "/Log Files";  //create log files
        File subfile = new File(subdirectory);
        subfile.mkdir(); 
     
        int i=1;
        fileName =  "Log " + i + ".log";
        i++;
        File log = new File(subdirectory,fileName);
        try{
            log.createNewFile();
        } catch (IOException e) {
            e.getStackTrace();
        }
        long timeTaken = endTime - startTime;
        double timeTakenInSecond = timeTaken/1000.0;        
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");    
        Date resultdate = new Date(endTime);
        FileWriter fr = null;
        try {
            fr = new FileWriter(log);
            fr.write("Termination time = " + sdf.format(resultdate) + System.getProperty("line.separator"));
            fr.write("Total download duration = " + Math.floor(timeTakenInSecond*1000.0)/1000.0 + " seconds," 
                    + Math.floor((timeTakenInSecond/60.0)*1000.0)/1000.0 + " minutes");
        }catch (IOException e) {
            e.getStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fr.toString();
    }
    
}
