/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.id1020.minifs;

/**
 *
 */
public class INodeFile extends INode {
  
  public LinkedList<Block> blocks = new LinkedList<Block>();

  public INodeFile(String name) {
    super(name);
  }
  
}
