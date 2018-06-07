
/**
 * Write a description of class Metal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Metal extends Supplies
{
    /**
     * Constructor Metal() - constructs a Metal object with 0 amount at the point (0, 0)
     */
    public Metal()
    {
        super();
    }
    /**
     * Constructor Metal() - constructs a Metal object with a specified amount and location
     * @param amount - amount of water
     * @param x - x coordinate
     * @param y - y coordinate
     */
    public Metal(int amount, double x, double y)
    {
        super(amount, x, y);
    }
    public String toString()
    {
        return "metal";
    }
}
