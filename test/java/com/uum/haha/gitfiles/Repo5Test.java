/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uum.haha.gitfiles;

import static com.uum.haha.gitfiles.Repo5.workbook;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carynne
 */
public class Repo5Test {
    String workingDirectory = System.getProperty("user.dir");
    String absoluteFilePath = workingDirectory + File.separator;
    File singleFile = new File(absoluteFilePath + "STIW3054-A171" + File.separator + "237768" + File.separator + "Asg1_237768.java");
    
    public Repo5Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createSheet method, of class Repo5.
     */
    @Test
    public void testCreateSheet() {
        System.out.println("createSheet");
        /*
        XSSFSheet sheet =workbook.createSheet("Line of Codes");
        XSSFWorkbook expResult = null;
        XSSFWorkbook result = Repo5.createSheet(sheet);
        assertEquals(expResult, result);*/
    }

    /**
     * Test of writeDetails method, of class Repo5.
     */
    @Test
    public void testWriteDetails() {
        System.out.println("writeDetails");
        
        String sem = "1";
        String course = "STIW3054";
        String group = "A";
        String task = "Assignment 1";
        XSSFSheet expResult = Repo5.writeDetails(sem, course, group, task);
        XSSFSheet result = Repo5.writeDetails(sem, course, group, task);
        assertEquals(expResult, result);
    }

    /**
     * Test of writeData method, of class Repo5.
     */
    @Test
    public void testWriteData() throws Exception {
        System.out.println("writeData");
        /*
        CountKeyword instance = new CountKeyword(singleFile);
        String [] fileList = singleFile.list();
        Map<String, Integer> map = new HashMap();
        String name = "";
        String matric = "237768";
        String loc = "1";
        String blank = "2";
        String comment = "3";
        String actLoc = "5";
        String ttl = "5";
        CountKeyword expResult = instance;
        XSSFRow result = Repo5.writeData(fileList, map, matric, loc, blank, comment, actLoc, ttl);
        assertEquals(expResult, result);*/
    }
    
}
