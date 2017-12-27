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
 * @author User
 */
public class logFilesTest {
    
    public logFilesTest() {
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
     * Test of createLog method, of class logFiles.
     */
    @Test
    public void testCreateLog() {
        System.out.println("createLog");
        String workingDirectory = System.getProperty("user.dir");
        String absoluteFilePath = workingDirectory + File.separator; 
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        String expResult = "";
        String result = logFiles.createLog(absoluteFilePath, startTime, endTime);
        assertEquals(expResult, result);
        
    }
    
}
