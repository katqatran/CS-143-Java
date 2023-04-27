import java.awt.*;
import java.util.Arrays;
import java.util.Random;

/**
* The MagicEightBall class extends the Ball class to simulate a magic eight ball. It contains an array of custom messages
* and methods to access and retrieve these messages. It also has a shake method that randomly selects and returns one of
* the messages.
*/
public class MagicEightBall extends Ball{
    
   private String[] messages;
   
   /**
    * Constructor for MagicEightBall class. Initializes color, size, and messages.
    * @param color the color of the ball
    * @param size the size of the ball in inches
    * @param messages the custom messages for the magic eight ball
    */
   public MagicEightBall(Color color, int size, String[] messages) {

        super(color, size);
        this.messages = messages;
    }

    /**
     * Returns the total number of messages in the array.
     * 
     * @return the total number of messages in the array
     */
    public int getTotalMessages(){
        return messages.length;
    }
     
    /**
     * Returns the message at the specified index.
     * @param index the index of the desired message
     * @return the message at the specified index
     */
    public String getMessage(int index){
        return messages[index];
    }

    /**
     * Simulates shaking the magic eight ball by randomly selecting and returning one of the custom messages.
     * @return a randomly selected custom message from the array
     */
    public String shake(){
        int index = new Random().nextInt(getTotalMessages());
        return getMessage(index);
    }
   
   /**
    * Returns a string representation of the MagicEightBall object.
    * @return a string representation of the MagicEightBall object, including its custom messages and inherited color
    * and size
    */
    @Override
    public String toString(){
        return "MagicEightBall Messages: "
                + Arrays.toString(messages)
                + "\n " + super.toString();
    }
}
