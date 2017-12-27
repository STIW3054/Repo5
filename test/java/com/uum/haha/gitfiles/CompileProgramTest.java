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
public class CompileProgramTest {
    
    public CompileProgramTest() {
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
     * Test of directory method, of class CompileProgram.
     */
    @Test
    public void testDirectory() throws Exception {
        System.out.println("Test Directory");
        
        String workingDirectory = System.getProperty("user.dir");
        String absoluteFilePath = workingDirectory + File.separator; 
        File path = new File(absoluteFilePath + "STIW3054-A171");
        System.out.println("directory");
        File dir = null;
        CompileProgram.directory(dir);
       
    }
    
}
