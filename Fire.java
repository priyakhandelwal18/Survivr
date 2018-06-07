import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
/**
 * class Fire - a Level 3 obstacle.
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
     *  Uses an equation based on health and "irrelavant" supply to generate a random number
     *  If player chose to use a weapon, then if this random number is greater than 75, player succeeds
     *  If the player does not use a weapon, then if this random number is greater than 110, player succeeds
     *  else player fails
     *
     * @param  Player player, boolean choice  
     * @return true if player succeeds, false if player fails 
     */
    public boolean succeedOrFail(Player p, boolean choice)
    {
        double constant = Math.random();
        boolean survive; // keeps track of whether player won or lost against obstacle
        // if player used weapon, a littler bit easier to win
        if(choice)
        {
            if ((constant) * (p.getHealth() + p.getWater()) >= 75)
                survive = true;
            else
            {
                // if player lost, decrement health
                survive = false;
                healthDecrement(p);
            }
        }
        // if player did not use a weapon, a littler harder easier to win
        else
        {
            if ((constant) * (p.getHealth() + p.getWater()) >= 110)
            {
                survive = true;
            }
            else
            {
                // if player lost, decrement health
                survive = false;
                healthDecrement(p);
            }
        }
        return survive; 
    }

    /**
     *  Returns name of obstacle
     *
     * @param  none  
     * @return String  
     */
    public String toString()
    {
        return "fire";
    }
    
    /**
     *  Returns name of weapon that can be used to help fight against obstacle: fire-proof shield
     *
     * @param  none  
     * @return String  
     */
    public String weapon()
    {
        return "fire-proof shield";
    }

}
