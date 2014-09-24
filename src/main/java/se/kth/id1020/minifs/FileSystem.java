/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id1020.minifs;

/**
 *
 */
public interface FileSystem {

  public String mkdir(String path);
  
  public String touch(String path);
  
  public String append(String path, String data);
  
  public String lsByTime(String path);
  
  public String lsByName(String path);
  
  public String du(String path);
  
  public String cat(String path);
}
