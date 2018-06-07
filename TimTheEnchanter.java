/**
 * Write a description of class TimTheEnchanter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TimTheEnchanter
{
    /**
     * Constructor for objects of class TimTheEnchanter
     */
    public TimTheEnchanter()
    {   
    }

    public String enteredNewBiome(Player player)
    {
        if(!player.playerBiome(player.getLocation()).equals(player.playerBiome(player.getOldLocation())))
        {
            System.out.println(("You've entered the " + player.playerBiome(player.getLocation()).toString() + " terrain!"));
            return ("You've entered the " + player.playerBiome(player.getLocation()).toString() + " terrain!");
        }
        player.playerBiome(player.getOldLocation()).clearObstacles();
        player.playerBiome(player.getOldLocation()).buildObstacles();
        return null;
    }

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
    
    public void drink(Player p)
    {
        if (p.getWater() < 10)
        {
            throw new IllegalArgumentException("Not enough water to drink");
        }
        else
        {
            if (p.getHealth() == 100)
                throw new IllegalArgumentException("You already have enough health");
            else
            {
                p.subtractWater(10);
                p.addHealth(1);
            }
        }
    }
    
    public void eat(Player p)
    {
        if (p.getFood() < 10)
        {
            throw new IllegalArgumentException("Not enough food to eat");
        }
        else
        {
            if (p.getHealth() == 100)
                throw new IllegalArgumentException("You already have enough health");
            else
            {
                p.subtractFood(10);
                p.addHealth(2);
            }
        }
    }

    public Materials returnMaterial(Player p)
    {
        return p.playerBiome(p.getLocation()).getMaterial((int)p.convertLoc(p.getLocation()).getX(), (int)p.convertLoc(p.getLocation()).getY());
    }

    public String die(Player p)
    {
        if(p.getHealth() <= 0)
        {
            return "";
        }
        return null; 
    }

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
