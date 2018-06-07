
/**
 * Write a description of class Wood here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Wood extends Supplies
{
    /**
     * Constructor Wood() - constructs a wood object with 0 amount at the point (0, 0)
     */
    public Wood()
    {
        super();
    }
    /**
     * Constructor Wood() - constructs a wood object with a specified amount and location
     * @param amount - amount of water
     * @param x - x coordinate
     * @param y - y coordinate
     */
    public Wood(int amount, double x, double y)
    {
        super(amount, x, y);
    }
    public String toString()
    {
        return "wood";
    }
}
