package com.uum.haha.gitfiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class CountLOC extends Repo5{

    File singleFile;
    int lines, blank, comment, actualLoc;
    String totalLines, blankLines, commentLines, actualLines, totalValue;
    
    public CountLOC(File singleFile) {
        this.singleFile = singleFile;
    }   
    
    public int countLineNumber() {
        lines = 0;
        
        try(LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(singleFile))) {
            lineNumberReader.skip(Long.MAX_VALUE);
            lines = lineNumberReader.getLineNumber()+1;
        }catch(FileNotFoundException e){
            System.out.println("FileNotFoundException Occurred" + e.getMessage());
        }catch(IOException e){
            System.out.println("IOException Occurred" + e.getMessage());
        }
        return lines;
    }

    public int countBlankLineNumber() {
        String line;
        blank = 0;

        try{
            BufferedReader br;
            br = new BufferedReader(new FileReader(singleFile));
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                  blank++;
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("FileNotFoundException Occurred" + e.getMessage());
        }catch(IOException e){
            System.out.println("IOException Occurred" + e.getMessage());
        }
        return blank;
    }

    public int countCommentLineNumber() {
        String line;
        comment = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(singleFile))) {
            while ((line = br.readLine()) != null) {
                if (line.startsWith("//")) 
                  comment++;
                if (line.startsWith("/*")) {
                    comment++;
                    while (!(line = br.readLine()).endsWith("'*\'")) {
                        comment++; break;
                    }
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("FileNotFoundException Occurred" + e.getMessage());
        }catch(IOException e){
            System.out.println("IOException Occurred" + e.getMessage());
        }
        return comment;
    }
    
    public String getTotalLines(){
        lines = countLineNumber();
        totalLines = Integer.toString(lines);        
        return totalLines;
    }
    
    public String getBlankLines(){
        blank = countBlankLineNumber();
        blankLines = Integer.toString(blank);        
        return blankLines;
    }
    
    public String getCommentLines(){
        comment = countCommentLineNumber();
        commentLines = Integer.toString(comment);      
        return commentLines;
    }
    
    public String getActualLines(){
        actualLoc = lines - blank - comment;
        actualLines = Integer.toString(actualLoc);    
        return actualLines;
    }   
    
    public String getTotalValue() throws FileNotFoundException{
        CountKeyword key = new CountKeyword(singleFile);
        int counter = key.noKeywords();        
        int totalVal = actualLoc + counter;
        totalValue = Integer.toString(totalVal);        
        return totalValue;
    }
}

