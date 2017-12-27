/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uum.haha.gitfiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class convertToPDF {

    String create;
    String str;
    File file;
    BufferedReader in;

    String workingDirectory;
    String absoluteFilePath;
    String name1;
    static String fileName, textFile, textFile1;
    int j = 1;
    FileWriter writer = null;

    public void convert(File dir) throws FileNotFoundException, IOException, COSVisitorException {
        workingDirectory = System.getProperty("user.dir");
        absoluteFilePath = workingDirectory + File.separator;
        File outputFile = new File(absoluteFilePath + "STIW3054-Result" + File.separator + "Summary");
        outputFile.mkdir();
        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.listFiles() != null) {
                convert(file);
            }
        }

        for (File file1 : files) {
            fileName = file1.toString();
            if (fileName.endsWith(".txt")) {
                in = new BufferedReader(new FileReader(fileName));
               
                j = 1;
                int y = 750;
                textFile = "Error " + j + ".pdf";
                 
                j++;
                PDDocument document = new PDDocument();
                PDPage page = new PDPage();
                document.addPage(page);
                PDPageContentStream contentStream = new PDPageContentStream(document, page);

                while ((str = in.readLine()) != null) {
                    
                    contentStream.beginText();
                    contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                    //contentStream.moveTextPositionByAmount(20, y -= 30);
                    contentStream.moveTextPositionByAmount(10, y -= 30);
                    String text = str;
                    contentStream.drawString(text);
                    contentStream.endText();
                }

                //System.out.println("Content added");
                contentStream.close();
               
                document.save(textFile);
                document.close();

                System.out.println("");
                writer = new FileWriter(outputFile + File.separator + textFile);
            }
            
            if (fileName.endsWith(".log")) {
                in = new BufferedReader(new FileReader(fileName));
               
                j = 1;
                int y = 750;
                textFile1 = "Log " + j + ".pdf";
                 
                j++;
                PDDocument document = new PDDocument();
                PDPage page = new PDPage();
                document.addPage(page);
                PDPageContentStream contentStream = new PDPageContentStream(document, page);

                while ((str = in.readLine()) != null) {
                    
                    contentStream.beginText();
                    contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                    //contentStream.moveTextPositionByAmount(20, y -= 30);
                    contentStream.moveTextPositionByAmount(10, y -= 30);
                    String text = str;
                    contentStream.drawString(text);
                    contentStream.endText();
                }

                //System.out.println("Content added");
                contentStream.close();
               
                document.save(textFile1);
                document.close();

                System.out.println("");
                writer = new FileWriter(outputFile + File.separator + textFile1);
            }
        }
       

    }
}
