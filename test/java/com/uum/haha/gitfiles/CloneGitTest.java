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
public class CloneGitTest {
    
    public CloneGitTest() {
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
     * Test of downloadFile method, of class CloneGit.
     */
    @Test
    public void testDownloadFile() {
        String workingDirectory = System.getProperty("user.dir");
        System.out.println("downloadFile");
        String url = "https://github.com/DonLeeHoi/237768";
        String name = url.substring(19);
        String absoluteFilePath = workingDirectory + File.separator; 
        File dir = new File(absoluteFilePath + "STIW3054-A171" + File.separator + "237768");
        CloneGit.downloadFile(name, url, dir, absoluteFilePath);
    }

    /**
     * Test of run method, of class CloneGit.
     */
    @Test
    public void testRun() {
       
    }
    
}
