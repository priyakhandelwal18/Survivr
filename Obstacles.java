import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Obstacles here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Obstacles extends Materials
{
    // add option as a parameter 
  /**
   *  Generates a random constant to be used as the coefficient for succeedOrFail
   *
   * @param  none  
   * @return double (randomly generated) 
   */
    public double generateConstant()
    {
        return Math.random();
    }
  public abstract void healthDecrement(Player p); 
  public abstract boolean succeedOrFail(Player p, boolean choice);
  public abstract String toString();
  public abstract String weapon();
}
