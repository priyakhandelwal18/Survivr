
/**
 * Write a description of class Animal here - a Level 2 obstacle.
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
     *  Uses an equation based on health and supply to generate a random number
     *  If this random number is greater than 40, player succeeds
     *  If this random number is less than 40, player fails
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
            if ((constant) * (p.getHealth() + p.getFood()) >= 55)
                survive = true;
            else
            {
                survive = false;
                healthDecrement(p);
            }
        }
        else
        {
            if ((constant) * (p.getHealth() + p.getFood()) >= 80)
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
        return "animal";
    }
    
    public String weapon()
    {
        return "spear";
    }

}
