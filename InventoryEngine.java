package drivers;

import java.util.*;
import java.io.*;
import inventory.*;

/**
 * This class is used to test the InventoryLog class by calling its methods and printing expected output
 */
public class InventoryEngine {

   public static void main(String[] args) {
      
      Inventory log = new InventoryLog();
      testInventory(log);

   /**
    * This method tests the various methods in the InventoryLog class
    * @param log object used to keep track of various characters
    */
   public static void testInventory(Inventory log) {
    
      log.add('a');
      log.add('z');
      log.add('c');
      log.add('c');
      log.add('c');
      log.add('a');
      System.out.println(log);
      log.size();
      System.out.println("Expected size: 6 " + log.size());

      log.subtract('c');
      System.out.println(log);
     
      System.out.println("Expected Count of a's: 2   " + log.get('a'));

      System.out.println("Expected Contains a: true " + log.contains('a'));
      System.out.println("Expected Contains e: false " + log.contains('e'));

      log.set('a', 5);
      System.out.println("As = " + log.get('a'));

      try {
         log.set('f',2);
      } catch (IllegalArgumentException e) {
         System.out.println("Illegal Argument");
      }
      System.out.println("Expected isEmpty(): false " + log.isEmpty());
   }
}

/*
[a, z, c, c, c, a]
Expected size: 6 6
[a, z, a]
Expected Count of a's: 2   2
Expected Contains a: true true
Expected Contains e: false false
As = 5
Illegal Argument
Expected isEmpty(): false false
 */
