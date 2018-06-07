/**
 * class Mudslide here - a Level 1 Obstacle
 *
 * @author PriyaK
 * @version 052518
 */
public class Mudslide extends Obstacles
{
    /**
     * Constructor for objects of class Mudslide - initializes the location of the mudslide
     */
    public Mudslide(int x, int y)
    {
        changeLocation(x, y); 
    }

    /**
     *   If player fails, the health is decremented by 10 
     *
     * @param  none  
     * @return 10 (amount to be decremented from a Level 1 obstacle) 
     */
    public void healthDecrement(Player p)
    {
        p.subtractHealth(10);
    }

    /**
     *  Uses an equation based on health and "irrelavant" supply to generate a random number
     *  If player chose to use a weapon, then if this random number is greater than 35, player succeeds
     *  If the player does not use a weapon, then if this random number is greater than 70, player succeeds
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
            if ((constant) * (p.getHealth() + p.getMetal()) >= 35)
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
            if ((constant) * (p.getHealth() + p.getMetal()) >= 70)
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
        return "mudslide";
    }
    
    /**
     *  Returns name of weapon that can be used to help fight against obstacle: rope
     *
     * @param  none  
     * @return String  
     */
    public String weapon()
    {
        return "rope";
    }
}
