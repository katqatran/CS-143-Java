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
  
   private int[] letters; // letters is null here

   public static final int ALPHABET_SIZE = 26;


   // default constructor - need to provide this constructor
   // so memory is constructed for array (so it is no longer null)
   public LetterInventory() {
      //TODO fix the style issue below
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
      // If you are concatenating many strings together, StringBuilder class
      // is often more efficient(faster)
      StringBuilder toReturn = new StringBuilder("[");

      // for every count in the letters inventory
      for(int i = 0; i < letters.length; i++) {
         // add each character to the string count times
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

   @Override
   public void add(char c) {
      c = Character.toLowerCase(c);

      if (Character.isLetter(c)) {
         letters[c - 'a']++;
      }
   }

   @Override
   public void subtract(char c) {
      c = Character.toLowerCase(c);

      if (Character.isLetter(c)) {
         letters[c - 'a']--;
      }
   }

   @Override
   public int get(char c) {
      c = Character.toLowerCase(c);

      if (Character.isLetter(c)) {
         return letters[c - 'a'];
      }
      return 0;
   }

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

   @Override
   public boolean contains(char c) {
      return get(c) > 0;
   }

   @Override
   public int size() {
      int size = 0;
      for ( int letter : letters) {
         size += letter;
      }
      return size;
   }

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
