
/**
 * Write a description of class FinalObstacle here.
 *
 * @author (your name)
 * @version (a version number or a date)
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

    public void healthDecrement(Player p)
    {
        p.subtractHealth(50);
    }
    // for the final obstacle, don't ask for a choice, just call the method with choice = true for dummy variable
    public boolean succeedOrFail(Player p, boolean choice)
    {
        double constant = generateConstant();
        if(constant*p.getHealth() + constant*p.getFood() + constant*p.getWater() >= 150)
            return true;
        healthDecrement(p);
        p.move(85, 100);
        return false; 
    }
    // if fail, decrement health and move to right behind the wall into a random position
    public String toString()
    {
        return "goto heat wave";
    }
    
    public String weapon()
    {
        return "nothing... yep, no weapons on this one... just fight it with the skills you have gained...";
    }
    }
