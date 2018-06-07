/**
 * Write a description of class TimTheEnchanter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TimTheEnchanter
{
   /**
     * Constructor for objects of class TimTheEnchanter- (does not instanciate anything)
     */
    public TimTheEnchanter()
    {   
    }

   /**
   *  Checks if player is at obstacle. If player is at obstacle, returns a message telling what obstacle and what weapons
   *  are available so that GameRunner can print this information for user. If not, returns null. 
   *
   * @param  Player player  
   * @return String returnString(actual message if run into obstacle, else return null)
   */
    public String runIntoObstacle(Player p)
    {
        Obstacles obstacle;
        String returnString = null;
        if(p.isAtObstacle())
        {
            obstacle = (Obstacles)p.playerBiome(p.getLocation()).getMaterial((int)p.convertLoc(p.getLocation()).getX(), (int)p.convertLoc(p.getLocation()).getY());
            returnString ="Oh no! You've run into a " + obstacle.toString() + "! "
            + "You can fight this with " + obstacle.weapon();
            if(!(obstacle instanceof FinalObstacle))
            {
                 returnString += ", if you have some to spare..."; 
            }
        }
        return returnString;
    }

   /**
   *  Determines what the obstacle is and calls the succeedOrFail method for that particular obstacle. If method returns true,
   *  a "succeed" message is returned for GameRunner to print, and if method returns false, a "fail" message is returned. 
   *
   * @param  Player player, boolean choice  
   * @return "Good work! You succeeded against the obstacle!" if player succeeded
   *         "Ouch... you failed the obstacle" if player failed
   */
    public String fightObstacle(Player p, boolean choice)
    {
        Obstacles obstacle = (Obstacles)p.playerBiome(p.getLocation()).getMaterial((int)p.convertLoc(p.getLocation()).getX(), (int)p.convertLoc(p.getLocation()).getY());
        if(obstacle.succeedOrFail(p, choice))
        {
            return "Good work! You succeeded against the obstacle!";
        }
        else
        {
            return "Ouch... you failed the obstacle"; 
        }
    }

   /**
   *  Checks if player is at supply. If player is at supply, returns a message telling what supply they got
   *  so that GameRunner can print this information for user. If not, returns null.
   *
   * @param  Player player  
   * @return supply name and message if supply found
   *         otherwise returns null
   */
    public String runIntoSupply(Player p)
    {
        Supplies supply;
        if(p.isAtSupply())
        {
            supply = (Supplies)p.playerBiome(p.getLocation()).getMaterial((int)p.convertLoc(p.getLocation()).getX(), (int)p.convertLoc(p.getLocation()).getY());
            System.out.println("supply: " + supply);
            return "Yay! You've just found some " + supply.toString() + "!"; 
        }
        return null;
    }

   /**
   *  Determines what the supply is that the user ran into and returns the amount of supply present so that GameRunner
   *  can print for user. It also adds the supply found to the Player's stash and clears the supply from the board so that 
   *  it cannot be used again
   *
   * @param  Player player  
   * @return amount 
   */
    public int collectSupply(Player p)
    {
        Supplies supply = (Supplies)p.playerBiome(p.getLocation()).getMaterial((int)p.convertLoc(p.getLocation()).getX(), (int)p.convertLoc(p.getLocation()).getY());
        int amount = supply.getAmount();
        if(supply instanceof Metal)
        {
            p.addMetal(amount); 
        }
        else
        if(supply instanceof Wood)
        {
            p.addWood(amount); 
        }
        else
        if(supply instanceof Food)
        {
            p.addFood(amount); 
        }
        else
        if(supply instanceof Water)
        {
            p.addWater(amount); 
        }
        System.out.println("supply: " + amount);
        p.playerBiome(p.getLocation()).clearMaterial(p.convertLoc(p.getLocation()));
        return amount;
    }

   /**
   *  Generates a random number; if the number is greater than .992, the user gets a tiny random gift;
   *  if the number is greater than .994, the user gets a medium random gift;
   *  if the number is greater than .996, the user gets a large random gift;
   *  
   *  @param  Player player  
   *  @return String with description of gift if user is granted a gift
   *          Otherwise returns a null string
   */
    public String randomGift(Player player)
    {
        double random = Math.random();
        
        if(random >= 0.992)
        {
            if(random >= 0.994)
            {
                if(random >= 0.996)
                {
                    if(player.getHealth() < 50)
                    {
                        player.addWater(45); 
                        System.out.println("You've been working hard... here's 45 more water!");
                        return "You've been working hard... here's 45 more water!";
                    }

                    else
                    {
                        player.addFood(100);
                        System.out.println("You look hungry... here's 100 more food!");
                        return "You look hungry... here's 100 more food!";
                    }
                }
                if(player.getHealth() < 50)
                {
                    player.addWater(25); 
                    System.out.println("You've been working hard... here's 25 more water!");
                    return "You've been working hard... here's 25 more water!";
                }

                else
                {
                    player.addFood(80);
                    System.out.println("You look hungry... here's 80 more food!");
                    return "You look hungry... here's 80 more food!";
                }
            }
            if(player.getHealth() < 50)
            {
                player.addWater(10); 
                System.out.println("You've been working hard... here's 10 more water!");
                return "You've been working hard... here's 10 more water!";
            }

            else
            {
                player.addFood(50);
                System.out.println("You look hungry... here's 50 more food!");
                return "You look hungry... here's 50 more food!";
            }
        }
        return null; 
    }
   
   /**
   *  Checks if there is at least 10 water and less than 100 health if the user wants to drink water
   *  and increments the user's health by 1 for every 10 water they drink; 
   *  otherwise throw an IllegalArgumentException describing why they can't drink the water
   *
   * @param  Player player  
   * @return none 
   */
    public void drink(Player p)
    {
        if (p.getWater() < 10)
        {
            throw new IllegalArgumentException("Not enough water to drink");
        }
        else
        {
            if (p.getHealth() > 99)
                throw new IllegalArgumentException("You already have enough health");
            else
            {
                p.subtractWater(10);
                p.addHealth(1);
            }
        }
    }
   
   /**
   *  Checks if there is at least 10 food and less than 99 health if the user wants to eat food
   *  and increments the user's health by 2 for every 10 food they eat; 
   *  otherwise throw an IllegalArgumentException describing why they can't eat the food
   *
   * @param  Player player  
   * @return none 
   */
    public void eat(Player p)
    {
        if (p.getFood() < 10)
        {
            throw new IllegalArgumentException("Not enough food to eat");
        }
        else
        {
            if (p.getHealth() > 98)
                throw new IllegalArgumentException("You already have enough health");
            else
            {
                p.subtractFood(10);
                p.addHealth(2);
            }
        }
    }

   /**
   *  Returns the material at Player's current location, if any
   *
   * @param  Player player  
   * @return Materials 
   */
    public Materials returnMaterial(Player p)
    {
        return p.playerBiome(p.getLocation()).getMaterial((int)p.convertLoc(p.getLocation()).getX(), (int)p.convertLoc(p.getLocation()).getY());
    }

   /**
   *  If health is less than 0, method returns an empty string so that GameRunner knows the player is dead. Else, returns null
   *
   * @param  Player player  
   * @return String 
   */
    public String die(Player p)
    {
        if(p.getHealth() <= 0)
        {
            return "";
        }
        return null; 
    }

   /**
   *  If player has reached final obstacle, method calls succeedOrFail and returns an empty string for GameRunner to make decision. Else,
   *  returns null because player has not reached end of game yet.
   *
   * @param  Player player  
   * @return String 
   */
    public String win(Player p)
    {
        if(p.getLocation().getY() == 2)
        {
            Obstacles obstacle = (FinalObstacle)p.playerBiome(p.getLocation()).getMaterial((int)p.convertLoc(p.getLocation()).getX(), (int)p.convertLoc(p.getLocation()).getY()); 
            if(obstacle.succeedOrFail(p, true))
            {
                return "";
            }
            else
            {
               return "";
            }
        }
        return null; 
    }
}
