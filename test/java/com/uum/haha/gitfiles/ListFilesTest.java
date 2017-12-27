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
public class ListFilesTest {
    
    public ListFilesTest() {
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
     * Test of listFiles method, of class ListFiles.
     */
    @Test
    public void testListFiles() {
        System.out.println("listFiles");
        String filename = "STIW3054-A171";
        String PATH = System.getProperty("user.dir") + File.separator + filename;
        ListFiles instance = new ListFiles();
        ListFiles expResult = instance;
        ListFiles result = instance.listFiles(PATH);
        assertEquals(expResult, result);
    }

    /**
     * Test of getList method, of class ListFiles.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        ListFiles instance = new ListFiles();
        String[] expResult = instance.getList();
        String[] result = instance.getList();
        assertArrayEquals(expResult, result);
    }
    
}
