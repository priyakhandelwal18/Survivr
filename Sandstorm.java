/**
 * class Sandstorm - a Level 4 Obstacle
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
     *  Uses an equation based on health and "irrelavant" supply to generate a random number
     *  If player chose to use a weapon, then if this random number is greater than 110, player succeeds
     *  If the player does not use a weapon, then if this random number is greater than 135, player succeeds
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
            if ((constant) * (p.getHealth() + p.getArmor()) >= 100)
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
            if ((constant) * (p.getHealth() + p.getArmor()) >= 135)
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
       return "sandstorm";
   }
   
   /**
     *  Returns name of weapon that can be used to help fight against obstacle: armor
     *
     * @param  none  
     * @return String  
     */
   public String weapon()
    {
        return "armor";
    }

}
