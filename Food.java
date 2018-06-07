
/**
 * Write a description of class Food here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
    public String toString()
    {
        return "food";
    }
}
