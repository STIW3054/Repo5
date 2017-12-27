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
public class createFolderTest {
    
    public createFolderTest() {
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
     * Test of create method, of class createFolder.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        String workingDirectory = System.getProperty("user.dir");
        String absoluteFilePath = workingDirectory + File.separator; 
        String str = "https://github.com/DonLeeHoi/237768";
        createFolder instance = new createFolder();
        File expResult = null;
        File result = instance.create(str, absoluteFilePath);
        assertEquals(expResult, result);
       
    }
    
}
