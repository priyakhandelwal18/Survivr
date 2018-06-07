
/**
 *  class FinalObstacle - Level 5 obstacle
 *
 * @author Priya K
 * @version 052502
 */
public class FinalObstacle extends Obstacles
{
    /**
     * Constructor for objects of class FinalObstacle
     */
    public FinalObstacle(int x, int y)
    {
        changeLocation(x, y);
    }

    /**
     *  decrements health by 50 if player loses obstacle
     *
     * @param  Player p  
     * @return none  
     */
    public void healthDecrement(Player p)
    {
        p.subtractHealth(50);
    }
    
    /**
     *  Uses an equation based on health, water, and food to generate a random number
     *  Since there is no weapon, if the random number is greater than 150, player succeeds and method returns true
     *  Else player's health is decremented and it moves back and returns false
     *  else player fails
     *
     * @param  Player player, boolean choice  
     * @return boolean  
     */
    public boolean succeedOrFail(Player p, boolean choice)
    {
        double constant = Math.random();
        if(constant*p.getHealth() + constant*p.getFood() + constant*p.getWater() >= 150)
            return true;
        // if player lost, decrement health and move back
        healthDecrement(p);
        p.move(85, 100);
        return false; 
    }
    
    /**
     *  Returns name of obstacle
     *
     * @param  none  
     * @return String  
     */
    public String toString()
    {
        return "goto heat wave";
    }
    
    /**
     *  Returns name of weapon that can be used to help fight against obstacle: none
     *
     * @param  none  
     * @return String  
     */
    public String weapon()
    {
        return "nothing... yep, no weapons on this one... just fight it with the skills you have gained...";
    }
    }
