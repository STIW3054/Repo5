/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uum.haha.gitfiles;

import java.io.File;
import java.io.IOException;
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
public class ScanCommentTest {

    String workingDirectory = System.getProperty("user.dir");
    String absoluteFilePath = workingDirectory + File.separator;
    File singleFile = new File(absoluteFilePath + "STIW3054-A171" + File.separator + "237768"+ File.separator + "Asg1_237768.java");
    
    ScanComment instance;

    public ScanCommentTest() throws IOException {
        this.instance = new ScanComment(singleFile);
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
     * Test of getSem method, of class ScanComment.
     */
    @Test
    public void testGetSem() {
        System.out.println("getSem");
        String expResult = null;
        String result = instance.getSem();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCourse method, of class ScanComment.
     */
    @Test
    public void testGetCourse() {
        System.out.println("getCourse");
        String expResult = null;
        String result = instance.getCourse();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGroup method, of class ScanComment.
     */
    @Test
    public void testGetGroup() {
        System.out.println("getGroup");
        String expResult = null;
        String result = instance.getGroup();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTask method, of class ScanComment.
     */
    @Test
    public void testGetTask() {
        System.out.println("getTask");
        String expResult = null;
        String result = instance.getTask();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class ScanComment.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMatric method, of class ScanComment.
     */
    @Test
    public void testGetMatric() {
        System.out.println("getMatric");
        String expResult = null;
        String result = instance.getMatric();
        assertEquals(expResult, result);
    }

}
