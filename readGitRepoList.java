package readFile;

import repo5.CloneGit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class readGitRepoList {
    createFolder c = new createFolder();
    LinkedList<String> al = new LinkedList<String>();
    String create;
    String str;
    File file;
    BufferedReader in;

    String workingDirectory;
    String absoluteFilePath;
    String name1;
    public void readLines() throws IOException {
        
         JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            file = new File(selectedFile.getAbsolutePath());
        }
        workingDirectory = System.getProperty("user.dir");
        absoluteFilePath = workingDirectory + File.separator;
        
        in = new BufferedReader(new FileReader(file));
        while ((str = in.readLine()) != null) {
            if ((str).contains("github")) {
                al.add(str);
                name1 = str.substring(19);
                File directory = c.create(str, absoluteFilePath);
                CloneGit clone = new CloneGit();
                clone.downloadFile(name1,str,directory,absoluteFilePath);
           }
            System.out.println("");
        }
        
    }   
}
