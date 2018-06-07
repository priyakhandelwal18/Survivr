
/**
 * Class Wood represents the properties of wood in this game.
 *
 * @author (Satvik Nagpal)
 * @version (06/06/2018)
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
    /**
     * <b>Summary</b> Method toString() - returns the name of the supply in a string
     * @return string that represents a string
     */
    public String toString()
    {
        return "wood";
    }
}
