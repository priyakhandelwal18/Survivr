/**
 * class Drought - a Level 4 obstacle.
 *
 * @author Priya K
 * @version 052518
 */
public class Drought extends Obstacles // lvl 4
{

    /**
     * Constructor for objects of class Drought - initializes the location of the drought
     */
    public Drought(int x, int y)
    {
        changeLocation(x, y); 
    }

    /**
     *   If player fails obstsacle, the health is decremented by 40 
     *
     * @param  Player p  
     * @return 40 (amount to be decremented from a Level 4 obstacle) 
     */
    public void healthDecrement(Player p)
    {
        p.subtractHealth(40);
    }

    /**
     *  Uses an equation based on health and "irrelavant" supply to generate a random number
     *  If player chose to use a weapon, then if this random number is greater than 100, player succeeds
     *  If the player does not use a weapon, then if this random number is greater than 135, player succeeds
     *  else player fails
     *
     * @param  Player player, boolean choice  
     * @return boolean  
     */
    public boolean succeedOrFail(Player p, boolean choice)
    {
        double constant = generateConstant();
        boolean survive; // keeps track of whether player won or lost against obstacle
        // if player used weapon, a littler bit easier to win
        if(choice)
        {
            if ((constant) * (p.getHealth() + p.getWater()) >= 100)
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
            if ((constant) * (p.getHealth() + p.getWater()) >= 135)
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
        return "drought";
    }
    
    /**
     *  Returns name of weapon that can be used to help fight against obstacle: pickaxe
     *
     * @param  none  
     * @return String  
     */
    public String weapon()
    {
        return "pickaxe";
    }

}
