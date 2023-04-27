import java.awt.*;

public class Ball implements Comparable<Ball> {
    
    /**
     * The color of the ball.
     */
    private Color color;
    
    /**
     * The size of the ball, in inches.
     */
    private int size;

    /**
     * Constructs a new Ball object with the specified color and size.
     * @param color the color of the ball
     * @param size the size of the ball, in inches
     */
    public Ball(Color color, int size) {
        this.color = color;
        this.size = size;
    }

    /**
     * Returns the color of the ball.
     * @return the color of the ball
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns the size of the ball.
     * @return the size of the ball, in inches
     */
    public int getSize() {
        return size;
    }

    /**
     * Compares this ball to another ball based on their sizes.
     * @param other the other ball to compare to
     * @return -1 if this ball is smaller, 0 if they are the same size, or 1 if this ball is larger
     */
    @Override
    public int compareTo(Ball other) {
        if (this.size < other.size) {
            return -1;
        } else if (this.size > other.size) {
            return 1;
        } else {
            return 0;
        }
    }
    
    /**
     * Returns a string representation of this ball, including its color and size.
     * @return a string representation of this ball
     */
    @Override
    public String toString() {
        return "Ball Color: [red = " + color.getRed() +
                ", green = " + color.getGreen() +
                ", blue = " + color.getBlue() + "] Ball size: "
                + getSize() + " inches.";
    }
}
