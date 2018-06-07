import java.awt.Point;
/**
 * Class Materials represents the properties of obstacles and supplies in this game.
 *
 * @author (Satvik Nagpal)
 * @version (06/06/2018)
 */
public class Materials
{
    private Point point = new Point(0, 0); //default location of point
    private int myAmount; //amount of supply
    /**
     * <b>Summary</b> Method getLocation() - return location of point
     * @return point that represents material's location
     */
    public Point getLocation()
    {
        return point;
    }
    /**
     * <b>Summary</b> Method changeLocation() - changes location of material
     * @param x x coordinate to be changed
     * @param y y coordinate to be changed
     */
    public void changeLocation(double x, double y)
    {
        point.setLocation(x, y);
    }
    /**
     * <b>Summary</b> Method getAmount() - returns amount of material
     * @return int that represents amount of supply
     */
    public int getAmount()
    {
        return myAmount;
    }
    /**
     * <b>Summary</b> Method setAmount() - changes amount of material
     * @param amount new amount of supply
     */
    public void setAmount(int amount)
    {
        myAmount = amount;
    }
}
