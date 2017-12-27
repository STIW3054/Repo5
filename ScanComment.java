package com.uum.haha.gitfiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ScanComment extends Repo5{
    static String sem, course, grp, task, name, matric; 
    
    public ScanComment (File FILE) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE));
        String line;
            while ((line = br.readLine()) != null){
                if (line.contains("//Semester:")){
                    sem = line;
                    sem = sem.replace("//Semester: #", "");
                }else if (line.contains("//Course:")){
                    course = line;
                    course = course.replace("//Course: #", "");
                }else if (line.contains("//Group:")){
                    grp = line;
                    grp = grp.replace("//Group: #", "");
                }else if (line.contains("//Task:")){
                    task = line;
                    task = task.replace("//Task: #", "");
                }else if (line.contains("//Name:")){
                    name = line;
                    name = name.replace("//Name: #", "");
                }else if (line.contains("//Matrik:")){
                    matric = line;
                    matric = matric.replace("//Matrik: #", "");
                }
            } 
    }
    
    public String getSem(){
        return sem;
    }
    
    public String getCourse(){
        return course;
    }
    
    public String getGroup(){
        return grp;
    }
    
    public String getTask(){
        return task;
    }
    
    public String getName(){
        return name;
    }
    
    public String getMatric(){
        return matric;
    }
}


