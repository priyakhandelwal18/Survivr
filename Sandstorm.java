/**
 * Write a description of class Sandstorm here - a Level 4 Obstacle
 *
 * @author Priya K
 * @version 052518
 */
public class Sandstorm extends Obstacles // lvl 4
{
   /**
     * Constructor for objects of class Sandstorm - initializes the location of the sandstorm
     */
    public Sandstorm(int x, int y)
    {
        // initialise instance variables
        changeLocation(x, y); 
    }
    
     /**
   *   If player fails, the health is decremented by 40 
   *
   * @param  none  
   * @return 40 (amount to be decremented from a Level 4 obstacle) 
   */
    public void healthDecrement(Player p)
    {
        p.subtractHealth(40);
    }
   
    /**
   *  Uses an equation based on health and supply to generate a random number
   *  If this random number is greater than 80, player succeeds
   *  If this random number is less than 80, player fails
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
            if ((constant) * (p.getHealth() + p.getArmor()) >= 100)
                survive = true;
            else
            {
                survive = false;
                healthDecrement(p);
            }
        }
        else
        {
            if ((constant) * (p.getHealth() + p.getArmor()) >= 125)
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
       return "sandstorm";
   }
   
   public String weapon()
    {
        return "armor";
    }

}
