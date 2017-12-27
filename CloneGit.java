package com.uum.haha.gitfiles;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class CloneGit implements Runnable {
   
    public static void downloadFile(final String name, final String url,final File dir,final String absoluteFilePath) {
        long startTime = System.currentTimeMillis();
        CloneGit file = new CloneGit() {
            @Override
            public void run() {
                try {
                    if (name!=null) {
                        System.out.println(name.toUpperCase() + " directory was created successfully");
                        Git git = Git.cloneRepository().setURI(url)
                                .setDirectory(dir)
                                .call();                        
                    }else{
                        System.out.println(name.toUpperCase() + " failed trying to create the directory");                        
                    }
                }catch(GitAPIException ex) {
                    Logger.getLogger(CloneGit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        file.run();
        long endTime = startTime + 60*1000; //1 minute = 60000 milliseconds
        long actualEnd = System.currentTimeMillis();
        if (actualEnd < endTime){
            logFiles.createLog(absoluteFilePath, startTime, actualEnd);
        }
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
