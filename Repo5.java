package com.uum.haha.gitfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Repo5 {
    
    static readGitRepoList read = new readGitRepoList();
    public static final String filename = "STIW3054-A171";
    public static final String FILE_NAME = "JavaKeywords.xlsx";
    public static final XSSFWorkbook workbook = new XSSFWorkbook();
    public static final XSSFSheet sheet = workbook.createSheet("Line of Codes");
    

    public static void main(String[] args) throws IOException, Exception{
        read.readLines();

        String dir = System.getProperty("user.dir"); 
        String absolutePath = dir + File.separator + filename;
        ListFiles FILE = new ListFiles();
        String[] fileList = FILE.listFiles(absolutePath).getList();
        
        String absoluteFilePath;
        absoluteFilePath = dir + File.separator;        

        for (String fileList1 : fileList) {
            File singleFile = new File(fileList1);

            //get details
            ScanComment scan = new ScanComment(singleFile);
            String sem = scan.getSem();
            String course = scan.getCourse();
            String grp = scan.getGroup();
            String task = scan.getTask();
            String matric = singleFile.getName();
            
            //get lines of code
            CountLOC count = new CountLOC(singleFile);
            String totalLines = count.getTotalLines();
            String blankLines = count.getBlankLines();
            String commentLines = count.getCommentLines();
            String actualLines = count.getActualLines();
            String totalValue = count.getTotalValue();

            //get keywords
            CountKeyword keyword = new CountKeyword(singleFile);
            Map<String,Integer> map = keyword.countKeywords();

            //display output in Excel            
            sheet.setDefaultColumnWidth(10);
            createSheet(sheet);
            writeDetails(sem, course, grp, task);
            writeData(fileList, map, matric, totalLines, blankLines, commentLines, actualLines, totalValue);

            try{
                FileOutputStream outputStream = new FileOutputStream(absoluteFilePath + "STIW3054-Result" 
                        + File.separator + "Summary" + File.separator + FILE_NAME);
                workbook.write(outputStream);
                outputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static XSSFWorkbook createSheet(XSSFSheet sheet){   
        XSSFRow Semester = sheet.createRow(0);
        Semester.createCell(0).setCellValue("Semester");

        XSSFRow Course = sheet.createRow(1);
        Course.createCell(0).setCellValue("Course");

        XSSFRow Group = sheet.createRow(2);
        Group.createCell(0).setCellValue("Group");

        XSSFRow Task = sheet.createRow(3);
        Task.createCell(0).setCellValue("Task");

        XSSFRow Keyword = sheet.createRow(5);
        Keyword.createCell(5).setCellValue("java keyword");

        XSSFRow Table = sheet.createRow(6);
        Table.createCell(0).setCellValue("Filename");
        Table.createCell(1).setCellValue("LOC");
        Table.createCell(2).setCellValue("Blank");
        Table.createCell(3).setCellValue("Comment");
        Table.createCell(4).setCellValue("ActualLOC");   

        return workbook;
    }

    public static XSSFSheet writeDetails(String sem, String course, String group, String task){
        XSSFRow Semester = sheet.getRow(0);
        XSSFRow Course = sheet.getRow(1);
        XSSFRow Group = sheet.getRow(2);
        XSSFRow Task = sheet.getRow(3);

        Semester.createCell(1).setCellValue(sem);
        Course.createCell(1).setCellValue(course);
        Group.createCell(1).setCellValue(group);
        Task.createCell(1).setCellValue(task);

        return sheet;
    } 

    public static XSSFRow writeData(String[] fileList, Map<String, Integer> map, String matric, 
            String loc, String blank, String comment, String actLoc, String ttl) throws IOException {

        String key[] = new String [map.size()];

        int a = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            key[a] = entry.getKey();
            a++;
        } 

        int rowCount = sheet.getLastRowNum();
        Row row = sheet.createRow(++rowCount);
        write(row, matric, loc, blank, comment, actLoc, ttl, map);        

        XSSFRow Table = sheet.getRow(6);    

        for (int x=5; x<map.size()+5; x++) {
            Table.createCell(x).setCellValue(key[(x-5)]);
        }
        Table.createCell(22).setCellValue("Total"); 

        return Table;        
    }

    private static void write(Row row, 
            String matric, String loc, String blank, String comment, 
            String actLoc, String ttl, Map<String, Integer> map) {


        String value[] = new String [map.size()];

        int a = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            value[a] = Integer.toString(entry.getValue());
            a++;
        }

        Cell cell = row.createCell(0);
        cell.setCellValue(matric);

        cell = row.createCell(1);
        cell.setCellValue(loc);

        cell = row.createCell(2);
        cell.setCellValue(blank);

        cell = row.createCell(3);
        cell.setCellValue(comment);

        cell = row.createCell(4);
        cell.setCellValue(actLoc);

        for (int x=5; x<map.size()+5; x++) {
            cell = row.createCell(x);
            cell.setCellValue(value[(x-5)]);
        }

        cell = row.createCell(22);
        cell.setCellValue(ttl);

    }

}

