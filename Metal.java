
/**
 * Class Metal represents the properties of metal in this game.
 *
 * @author (Satvik Nagpal)
 * @version (06/06/2018)
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
    
    /**
     * <b>Summary</b> Method toString() - returns name of supply in a string
     * @return a String that represents supply
     */
    public String toString()
    {
        return "metal";
    }
}
