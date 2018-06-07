import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
/**
 * Write a description of class Fire here - a Level 3 obstacle.
 *
 * @author Priya K
 * @version 052518
 */
public class Fire extends Obstacles // lvl 3
{
    /**
     * Constructor for objects of class Fire - initializes the location of the fire
     */
    public Fire(int x, int y)
    {
        changeLocation(x, y); 
    }

    /**
     *   If player fails, the health is decremented by 30 
     *
     * @param  none  
     * @return 30 (amount to be decremented from a Level 3 obstacle) 
     */
    public void healthDecrement(Player p)
    {
        p.subtractHealth(30);
    }

    /**
     *  Uses an equation based on health and supply to generate a random number
     *  If this random number is greater than 60, player succeeds
     *  If this random number is less than 60, player fails
     *
     * @param  Player player  
     * @return true if player succeeds, false if player fails 
     */
    public boolean succeedOrFail(Player p, boolean choice)
    {
        double constant = generateConstant();
        boolean survive;
        if(choice)
        {
            if ((constant) * (p.getHealth() + p.getWater()) >= 75)
                survive = true;
            else
            {
                survive = false;
                healthDecrement(p);
            }
        }
        else
        {
            if ((constant) * (p.getHealth() + p.getWater()) >= 100)
            {
                survive = true;
            }
            else
            {
                survive = false;
                healthDecrement(p);
            }
        }
        return survive; 
    }

    public String toString()
    {
        return "fire";
    }
    
    public String weapon()
    {
        return "fire-proof shield";
    }

}
