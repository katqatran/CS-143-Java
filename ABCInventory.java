/**
 * This program will keep track of counts for the letters 'a', 'A', 'b', 'B', 'c', 'C'.
 */
 
package inventory;

import java.util.*;
import java.io.*;

public class ABCInventory implements Inventory {

   private int aCount;
   private int bCount;
   private int cCount;

   /**
    * Constructs a new ABCInventory with counts initialized to zero for the characters 'a', 'A', 'b', 'B', 'c', 'C'.
    */
   public ABCInventory() {
      this.aCount = 0;
      this.bCount = 0;
      this.cCount = 0;
   }

   /**
    * Increments the count of the specified character in the inventory.
    * @param c the character to add to the count
    */
   @Override
   public void add(char c) {
      c = Character.toLowerCase(c);

      if (c == 'a') {
         aCount++;
      } else if (c == 'b') {
         bCount++;
      } else if (c == 'c') {
         cCount++;
      }
   }

   /**
    * Decrements the count of the character c in the inventory
    * @param c the character to subtract from the count
    */
   @Override
   public void subtract(char c) {
      c = Character.toLowerCase(c);

      if (c == 'a') {
         aCount--;
      } else if (c == 'b') {
         bCount--;
      } else if (c == 'c') {
         cCount--;
      }
   }

   /**
    * Gets the count for the specified character 'a', 'b', or 'c'.
    *
    * @param c the character whose count is to be retrieved
    * @return  the count for the specified character, or 0 if the character is not 'a', 'b', or 'c'
    */
   @Override
   public int get(char c) {
      c = Character.toLowerCase(c);

      if (c == 'a') {
         return aCount;
      } else if (c == 'b') {
         return bCount;
      } else if (c == 'c') {
         return cCount;
      }
      return 0;
   }

   /**
    * Sets the count for the specified character 'a', 'b', or 'c' to the specified value.
    * @param c the character whose count is to be set
    * @param count the character whose count is to be set
    * @throws IllegalArgumentException if the input character is not 'a', 'b', or 'c', or if the count is negative
    */
   @Override
   public void set(char c, int count) {
      c = Character.toLowerCase(c);

      if (c != 'a' && c != 'b' && c != 'c') {
         throw new IllegalArgumentException();
      }

      if (count < 0) {
         throw new IllegalArgumentException();
      }

      if (c == 'a') {
         aCount = count;
      } else if (c == 'b') {
         bCount = count;
      } else if (c == 'c') {
         cCount = count;
      }
   }

   /**
    * Checks if the count for the specified character 'a', 'b', or 'c' is greater than zero.
    * @param c the character to check
    * @return true if the count for the specified character is greater than zero, false otherwise
    */
   @Override
   public boolean contains(char c) {
      return get(c) > 0;
   }

   /**
    * Returns the total count of all characters ('a', 'b', and 'c') in the Counter.
    * @return the total count of all characters
    */
   @Override
   public int size() {
      return aCount + bCount + cCount;
   }

   /**
    * Checks if the Counter is empty, meaning that the total count of all characters ('a', 'b', and 'c') is zero.
    * @return true if the Counter is empty, false otherwise
    */
   @Override
   public boolean isEmpty() {
      return size() == 0;
   }

   /**
    * Returns a String representation of the Counter object, showing the count of each character ('a', 'b', and 'c').
    * @return a String representation of the Counter object
    */
   public String toString() {
      return "[A=" + aCount + ", B=" + bCount + ", C=" + cCount + "]";
   }
}
