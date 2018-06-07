import java.util.List;
import java.util.ArrayList;
/**
 *  class Obstacles - abstract class for generating obstacles for user.
 *
 * @author Priya K
 * @version 052502
 */
public abstract class Obstacles extends Materials
{
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
    
  /**
   *  If user fails, decrements health based on level of obstacle
   *
   * @param  Player p  
   * @return none 
   */
  public abstract void healthDecrement(Player p); 
  
  /**
   *  Uses factors and difficulty of obstacle to determine randomly whether user succeeded or failed
   *
   * @param  Player p, boolean choice  
   * @return none 
   */
  public abstract boolean succeedOrFail(Player p, boolean choice);
  
  /**
     *  Returns name of obstacle
     *
     * @param  none  
     * @return String  
     */
  public abstract String toString();
  
  /**
     *  Returns name of weapon that can be used to help fight against obstacle: rope
     *
     * @param  none  
     * @return String  
     */
  public abstract String weapon();
}