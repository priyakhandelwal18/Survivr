
/**
 * Write a description of class Water here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Water extends Supplies
{
    /**
     * Constructor Water() - constructs a water object with 0 amount at the point (0, 0)
     */
    public Water()
    {
        super();
    }
    /**
     * Constructor Water() - constructs a water object with a specified amount and location
     * @param amount - amount of water
     * @param x - x coordinate
     * @param y - y coordinate
     */
    public Water(int amount, double x, double y)
    {
        super(amount, x, y);
    }
    public String toString()
    {
        return "water";
    }
}
