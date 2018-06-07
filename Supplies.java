import java.awt.geom.Point2D;
/**
 * Write a description of class Supplies here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Supplies extends Materials
{
    private int myAmount; //amount of supply
    private int myCapacity; //capacity of supply
    private Point2D.Double point; //location of supply
    
    /**
     * Constructor for objects of class Supplies
     */
    public Supplies()
    {
        myAmount = 0; 
        myCapacity = 0;
        point = new Point2D.Double(0.0, 0.0);
    }
    
    /**
     * Constructor that initializes myAmount to the amount specified
     * @param amount amount of supply initially
     * @param x x coordinate of supply
     * @param y y coordinate of supply
     */
    public Supplies(int amount, double x, double y)
    {
        setAmount(amount);
        point = new Point2D.Double(x, y); 
    }

    /**
     * <b>Summary</b> Method empty() - sets number of supplies to zero
     */
    public void empty()
    {
        myAmount = 0;
    }
    
    /**
     * <b>Summary</b> Method replenish() - replenishes the supplies to original capacity
     */
    public void replenishAll()
    {
        myAmount = myCapacity;
    }
    
    /**
     * <b>Summary</b> Method getPos() - returns position of the supply
     * @return Point representing location of player
     */
    public Point2D.Double getPos()
    {
        return point;
    }
    
    public String toString()
    {
        return "supply";
    }
    
}
