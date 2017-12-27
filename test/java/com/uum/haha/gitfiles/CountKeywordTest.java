/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uum.haha.gitfiles;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
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
public class CountKeywordTest {

    public CountKeywordTest() {
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
     * Test of countKeywords method, of class CountKeyword.
     */
    @Test
    public void testCountKeywords() throws Exception {
        System.out.println("countKeywords");
        String workingDirectory = System.getProperty("user.dir");
        String absoluteFilePath = workingDirectory + File.separator;
        File singleFile = new File(absoluteFilePath + "STIW3054-A171" + File.separator + "237768" + File.separator + "Asg1_237768.java");
        CountKeyword instance = new CountKeyword(singleFile);
        Map<String, Integer> expResult = new HashMap<>();
        expResult.put("class", 1);
        expResult.put("final", 1);
        expResult.put("import", 3);
        expResult.put("int", 2);
        expResult.put("new", 2);
        expResult.put("package", 1);
        expResult.put("public", 2);
        expResult.put("static", 4);
        expResult.put("throws", 1);
        expResult.put("void", 1);
        Map<String, Integer> result = instance.countKeywords();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of noKeywords method, of class CountKeyword.
     */
    @Test
    public void testNoKeywords() throws Exception {
        System.out.println("noKeywords");
        String workingDirectory = System.getProperty("user.dir");
        String absoluteFilePath = workingDirectory + File.separator;
        File singleFile = new File(absoluteFilePath + "STIW3054-A171" + File.separator + "237768" + File.separator + "Asg1_237768.java");
        CountKeyword instance = new CountKeyword(singleFile);
        int expResult = 18;
        int result = instance.noKeywords();
        assertEquals(expResult, result);

    }

}
