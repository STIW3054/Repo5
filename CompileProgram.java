package com.uum.haha.gitfiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class CompileProgram {

    static int k;
    static String fileName;
    static LinkedList<String> ls = new LinkedList<String>();

    public CompileProgram() {

    }
    public static void directory(File dir) throws IOException, Exception {
        
        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.listFiles() != null) {
                directory(file);
                
            }
        }

        for (int i = 0; i < files.length; i++) {
            fileName = files[i].toString();
            if (fileName.endsWith(".java")) {
                runProcess("javac " + fileName);
            
                System.out.println("");
            }
        }
    }

    private static void printLines(String name, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(ins));
        FileWriter writer = null;

        while ((line = in.readLine()) != null) {

            System.out.println(name + " " + line);
            ls.add(name + " " + line);
        }
        String listString = "";
        for (String s : ls) {
            listString = listString + s + System.lineSeparator();
        }
        String workingDirectory = System.getProperty("user.dir");
        String absoluteFilePath = workingDirectory + File.separator;
        File outputFile = new File(absoluteFilePath + "STIW3054-Result" + File.separator + "Error");
        try {
            outputFile.mkdir();
            writer = new FileWriter(outputFile + File.separator + "Error.txt");
            writer.write(listString);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command + " stdout:\n", pro.getInputStream());
        printLines(command + " stderr:\n", pro.getErrorStream());
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
        return pro.exitValue();
    }
   
}
