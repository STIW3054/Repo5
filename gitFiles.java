package com.uum.haha.gitfiles;

import static com.uum.haha.gitfiles.gitFiles.str;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class gitFiles implements Runnable {

    static LinkedList<String> al = new LinkedList<String>();
    static String f[] = new String[9];
    static Iterator<String> itr;
    static String st;
    static String str;
    static File file;

    static BufferedReader in;

    static String workingDirectory;
    static String absoluteFilePath;
    static String name1;

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            file = new File(selectedFile.getAbsolutePath());
        }
        workingDirectory = System.getProperty("user.dir");
        System.out.println(workingDirectory);
        absoluteFilePath = workingDirectory + File.separator;
        System.out.println(absoluteFilePath);

        in = new BufferedReader(new FileReader(file));
        while ((str = in.readLine()) != null) {
            if ((str).contains("github")) {
                al.add(str);
                name1 = str.substring(19);
                downloadFile(name1);
            }
            System.out.println("");
        }
    }

    public static void downloadFile(String name) {
        gitFiles gkl = new gitFiles() {
            @Override
            public void run() {
                try {
                    String name2 = str + ".git";
                    int slash = name2.lastIndexOf('/');
                    String substring = name2.substring(slash + 1, slash + 7);
                    System.out.println(substring);
                    File dir = new File(absoluteFilePath + "realtime" + File.separator + substring);
                    System.out.println("GitHub Link " + name2);
                    System.out.println("directory " + dir.toString());
                    boolean successful = dir.mkdir();
                    if (successful) {
                        System.out.println(name + " directory was created successfully");
                        Git git = Git.cloneRepository().setURI(name2)
                                .setDirectory(dir)
                                .call();

                    } else {
                        System.out.println(name + " failed trying to create the directory");
                    }

                } catch (GitAPIException ex) {
                    Logger.getLogger(gitFiles.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        gkl.run();
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

