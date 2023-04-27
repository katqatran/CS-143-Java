/**
 * Katherine Tran
 *
 * This program represents an inventory of the 26 letters in the English alphabet.
 * A LetterInventory object keeps track of how many a’s, how many b’s, etc.
 * are contained in a given string.
 * For example:
 * the letter inventory for the string “Washington State” corresponds to [aaeghinnosstttw].
 * The case of the letter is ignored, so ‘s’ and ‘S’ are exactly the same.
 */
package inventory;

import java.util.*;
import java.io.*;
import java.util.*;
import java.io.*;

public class LetterInventory implements Inventory {
  
   private int[] letters;

   public static final int ALPHABET_SIZE = 26;

   public LetterInventory() {

      letters = new int[ALPHABET_SIZE];
   }

   /**
    * Returns a String representation of the inventory with the letters all in lowercase
    * surrounded by square brackets in alphabetical order. The number of occurrences of
    * each letter matches its count in the inventory.
    * For example, an inventory of 4 a’s, 1 b, 1 k and 1 m would be represented as “[aaaabkm]”.
    * @return a bracketed string representation of the letters contained in the inventory
    */
   public String toString() {
     
      StringBuilder toReturn = new StringBuilder("[");

      for(int i = 0; i < letters.length; i++) {
         for(int count = 0; count < letters[i]; count++) {
            // ascii math performed here
            // Example:
            // 'a' + 0 = 'a'
            // 'a' + 1 = 'b'
            // 'a' + 2 = 'c'
            // 'a' + 25 = 'z'
            toReturn.append((char)('a' + i));
         }
      }
      return toReturn.append("]").toString();
   }

  /**
   * Adds one count to the inventory for the given letter, ignoring case.
   * @param c the letter to add to the inventory
   */
   @Override
   public void add(char c) {
      c = Character.toLowerCase(c);

      if (Character.isLetter(c)) {
         letters[c - 'a']++;
      }
   }

  /**
   * Subtracts one count from the inventory for the given letter, ignoring case.
   * @param c the letter to subtract from the inventory
   */
   @Override
   public void subtract(char c) {
      c = Character.toLowerCase(c);

      if (Character.isLetter(c)) {
         letters[c - 'a']--;
      }
   }

  /**
   * Returns the count of the given letter in the inventory, ignoring case.
   * @param c the letter to query the count for
   * @return the count of the letter in the inventory
   */
   @Override
   public int get(char c) {
      c = Character.toLowerCase(c);

      if (Character.isLetter(c)) {
         return letters[c - 'a'];
      }
      return 0;
   }

  /**
   * Returns the count of the given letter in the inventory, ignoring case.
   * @param c the letter to query the count for
   * @return the count of the letter in the inventory
   */
   @Override
   public void set(char c, int count) {
      c = Character.toLowerCase(c);

      if (!Character.isLetter(c)) {
         throw new IllegalArgumentException();
      }

      if (count < 0) {
         throw new IllegalArgumentException();
      }
     
      letters[c - 'a'] = count;
   }

   /**
    * Returns whether this inventory contains the given letter.
    * @param c the letter to search for
    * @return true if the letter is present in the inventory, false otherwise
    */
   @Override
   public boolean contains(char c) {
      return get(c) > 0;
   }

   /**
    * Returns the total count of all letters in this inventory.
    * @return the total count of letters
    */
   @Override
   public int size() {
      int size = 0;
      for ( int letter : letters) {
         size += letter;
      }
      return size;
   }

   /**
    * Returns whether this inventory is empty (i.e., has a size of zero).
    * @return true if this inventory is empty, false otherwise
    */
   @Override
   public boolean isEmpty() {
      return size() == 0;
   }

   public static void main(String[] args) {
      LetterInventory inv = new LetterInventory();
      inv.add('a');
      inv.add('b');
      inv.add('b');
      inv.add('z');
      inv.subtract('a');
      inv.set('?',2);
      System.out.println(inv);
   }
}
