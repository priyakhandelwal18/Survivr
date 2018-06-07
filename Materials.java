import java.awt.Point;
/**
 * Write a description of class Materials here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Materials
{
    private Point point = new Point(0, 0);
    private int myAmount;
    public Point getLocation()
    {
        return point;
    }
    public void changeLocation(double x, double y)
    {
        point.setLocation(x, y);
    }
    public int getAmount()
    {
        return myAmount;
    }
    public void setAmount(int amount)
    {
        myAmount = amount;
    }
}
