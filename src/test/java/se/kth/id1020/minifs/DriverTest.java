/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.id1020.minifs;

import edu.princeton.cs.introcs.In;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 *
 */
public class DriverTest extends TestCase {
  
  class TestFs implements FileSystem {

    public String mkdir(String path) {
        return "";
    }

    public String touch(String path) {
        return "";
    }

    public String append(String path, String data) {
        return "";
    }

    public String lsByTime(String path) {
      return "";
    }

    public String lsByName(String path) {
      return "";
    }

    public String du(String path) {
      return "";
    }

    public String cat(String path) {
      return "";
    }

  }
  
  public void testMain() {
    FileSystem fs = new TestFs();
    String results = Driver.processCmdFile(fs, getClass().getResource("/cmds.txt").getPath());
    In expectedResults = new In(getClass().getResource("/results.txt"));
    assertEquals(results, expectedResults.readAll());
  }
    
  public void testProcessCmd() {
    FileSystem fs = new TestFs();
    assertEquals(Driver.processCmd(fs, "mkdir /home/jim"), null);
  }
}
