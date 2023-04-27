/* Katherine Tran
 *
 * This program will utilize MagicEightBall and Ball to create magic eight balls to compare their sizes and simulate the 
 * responses of a magic eight ball.
 */

import java.awt.*;
import java.util.Arrays;

public class Driver {
    /**
     * The main method creates two Ball objects with different colors and sizes, compares their sizes using the compareTo
     * method, sorts an array of Ball objects using the Arrays class, creates a MagicEightBall object with custom messages, 
     * and simulates shaking the Magic Eight Ball to get a response.
     * @param args
     */
    public static void main(String[] args) {
        Ball ball = new Ball(Color.GRAY, 8);
        System.out.println(ball);

        Ball[] ballArray = {
                new Ball(Color.GRAY,10),
                new Ball(Color.BLUE,5)
        };

        int result = ballArray[1].compareTo(ballArray[1]);
        System.out.println("Result: " + result);


        Arrays.sort(ballArray);
        System.out.println(Arrays.toString(ballArray));

        String[] msgs = {"yes", "no", "maybe",
                "definitely not", "without a doubt", "most likely",
                "signs point to yes", "outlook bad"};
        MagicEightBall ball8 = new MagicEightBall(Color.darkGray,
                12, msgs);
        for (int i = 1; i <= 5; i++) {
            System.out.println("You shake the magic eight ball");
            System.out.println("The ball says: " + ball8.shake());
            System.out.println();
        }
        System.out.println(ball8);
    }
}

/*
You shake the magic eight ball
The ball says: without a doubt

You shake the magic eight ball
The ball says: most likely

You shake the magic eight ball
The ball says: signs point to yes

You shake the magic eight ball
The ball says: without a doubt

You shake the magic eight ball
The ball says: signs point to yes

MagicEightBall Messages: [yes, no, maybe, definitely not, without a doubt, most likely, signs point to yes, outlook bad]
Ball Color: [red = 64, green = 64, blue = 64] Ball size: 12 inches.
*/
