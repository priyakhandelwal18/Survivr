
/**
 * Class Food represents the properties of food in this game.
 *
 * @author (Satvik Nagpal)
 * @version (06/06/2018)
 */
public class Food extends Supplies
{
    /**
     * Constructor Food() - constructs a Food object with 0 amount at the point (0, 0)
     */
    public Food()
    {
        super();
    }
    /**
     * Constructor Food() - constructs a Food object with a specified amount and location
     * @param amount - amount of food
     * @param x - x coordinate
     * @param y - y coordinate
     */
    public Food(int amount, double x, double y)
    {
        super(amount, x, y);
    }
    /**
     * <b>Summary</b> Method toString() - returns the name of the supply in a string
     * @return string that represents a string
     */
    public String toString()
    {
        return "food";
    }
}
