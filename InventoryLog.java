package inventory;

import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class InventoryLog implements Inventory {
  
   /**
     * The ArrayList containing the characters in the inventory.
     */
    private ArrayList<Character> characterList;

    /**
     * Constructs a new InventoryLog object with an empty ArrayList.
     */
    public InventoryLog() {
        characterList = new ArrayList<Character>();
    }

    /**
     * Adds the specified character to the end of the inventory.
     * @param c the character to add to the inventory
     */
    @Override
    public void add(char c) {
        characterList.add(c);
    }

    /**
     * Removes all occurrences of the specified character from the inventory.
     * @param c the character to remove from the inventory
     */
    @Override
    public void subtract(char c) {
        int i = 0;
        while ( i < characterList.size()) {
            if (characterList.get(i).equals(c)) {
                characterList.remove(i);
            }else {
                i++;
            }
        }
    }

    /**
     * Returns the count of the specified character in the inventory.
     * @param c the character to get the count of
     * @return the count of the character in the inventory
     */
    @Override
    public int get(char c) {
        int count = 0;
        for (char item : characterList) {
            if (item == c) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns true if the inventory contains the specified character, false otherwise.
     * @param c the character to check if it's in the inventory
     * @return true if the inventory contains the character, false otherwise
     */
    @Override
    public boolean contains(char c) {
        return characterList.contains(c);
    }

    /**
     * Returns the size of the inventory.
     * @return the size of the inventory
     */
    @Override
    public int size() {
        return characterList.size();
    }

    /**
     * Returns true if the inventory is empty, false otherwise.
     * @return true if the inventory is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return characterList.isEmpty();
    }

    /**
     * Sets the count of the specified character to the specified value.
     * @param c the character to set the count of
     * @param count the value to set the count of the character to
     * @throws IllegalArgumentException if the character is not in the inventory or the count is negative
     */
    @Override
    public void set (char c, int count) {
        if (count < 0) {
            throw new IllegalArgumentException();
        }

        if (!contains(c)) {
            throw new IllegalArgumentException();
        }

        int amount = count - get(c);

        if (amount < 0) {
            amount *= -1;
            for (int i = 1; i <= amount; i++) {
                subtract(c);
            }
        }
        if (amount > 0) {
            for (int i = 1; i <= amount; i++) {
                add(c);
            }
        }
    }
  
  /**
    * Returns a string representation of the InventoryLog object.
    * The string representation is the same as the string representation of the characterList ArrayList.
    * @return a string representation of the InventoryLog object
    */
    @Override
    public String toString(){
        return characterList.toString();
    }
}
