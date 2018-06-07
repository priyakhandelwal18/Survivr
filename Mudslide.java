/**
 * Write a description of class Mudslide here - a Level 1 Obstacle
 *
 * @author PriyaK
 * @version 052518
 */
public class Mudslide extends Obstacles
{
    // factors in rope built supply
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
     *  Uses an equation based on health and supply to generate a random number
     *  If this random number is greater than 20, player succeeds
     *  If this random number is less than 20, player fails
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
            if ((constant) * (p.getHealth() + p.getMetal()) >= 35)
                survive = true;
            else
            {
                survive = false;
                healthDecrement(p);
            }
        }
        else
        {
            if ((constant) * (p.getHealth() + p.getMetal()) >= 60)
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
        return "mudslide";
    }
    
    public String weapon()
    {
        return "rope";
    }
}
