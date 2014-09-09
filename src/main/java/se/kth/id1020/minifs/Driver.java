/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id1020.minifs;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import java.io.File;
import java.io.Writer;

/**
 *
 */
public class Driver {

  static String NEW_LINE = System.getProperty("line.separator");

  public static void main(String[] args) {
    FileSystem fs = new MiniFs();
    String fileResult = processCmdFile(fs, args[0]);
    StdOut.println(fileResult);
  }

  public static String processCmdFile(FileSystem fs, String path) {
    In input = new In(new File(path));
    StringBuilder builder = new StringBuilder();

    while (!input.isEmpty()) {
      String line = input.readLine().trim();
      builder.append(">> " + line).append(NEW_LINE);
      String result = processCmd(fs, line);
      if (result != null) {
        builder.append(result).append(NEW_LINE);
      }
    }
    return builder.toString();
  }

  public static String processCmd(FileSystem fs, String line) {
    String[] comp = line.split(" ", 2);
    String cmd = comp[0].trim().toLowerCase();
    
    String result = null;

    if (cmd.equals("mkdir")) {
      fs.mkdir(comp[1].trim());
    } else if (cmd.equals("touch")) {
      fs.touch(comp[1].trim());
    } else if (cmd.equals("append")) {
      String[] subComp = comp[1].split(" ", 2);
      fs.append(subComp[0].trim(), subComp[1].trim());
    } else if (cmd.equals("ls")) {
      String[] subComp = comp[1].split(" ", 2);
      String param = subComp[0].trim().toLowerCase();
      String path = subComp[1].trim();
      if (param.equals("-t")) {
        result = fs.lsByTime(path);
      } else if (param.equals("-s")) {
        result = fs.lsByName(path);
      } else {
        result = param + ": parameter not recognized for ls";
      }
    } else if (cmd.equals("du")) {
      result = fs.du(comp[1].trim());
    } else if (cmd.equals("cat")) {
      result = fs.cat(comp[1].trim());
    } else {
      result = cmd + ": command not found";
    }

    return result;
  }

}
