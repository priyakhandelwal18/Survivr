
/**
 * Class Water represents the properties of water in this game.
 *
 * @author (Satvik Nagpal)
 * @version (06/06/2018)
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
    /**
     * <b>Summary</b> Method toString() - returns the name of the supply in a string
     * @return string that represents a string
     */
    public String toString()
    {
        return "water";
    }
}
