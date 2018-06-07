
/**
 * class Animal - a Level 2 obstacle.
 *
 * @author Priya K 
 * @version 052518
 */
public class Animal extends Obstacles // lvl 2
{
    /**
     * Constructor for objects of class Animal - initializes the location of the Animal
     */
    public Animal(int x, int y)
    {
        changeLocation(x, y); 
    }

    /**
     *   If player fails, the health is decremented by 20 
     *
     * @param  none  
     * @return 20 (amount to be decremented from a Level 2 obstacle) 
     */
    public void healthDecrement(Player p)
    {
        p.subtractHealth(20);
    }

    /**
     *  Uses an equation based on health and "irrelavant" supply to generate a random number
     *  If player chose to use a weapon, then if this random number is greater than 55, player succeeds
     *  If the player does not use a weapon, then if this random number is greater than 90, player succeeds
     *  else player fails
     *
     * @param  Player player, boolean choice  
     * @return true if player succeeds, false if player fails 
     */
    public boolean succeedOrFail(Player p, boolean choice)
    {
        double constant = generateConstant();
        boolean survive; // keeps track of whether player won or lost against obstacle
        // if player used weapon, a littler bit easier to win
        if(choice)
        {
            if ((constant) * (p.getHealth() + p.getFood()) >= 55)
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
            if ((constant) * (p.getHealth() + p.getFood()) >= 90)
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
        return "animal";
    }
    
    /**
     *  Returns name of weapon that can be used to help fight against obstacle: spear
     *
     * @param  none  
     * @return String  
     */
    public String weapon()
    {
        return "spear";
    }

}
