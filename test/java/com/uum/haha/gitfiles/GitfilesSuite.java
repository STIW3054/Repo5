/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uum.haha.gitfiles;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author User
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.uum.haha.gitfiles.createFolderTest.class, com.uum.haha.gitfiles.CompileProgramTest.class, com.uum.haha.gitfiles.readGitRepoListTest.class, com.uum.haha.gitfiles.logFilesTest.class, com.uum.haha.gitfiles.Repo5Test.class, com.uum.haha.gitfiles.convertToPDFTest.class, com.uum.haha.gitfiles.CloneGitTest.class})
public class GitfilesSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
