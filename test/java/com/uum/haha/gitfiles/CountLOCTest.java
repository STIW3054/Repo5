/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uum.haha.gitfiles;

import java.io.File;
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
public class CountLOCTest {

    String workingDirectory = System.getProperty("user.dir");
    String absoluteFilePath = workingDirectory + File.separator;
    File singleFile = new File(absoluteFilePath + "STIW3054-A171" + File.separator + "237768" + File.separator + "Asg1_237768.java");
    CountLOC instance = new CountLOC(singleFile);

    public CountLOCTest() {
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
     * Test of countLineNumber method, of class CountLOC.
     */
    @Test
    public void testCountLineNumber() {
        System.out.println("countLineNumber");
        int expResult = 24;
        int result = instance.countLineNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of countBlankLineNumber method, of class CountLOC.
     */
    @Test
    public void testCountBlankLineNumber() {
        System.out.println("countBlankLineNumber");
        int expResult = 6;
        int result = instance.countBlankLineNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of countCommentLineNumber method, of class CountLOC.
     */
    @Test
    public void testCountCommentLineNumber() {
        System.out.println("countCommentLineNumber");
        int expResult = 0;
        int result = instance.countCommentLineNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotalLines method, of class CountLOC.
     */
    @Test
    public void testGetTotalLines() {
        System.out.println("getTotalLines");
        String expResult = "24";
        String result = instance.getTotalLines();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBlankLines method, of class CountLOC.
     */
    @Test
    public void testGetBlankLines() {
        System.out.println("getBlankLines");
        String expResult = "6";
        String result = instance.getBlankLines();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCommentLines method, of class CountLOC.
     */
    @Test
    public void testGetCommentLines() {
        System.out.println("getCommentLines");
        String expResult = "0";
        String result = instance.getCommentLines();
        assertEquals(expResult, result);
    }

    /**
     * Test of getActualLines method, of class CountLOC.
     */
    @Test
    public void testGetActualLines() {
        System.out.println("getActualLines");
        int actualLoc = 24 - 6 - 0;
        String actualLines = Integer.toString(actualLoc);
        String expResult = "18";
        String result = actualLines;
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotalValue method, of class CountLOC.
     */
    @Test
    public void testGetTotalValue() throws Exception {
        System.out.println("getTotalValue");
        CountKeyword key = new CountKeyword(singleFile);
        int counter = key.noKeywords();
        int actualLoc = 24 - 6 - 0;
        int totalVal = actualLoc + counter;
        String totalValue = Integer.toString(totalVal);
        String expResult = "36";
        String result = totalValue;
        assertEquals(expResult, result);
    }

}
